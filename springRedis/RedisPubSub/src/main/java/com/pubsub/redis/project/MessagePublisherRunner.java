package com.pubsub.redis.project;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.project.MyMessageComponent;
import com.pubsub.project.RedisMessagePublisherComponent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.pubsub.project.MyMessageComponent;
//import com.pubsub.project.RedisMessagePublisherComponent;

@Component
public class MessagePublisherRunner implements CommandLineRunner {
	
	 public String channelname="Naveen-channel";
	 private MyMessageComponent createMessage() {
		 MyMessageComponent message = new MyMessageComponent();
	        message.setNotificationId(1);
	        message.setSource("source");
	        message.setRecipients(List.of("recipient1", "recipient2"));
	        message.setNotificationMsg("Hello, recipients!");
	        return message;
	    }
	 
    @Autowired
    private RedisMessagePublisherComponent redisMessagePublisher;

    @Override
    public void run(String... args) throws Exception {
    	MyMessageComponent message = createMessage();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(message);
        redisMessagePublisher.setChannel(channelname);
        redisMessagePublisher.publishMessage(channelname, message);
        System.out.println("Message published to channel : "+ channelname);
    }
}
