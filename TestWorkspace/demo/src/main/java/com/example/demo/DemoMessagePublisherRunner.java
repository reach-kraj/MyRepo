package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component
public class DemoMessagePublisherRunner {
    
    private DemoRedisMessagePublisher redisMessagePublisher;

    @Autowired
    public DemoMessagePublisherRunner(DemoRedisMessagePublisher redisMessagePublisher) {
        this.redisMessagePublisher = redisMessagePublisher;
    }
    @PostConstruct    
    public void init() throws Exception {
        	System.out.println("***********Inside run inside SampleMessagePublisherRunner");
        	String getChannelName = "Topic";
            DemoMyMessage message = new DemoMyMessage();
            message.setNotificationId(2);
            message.setSource("Test-source");
            ObjectMapper mapper = new ObjectMapper();
          String json = mapper.writeValueAsString(message);
            redisMessagePublisher.publishMessage(getChannelName, json);
            System.out.println("Message published to channel: "+getChannelName);
        }
    }
