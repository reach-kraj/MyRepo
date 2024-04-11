package com.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SampleMessagePublisherRunner {
    
    private SampleRedisMessagePublisher redisMessagePublisher;

    @Autowired
    public SampleMessagePublisherRunner(SampleRedisMessagePublisher redisMessagePublisher) {
        this.redisMessagePublisher = redisMessagePublisher;
    }

//    public void init(int numConcurrentConsumers, String sourceName, List<String> repoList, String notifyMsg) {
//        System.out.println("***********Inside run inside SampleMessagePublisherRunner");
//        SampleMyMessage message= new SampleMyMessage();
//        message.setNotificationId(numConcurrentConsumers);
//        message.setNotificationMsg(notifyMsg);
//        message.setSource(sourceName);
//        
//        for (String repoName : repoList) {
//            redisMessagePublisher.publishMessage(sourceName, repoName, notifyMsg);
//        }
        
        public void init(int id, String source,List<String> recipient,String notificationMsg) throws Exception {
        	System.out.println("***********Inside run inside SampleMessagePublisherRunner");
        	String getChannelName = "Topic";
            SampleMyMessage message = new SampleMyMessage();
            message.setNotificationId(id);
            message.setSource(source);
            message.setRecipients(recipient);
            message.setNotificationMsg(notificationMsg);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            redisMessagePublisher.publishMessage(getChannelName, json);
//            redisMessagePublisher.publishMessage("Tempproject", json);
            System.out.println("Message published to channel: ");
        }
    }
