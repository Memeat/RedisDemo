package com.xh;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestSW {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.select(6);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","zhangsan");
        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();

        try {
            multi.set("user1",result);
            multi.set("user2",result);
//            int i = 1/0; //让代码抛出异常，事务执行失败
            multi.exec(); //执行事务
        } catch (Exception e) {
            multi.discard(); //放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close(); //关闭连接
        }
    }
}
