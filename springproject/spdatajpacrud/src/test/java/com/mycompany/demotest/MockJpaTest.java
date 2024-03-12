package com.mycompany.demotest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mycompany.jpa.data.DepartmentCrud;

@ExtendWith(SpringExtension.class)
public class MockJpaTest {

	 @Mock
	 DepartmentCrud deptRepository;
	 
	 @Test
	    public void deptCountTest() {
	        Mockito.when(deptRepository.count()).thenReturn(123L);

	        long userCount = deptRepository.count();

	        assertEquals(123L, userCount);
	        Mockito.verify(deptRepository).count();
	    }
	 
	 @Test
	    void simpleHelloTest() {
	        assertTrue("Hello World".equals("Hello World"));
	    }
}
