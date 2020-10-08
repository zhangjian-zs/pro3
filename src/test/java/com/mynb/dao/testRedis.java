package com.mynb.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class testRedis {
    @Autowired
    private RedisTemplate<String, Object> template;

    @Test
    public void testR(){

        template.opsForValue().set("key1", "value1");
        System.out.println(template.opsForValue().get("key1"));

    }
}
