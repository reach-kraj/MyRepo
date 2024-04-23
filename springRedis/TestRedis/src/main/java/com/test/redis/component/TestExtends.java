package com.test.redis.component;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.template.redis.TempBean;
import com.template.redis.TempMessage;

@Component
public class TestExtends extends TempBean {


	
	String channelName = "test-redis";
	
	  @PostConstruct
	public void publishmsg() {
		TempMessage msg=new TempMessage();
		
		System.out.println("|||||||||||||||||||||||||||||||");
		msg.setNotificationId(1);
		msg.setNotificationMsg("REDIS-TEMP");
		publishMessage(msg);
		//redisTemplate.convertAndSend(channelName, msg);
	}

	@Override
	public String getTopic() {
		return channelName;
	}
}
