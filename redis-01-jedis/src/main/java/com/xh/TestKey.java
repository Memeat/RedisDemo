package com.xh;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestKey {
    public static void main(String[] args) {
        //连接redis//
        Jedis jedis = new Jedis("192.168.200.130",6379);

        System.out.println("删除所有数据库中的数据：" + jedis.flushAll());
        System.out.println("选择第几号库：" + jedis.select(0));
        System.out.println("清空当前库数据" + jedis.flushDB());
        System.out.println("清空当前库数据" + jedis.flushDB());

        System.out.println("判断某个键是否存在：" + jedis.exists("username"));
        System.out.println("新增username-zhangsan键值对：" + jedis.set("username","zhangsan"));
        System.out.println("新增password-zhangsan键值对：" + jedis.set("password","zhangsan"));
        System.out.println("显示系统所有键：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password：" + jedis.del("password"));
        System.out.println("查看键username的值的类型：" + jedis.type("username"));
        System.out.println("随机返回key空间的一个：" + jedis.randomKey());
        System.out.println("重命名key：" + jedis.rename("username","name"));
        System.out.println("取出改后的name：" + jedis.get("name"));
        System.out.println("返回当前库中key的数量：" + jedis.dbSize());
    }
}
