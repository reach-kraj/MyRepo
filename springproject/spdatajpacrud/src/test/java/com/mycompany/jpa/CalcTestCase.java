package com.mycompany.jpa;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; 

@SpringBootTest
public class CalcTestCase {
	
	@Autowired
	private Calculation calc;

	@Test
    void testGet() {
        assertEquals(8, calc.sum(3, 4));
    }
	    
}
