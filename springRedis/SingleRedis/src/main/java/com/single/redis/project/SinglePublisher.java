package com.single.redis.project;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SinglePublisher {
	
	String channelName="Redis-Sample";
	
	 private final StringRedisTemplate redisTemplate;
	 
	 public SinglePublisher(StringRedisTemplate redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
	   
	 public void sendToRedis(int id,String source,String NotifyMsg) throws Exception {
     	SingleMessage message = new SingleMessage();
         message.setNotificationId(id);
         message.setSource(source);
         message.setNotificationMsg(NotifyMsg);
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(message);
         publishMessage(channelName, json);
         System.out.println("Message published to channel: "+channelName);
     }

	    public void publishMessage(String topic, String message) {
	        redisTemplate.convertAndSend(topic, message);
	    }
	   
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(new SingleSubscriber());
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new ChannelTopic(channelName));
        return container;
    }

}

