package com.pubsub.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class MessagePublisherRunnerComponent  {

   RedisMessagePublisherComponent redisMessagePublisher;
    private String channelName;
    public String getChannelName() {
		return channelName;
	}

	private String message;
    public String channeltext=channelName;

//    public MessagePublisherRunner(RedisMessagePublisher redisMessagePublisher) {
//        this.redisMessagePublisher = redisMessagePublisher;
//    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        MyMessage myMessage = createMessage();
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(myMessage);
//        redisMessagePublisher.publishMessage(channelName, json);
//        System.out.println("Message published to channel: " + channelName);
//    }
    
    //@Override
    public void sendToRedisTopic(String topic, MyMessageComponent msg) throws Exception {
        //MyMessage myMessage = createMessage();
        //ObjectMapper mapper = new ObjectMapper();
        //String json = mapper.writeValueAsString(myMessage);
        redisMessagePublisher.publishMessage(topic, msg);
        System.out.println("Message published to channel: " + channelName);
    }
//
//    private MyMessageComponent createMessage() {
//        MyMessageComponent myMessage = new MyMessageComponent();
//        myMessage.setNotificationId(1);
//        myMessage.setSource("source");
//        myMessage.setRecipients(List.of("recipient1", "recipient2"));
//        myMessage.setNotificationMsg(message);
//        return myMessage;
//    }
}