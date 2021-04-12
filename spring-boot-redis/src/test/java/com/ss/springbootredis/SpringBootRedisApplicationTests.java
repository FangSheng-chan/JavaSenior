package com.ss.springbootredis;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.springbootredis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("k1", "v1");
        Object k1 = redisTemplate.opsForValue().get("k1");
        System.out.println(k1);
    }

    @Test
    public void test1() throws JsonProcessingException {
        User user = new User("ss", 21);
//        String string = new ObjectMapper().writeValueAsString(user);
//        System.out.println(string);
        JSONObject jsonObject = new JSONObject();
        String jsonString = jsonObject.toJSONString(user);
        redisTemplate.opsForValue().set("user", jsonString);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
