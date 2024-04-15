package com.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.DemoMessagePublisherRunner;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.example.demo"})
public class ImpDemoApplication {

    @Autowired
    private DemoMessagePublisherRunner demoMessagePublisherRunner;

    public static void main(String[] args) {
        SpringApplication.run(ImpDemoApplication.class, args);
    }

    public void init() throws Exception {
        demoMessagePublisherRunner.init();
    }
}
