package com.mycompany.demotest;

import static org.mockito.Mockito.*;

import java.util.*;

public class MockitoTest {
	
	//mock creation
	static List mockedList = mock(List.class);

	public static void testClear() {
		mockedList.clear();
	}
	
	public static void main(String[] args) {

		 //using mock object
		 mockedList.add("one");
		 mockedList.clear();

		 //verification
		 verify(mockedList).add("one");
		 verify(mockedList).clear();
		 
		 when(mockedList.get(0)).thenReturn("Zero element got added");
		 System.out.println(mockedList.get(0));
		 
		//caught and printed to continue the test.
		 try {
			 when(mockedList.get(1)).thenThrow(new RuntimeException());
			 System.out.println(mockedList.get(1));
		 }catch(Exception e) {
			 
			 e.printStackTrace();
		 }
		 
		 System.out.println(mockedList.get(9));
		 
		 doThrow(new RuntimeException()).when(mockedList).clear();
		 try {
			 testClear();
		 }catch(Exception e) {
			 
			 e.printStackTrace();
		 }
		 
		 HashMap hmap = mock(HashMap.class);
		 
		 doNothing().
		   doThrow(new RuntimeException())
		   .when(hmap).clear();
		 
		 hmap.clear();
		 try {
			 hmap.clear();
		 }catch(Exception e) {
			 
			 e.printStackTrace();
		 }
		 
		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");
		 
		 verify(mockedList, times(5)).add("three times");
		 
		 List listObj = new LinkedList();
		 List spyList = spy(listObj);
		 
		 
		
		   when(spyList.size()).thenReturn(100);

		   spyList.add("one");
		   spyList.add("two");

		   System.out.println(spyList.size());
		   
		   
		 System.out.println("-----------end----------");
	}

}
