package com.example.demo.publisher;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;

@Component
public class DemoRedisMessagePublisher {
	
	String channelName = "REDIS-CHANNEL";
	

	 private final StringRedisTemplate redisTemplate;
	

	    public DemoRedisMessagePublisher(StringRedisTemplate redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
	   
	    public void publishMessage(String message) {
	        redisTemplate.convertAndSend(channelName, message);
	    }
	    
		 @PostConstruct
			public void init() throws Exception {
				DemoMyMessage message = new DemoMyMessage();
				message.setNotificationId(2);
				message.setSource("Test-source");
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(message);
				publishMessage(json);
				System.out.println("Message published to channel");
			}

}

