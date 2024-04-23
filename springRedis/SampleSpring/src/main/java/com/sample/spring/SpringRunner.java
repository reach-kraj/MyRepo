//package com.sample.spring;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//public class SpringRunner {
//    
//    private SpringPublisher redisMessagePublisher;
//
//    @Autowired
//    public SpringRunner(SpringPublisher redisMessagePublisher) {
//    	System.out.println("............................springrunner constructor");
//        this.redisMessagePublisher = redisMessagePublisher;
//    }
//        
//    public void init(int id, String source, List<String> recipient, String notificationMsg) throws Exception {
//        	System.out.println("***********Inside init inside SpringRunner");
//            SpringMessage message = new SpringMessage();
//            message.setNotificationId(id);
//            message.setSource(source);
//            message.setRecipients(recipient);
//            message.setNotificationMsg(notificationMsg);
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(message);
//            redisMessagePublisher.publishMessage(json);
//        }
//    }
