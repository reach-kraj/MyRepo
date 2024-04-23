package com.sample.spring;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

public class RedisBeanManager {
    private static StringRedisTemplate stringRedisTemplate;
    private static RedisTemplate<String, String> redisTemplate;
    private static MessageListenerAdapter messageListenerAdapter;
    private static RedisMessageListenerContainer redisMessageListenerContainer;

    public static StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public static void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        RedisBeanManager.stringRedisTemplate = stringRedisTemplate;
    }

    public static RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public static void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        RedisBeanManager.redisTemplate = redisTemplate;
    }

    public static MessageListenerAdapter getMessageListenerAdapter() {
        return messageListenerAdapter;
    }

    public static void setMessageListenerAdapter(MessageListenerAdapter messageListenerAdapter) {
        RedisBeanManager.messageListenerAdapter = messageListenerAdapter;
    }

    public static RedisMessageListenerContainer getRedisMessageListenerContainer() {
        return redisMessageListenerContainer;
    }

    public static void setRedisMessageListenerContainer(RedisMessageListenerContainer redisMessageListenerContainer) {
        RedisBeanManager.redisMessageListenerContainer = redisMessageListenerContainer;
    }
}
