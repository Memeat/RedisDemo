package com.xh;

import redis.clients.jedis.Jedis;

public class TestList {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("192.168.200.130",6379);

        jedis.select(2);
        jedis.flushDB();

        jedis.lpush("list", "a");
        jedis.lpush("list", "b","c","b","e","b");
        System.out.println("往list中增加和查询元素：" + jedis.lrange("list",0,-1));
        System.out.println("从左往右删除几个指定的元素：" + jedis.lrem("list", 1,"b"));
        System.out.println("查询元素：" + jedis.lrange("list",0,-1));
        System.out.println("左端出栈一个元素：" + jedis.lpop("list"));
        System.out.println("查询元素：" + jedis.lrange("list",0,-1));
        System.out.println("右端出栈一个元素：" + jedis.rpop("list"));
        System.out.println("查询元素：" + jedis.lrange("list",0,-1));
        System.out.println("获取指定下标的元素：" + jedis.lindex("list",0));
        System.out.println("修改指定下标的元素：" + jedis.lset("list",0,"a"));
        System.out.println("查询元素：" + jedis.lrange("list",0,-1));
        System.out.println("获取长度：" + jedis.llen("list"));

        jedis.lpush("list2", "3","6","2","0","4");
        System.out.println("排序前：" + jedis.lrange("list2",0,-1));
        System.out.println("排序后：" + jedis.sort("list2"));
    }
}
