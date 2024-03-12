package com.mycompany.demotest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SampleTestCases {
	
	ArrayList getSampleList() {
		return new ArrayList();
	}
	
	int sum() {
		return 10;
	}
	
	void checkPaymentStatus() {
		throw new IllegalArgumentException("Payment service is down");
	}
	
	@BeforeAll
	static void setupTestSuite() {
		System.out.println("Initialization for all test cases");
	}
	
	@BeforeEach
	void setupTestCases() {
		System.out.println("Initialization for individual test case");
	}
	
	@AfterEach
	void cleanUpTestCases() {
		System.out.println("Cleanup for individual test case");
	}
	
	@AfterAll
	static void cleanupTestSuite() {
		System.out.println("Cleanup for all test cases");
	}

	@Test
    void basicAssertions() {
        assertEquals(3, 3);
        assertEquals(10, sum(), "Sum test case failed.");
        assertTrue('a' < 'b', "Condition not met");
    }
	
	@Test
	public void arrayAssertion() {
	    char[] expected = { 'J', 'a', 'v', 'a' };
	    char[] actual = { 'p', 'a', 'v', 'a' };

	    assertArrayEquals(expected, actual, "Arrays does not match");
	}
	
	@Test
	public void nullChecks() {
		ArrayList responseList = getSampleList();
	    assertNotNull(responseList, "The list is null and test failed");

	}
	
	@Test
	public void exceptionTest() {
		
	    Throwable exception = assertThrows(
	      IllegalArgumentException.class, 
	      	()->{
	      			checkPaymentStatus();
	      		} 
	    );
	    assertEquals("Payment service is down", exception.getMessage());
	}
	
	
}
