package com.xh;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class TestHash {
    public static void main(String[] args) {
        //连接redis//
        //连接redis//
        //master
        //hot-fix test
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.select(4);
        jedis.flushDB();

        Map<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.put("k4","v4");

        System.out.println("添加一个名为hash的map：" + jedis.hmset("hash",map));
        System.out.println("往hash中添加键值对：" + jedis.hset("hash", "k5","v5"));
        System.out.println("获取hash中的值：" + jedis.hget("hash", "k5"));
        System.out.println("获取hash中的多个值：" + jedis.hmget("hash", "k4","k5"));


        System.out.println("显示hash中所有的键值对：" + jedis.hgetAll("hash"));
        System.out.println("显示hash中所有的键：" + jedis.hkeys("hash"));
        System.out.println("显示hash中所有的值：" + jedis.hvals("hash"));

        System.out.println("将k6的值+1，没有k6则新增：" + jedis.hincrBy("hash","k6",1));
        System.out.println("显示hash中所有的键值对：" + jedis.hgetAll("hash"));
        System.out.println("将k6的值+1，没有k6则新增：" + jedis.hincrBy("hash","k6",1));
        System.out.println("显示hash中所有的键值对：" + jedis.hgetAll("hash"));

        System.out.println("删除一个或多个键值对：" + jedis.hdel("hash","k1","k2"));
        System.out.println("显示hash中所有的键值对：" + jedis.hgetAll("hash"));

        System.out.println("显示hash中所有的键值对个数：" + jedis.hlen("hash"));
        System.out.println("判断hash中是否存在指定字段：" + jedis.hexists("hash","k3"));

    }
}
