package com.pubsub.redis.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisMessagePublisher {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void publishMessage(String topic, String msg) {
        redisTemplate.convertAndSend(topic, msg);
    }
}

