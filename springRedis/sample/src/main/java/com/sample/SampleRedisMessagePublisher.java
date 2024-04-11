package com.sample;

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
public class SampleRedisMessagePublisher {
	
	 private final StringRedisTemplate redisTemplate;

	    public SampleRedisMessagePublisher(StringRedisTemplate redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
	   
	    public void publishMessage(@Qualifier("topic")String topic, String message) {
	        redisTemplate.convertAndSend(topic, message);
	    }
	    @Bean
	    public String topic() {
	        return "Topic";
	    }

	    
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    	System.out.println("***********Inside bean inside redisTemplate");
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
    	System.out.println("***********Inside bean inside messageListenerAdapter");
        return new MessageListenerAdapter(new SampleRedisMessageSubscriber());
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
    	System.out.println("***********Inside bean inside redisMessageListenerContainer");
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new ChannelTopic("Topic"));
        return container;
    }
}

