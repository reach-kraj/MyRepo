package com.redis.project.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

public class RedisRunner {

	String channelName = "REDIS-CHANNEL";

	private RedisPublisher redisMessagePublisher;

	public RedisRunner(RedisPublisher redisMessagePublisher) {
		this.redisMessagePublisher = redisMessagePublisher;
	}

	@PostConstruct
	public void init() throws Exception {
		System.out.println("***********Inside run inside SampleMessagePublisherRunner");
		RedisMessage message = new RedisMessage();
		message.setNotificationId(2);
		message.setSource("Test-source");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(message);
		redisMessagePublisher.publishMessage(json);
		System.out.println("Message published to channel");
	}
}
