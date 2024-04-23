package com.template.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;


import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.listener.ChannelTopic;


public abstract class TempBean {
	
	
	
	

    @Autowired
    @Qualifier("customRedisTemplate")
    protected RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;
    
    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic(getTopic());
    }
    
    public abstract String getTopic();
//    public TempBean(StringRedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//   
    public void publishMessage(TempMessage message) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), message);
    }
//    
//    @Bean
//    public String topic() {
//        return "Topic";
//    }
    
//	 @Bean(name = "customRedisTemplate")
//public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//	System.out.println("***********Inside bean inside redisTemplate");
//    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//    redisTemplate.setConnectionFactory(redisConnectionFactory);
//    redisTemplate.setKeySerializer(new StringRedisSerializer());
//    redisTemplate.setValueSerializer(new StringRedisSerializer());
//    return redisTemplate;
//}


//@Bean
//public RedisMessageListenerContainer redisMessageListenerContainer(
//        RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
//    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//    container.setConnectionFactory(redisConnectionFactory);
//    container.addMessageListener(messageListenerAdapter, new ChannelTopic("Topic"));
//    return container;
//}

}