package org.ml.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("hello", "world");
        Assertions.assertEquals("world", redisTemplate.opsForValue().get("hello"));
    }

}
