package com.redis.demo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MessagePublisherRunner {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;
    
    @PostConstruct
    public void runs(){
        String channel = "my-channel";
        String message = "SampleTest Redis!";
        redisMessagePublisher.publishMessage(channel, message);
        System.out.println("Message published to channel: " + channel);
    }
}
