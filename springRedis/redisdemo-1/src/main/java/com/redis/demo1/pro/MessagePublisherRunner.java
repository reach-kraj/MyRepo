package com.redis.demo1.pro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisherRunner implements CommandLineRunner {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Override
    public void run(String... args) throws Exception {
        MyMessage message = createMessage();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(message);
        redisMessagePublisher.publishMessage("Test-channel", json);
        System.out.println("Message published to channel: Test-channel");
    }

    private MyMessage createMessage() {
        MyMessage message = new MyMessage();
        message.setNotificationId(1);
        message.setSource("source");
        message.setRecipients(List.of("recipient1", "recipient2"));
        message.setNotificationMsg("Hello, recipients!");
        return message;
    }
}
