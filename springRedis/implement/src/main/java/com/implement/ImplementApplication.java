package com.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.sample.SampleMessagePublisherRunner;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.sample"})
public class ImplementApplication {

	 @Autowired
	    private SampleMessagePublisherRunner messagePublisherRunner;

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(ImplementApplication.class, args);
	    }

	    @PostConstruct
	    public void init() throws Exception {
	    	System.out.println("$$$$$$$$$$$$$$$$$$$$inside impapp init");
	        List<String> listtest = new ArrayList<String>();
	        listtest.add("repo11");
	        listtest.add("repo22");
	        listtest.add("repo33");

	        messagePublisherRunner.init(2, "SourceTest", listtest, "Notifymsg");
	    }
}
