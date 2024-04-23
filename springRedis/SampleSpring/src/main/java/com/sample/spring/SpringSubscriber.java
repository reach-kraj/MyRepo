package com.sample.spring;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class SpringSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
    	System.out.println("***********Inside Subscriber inside onMessage");

        String channel = new String(message.getChannel());
        String messageBody = new String(message.getBody());
        System.out.println(".........../////////////////////channel and msg print.......");
        System.out.println("Received message: " + messageBody + " from channel: " + channel);
    }
}
