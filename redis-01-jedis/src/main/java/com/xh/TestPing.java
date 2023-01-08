package com.xh;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);
        //测试是否连接redis成功
        System.out.println(jedis.ping());
        //关闭连接
        jedis.close();
    }
}
