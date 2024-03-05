package com.journaldev.spring.jdbc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;
import com.journaldev.spring.jdbc.service.CustomerManager;
import com.journaldev.spring.jdbc.service.CustomerManagerImpl;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CustomerManager customerManager = ctx.getBean("customerManager",CustomerManagerImpl.class);
		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(4);
		customer.setName("raju");
		Address address = new Address();
		address.setId(2);
		address.setCountry("nepal");
		// Setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Albany Dr neuro live call");
		customer.setAddress(address);
		return customer;
	}
}
