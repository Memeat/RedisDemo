package com.xh;

import redis.clients.jedis.Jedis;

public class TestSet {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.select(3);
        jedis.flushDB();

        System.out.println("往set中增加元素：" + jedis.sadd("set","e1","e2","e3","e4","e4","e4","e5","e6","e7","e8"));
        System.out.println("查看set所有元素：" + jedis.smembers("set"));
        System.out.println("判断set中是否有某元素：" + jedis.sismember("set","e1"));
        System.out.println("获取set中元素的个数：" + jedis.scard("set"));
        System.out.println("删除set中指定元素：" + jedis.srem("set","e5","e6"));
        System.out.println("查看set所有元素：" + jedis.smembers("set"));
        System.out.println("随机查看set中n个元素：" + jedis.srandmember("set",2));
        System.out.println("查看set所有元素：" + jedis.smembers("set"));
        System.out.println("随机删除set中n个元素：" + jedis.spop("set",2));
        System.out.println("查看set所有元素：" + jedis.smembers("set"));

        System.out.println("往set1中增加元素：" + jedis.sadd("set1","e1","e2","e3","e4","e5","e6","e7","e8"));
        System.out.println("往set2中增加元素：" + jedis.sadd("set2","e11","e22","e33","e4","e5"));
        System.out.println("移动set1中指定的值到set2中：" + jedis.smove("set1","set2","e1"));
        System.out.println("查看set1所有元素：" + jedis.smembers("set1"));
        System.out.println("查看set2所有元素：" + jedis.smembers("set2"));

        System.out.println("查看set1和set2的交集：" + jedis.sinter("set1","set2"));
        System.out.println("查看set1和set2的并集：" + jedis.sunion("set1","set2"));
        System.out.println("查看set1和set2的差集：" + jedis.sdiff("set1","set2"));
        System.out.println("查看set1和set2的交集并存储到setinter：" + jedis.sinterstore("setinter","set1","set2"));
        System.out.println("查看setinter所有元素：" + jedis.smembers("setinter"));
        System.out.println("查看set1和set2的并集并存储到setunion：" + jedis.sunionstore("setunion","set1","set2"));
        System.out.println("查看setunion所有元素：" + jedis.smembers("setunion"));
        System.out.println("查看set1和set2的差集并存储到setdiff：" + jedis.sdiffstore("setdiff","set1","set2"));
        System.out.println("查看setdiff所有元素：" + jedis.smembers("setdiff"));

    }
}
