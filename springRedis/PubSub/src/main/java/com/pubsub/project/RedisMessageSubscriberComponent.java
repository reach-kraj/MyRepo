package com.pubsub.project;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageSubscriberComponent implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String messageBody = new String(message.getBody());
        System.out.println("Received message: " + messageBody + " from channel: " + channel);
    }
}
