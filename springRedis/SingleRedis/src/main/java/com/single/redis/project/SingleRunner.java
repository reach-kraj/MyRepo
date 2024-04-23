package com.single.redis.project;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SingleRunner {

	private SinglePublisher redisMessagePublisher;

	public SingleRunner(SinglePublisher redisMessagePublisher) {
		this.redisMessagePublisher = redisMessagePublisher;
	}

	@PostConstruct
	public void error() throws Exception {
		int i = 0;
		if (i == 0) {
			redisMessagePublisher.sendToRedis(1, "source-test", "123456788");
		}
	}
}
