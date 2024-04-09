package com.redis.demo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisherRunner implements CommandLineRunner {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Override
    public void run(String... args) throws Exception {
        String channel = "my-channel";
        String message = "SampleTest Redis!";
        redisMessagePublisher.publishMessage(channel, message);
        System.out.println("Message published to channel: " + channel);
    }
}
