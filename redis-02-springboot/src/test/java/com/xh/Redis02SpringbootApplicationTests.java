package com.xh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xh.pojo.User;
import com.xh.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        //获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

//        基本的事务可以直接通过redisTemplate操作，如事务

        //redisTemplate操作不同的数据类型
        //opsForValue 操作字符串，类似于String
        //opsForList 操作List，类似于List
        //opsForSet
        //opsForHash
        //opsForZset
        //opsForGeo
        //opsForHyperLogLog
        redisTemplate.opsForValue().set("k1","值1");
        System.out.println(redisTemplate.opsForValue().get("k1"));


    }

    @Test
    public void test() throws JsonProcessingException {
        //使用json来传递对象
        User user = new User("张三", 3);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    /**
     * @Description: 测试使用RedisUtil
     * @Author: 薛航
     * @Date: 2022/12/30
     **/
    @Test
    public void testRedisUtil(){
        redisUtil.set("name","张三");
        System.out.println(redisUtil.get("name"));
    }

}
