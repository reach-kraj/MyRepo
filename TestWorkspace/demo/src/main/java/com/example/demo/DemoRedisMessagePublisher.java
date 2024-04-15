package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class DemoRedisMessagePublisher {
	
	 private final StringRedisTemplate redisTemplate;

	    public DemoRedisMessagePublisher(StringRedisTemplate redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
	   
	    public void publishMessage(@Qualifier("topic")String topic, String message) {
	        redisTemplate.convertAndSend(topic, message);
	    }
}

