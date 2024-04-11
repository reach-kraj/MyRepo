package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleApplication.class, args);
		
//		List<String> testList=new ArrayList<String>();
//		testList.add("rep1");
//		testList.add("rep2");
//		testList.add("rep3");
//		SampleMessagePublisherRunner objrunner= new SampleMessagePublisherRunner();
//		objrunner.init(2, "testsource", testList, "notifytest");
	}
}
