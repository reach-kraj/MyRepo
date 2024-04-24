package com.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run( KafkaDemoApplication.class , args);
	}
}

//	Start Zookeeper

//	Start Kafka

//  Run As Java Application

//	C:\kafka_2.13-3.5.0\bin\windows>kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic java_in_use_topic --from-beginning

//  Postman > Get

//	http://localhost:8080/javainuse-kafka/producer?message="Insert your message"
