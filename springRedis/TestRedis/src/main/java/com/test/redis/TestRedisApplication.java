package com.test.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.test.redis.component"})
public class TestRedisApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestRedisApplication.class, args);

	}
}
