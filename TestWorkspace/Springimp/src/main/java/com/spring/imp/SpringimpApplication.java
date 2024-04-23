package com.spring.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.sample.spring.SpringRunner;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.sample.spring"})
public class SpringimpApplication {

	@Autowired
	private SpringRunner springRunner;

	public static void main(String[] args) {
		SpringApplication.run(SpringimpApplication.class, args);
	}
	 @PostConstruct
	    public void init() throws Exception {
		 System.out.println("............................inside implement class ");
	        List<String> listtest = new ArrayList<String>();
	        listtest.add("repo100");
	        listtest.add("repo200");
	        listtest.add("repo3000");
	        System.out.println("///////////////////////////before invoking init methos in jar ");
	        springRunner.init(2, "Source-Test", listtest, "Notify-msg-test-ack");
	    }

}
