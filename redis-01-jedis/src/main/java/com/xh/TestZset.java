package com.xh;

import redis.clients.jedis.Jedis;

public class TestZset {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.select(5);
        jedis.flushDB();


    }
}
