package com.xh;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class TestString {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.select(1);
        jedis.flushDB();

        jedis.set("key1","value1");
        System.out.println("用append往key1的值后追加字符串：" + jedis.append("key1","append1"));
        System.out.println("获取key1的值：" + jedis.get("key1"));
        System.out.println("同时增加多个键值对：" + jedis.mset("key2","value2","key3","value3","key4","value4"));
        System.out.println("同时获取多个键值对：" + jedis.mget("key1","key2","key3","key4","key5"));
        System.out.println("同时删除多个键值对：" + jedis.del("key1","key2"));
        System.out.println("同时获取多个键值对：" + jedis.mget("key1","key2","key3","key4","key5"));

        System.out.println("key不存在才创建：" + jedis.setnx("key1","value1"));
        System.out.println("若key之前已存在则不创建，也不会覆盖原值：" + jedis.setnx("key3","newvalue3"));
        System.out.println("同时获取多个键值对：" + jedis.mget("key1","key2","key3","key4","key5"));

        System.out.println("用setex设置过期时间：" + jedis.setex("key6",2,"value6"));
        System.out.println("查询key6：" + jedis.get("key6"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("睡眠3秒后查询key6：" + jedis.get("key6"));

        System.out.println("先获取再设置：" + jedis.getSet("key3","key3getset"));
        System.out.println("查询key3：" + jedis.get("key3"));
    }
}
