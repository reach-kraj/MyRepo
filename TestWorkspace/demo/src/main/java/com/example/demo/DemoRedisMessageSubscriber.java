package com.example.demo;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class DemoRedisMessageSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
    	System.out.println("***********Inside Subscriber inside onMessage");
        String channel = new String(message.getChannel());
        String messageBody = new String(message.getBody());
        System.out.println("Received message: " + messageBody + " from channel: " + channel);
    }
}
