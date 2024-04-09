package com.pubsub.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pubsub.project.MessagePublisherRunnerComponent;
import com.pubsub.project.MyMessageComponent;

@SpringBootApplication
public class RedisPubSubApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RedisPubSubApplication.class, args);
		MessagePublisherRunnerComponent messagePublisherRunnerComponentObj = new MessagePublisherRunnerComponent();
		MyMessageComponent myMessageComponentObj = new MyMessageComponent();
		myMessageComponentObj.setNotificationId(1);
		myMessageComponentObj.setNotificationMsg("first");
		myMessageComponentObj.setSource("chennai");
		
		List<String> recipients = new ArrayList<String>();
		recipients.add("person1");
		recipients.add("Person2");
		
		myMessageComponentObj.setRecipients(recipients);
		messagePublisherRunnerComponentObj.sendToRedisTopic("redis-up",myMessageComponentObj );
	}

}
