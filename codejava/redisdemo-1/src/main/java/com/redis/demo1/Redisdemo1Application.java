package com.redis.demo1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication
public class Redisdemo1Application {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(Redisdemo1Application.class, args);
       
    }

}
