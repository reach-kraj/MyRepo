package com.mycompany.jpa;

import org.springframework.stereotype.Component;

@Component
public class Calculation {
	
	public int sum(int i1, int i2) {
		return i1+i2;
	}

	public int minus(int i1, int i2) {
		return i1+i2-5;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
