package javacode;

import java.util.Arrays;

class InvalidDataException extends Exception{
	//invalidDataException is a custom error class 
	//always custom exp class should extends to other exp child class or exception parent class
	public  InvalidDataException(String message) {
		//to call the given string from error method @InvalidDataException "super" keyword is used
		super(message);
	}
}

public class Account {
	//method has to throws the Exception class
	public void salaryCheck(double salary)throws InvalidDataException {
		if(salary<0) {
			//predicting the error and throwing it  
			throw new InvalidDataException("Invalid");
		}else {
			//Else block run if input is valid
			System.out.println("Salary is: "+salary);
		}
	}
	public static void main(String[] args)  {
		double salary=-30000.78;//(-)error value
		Account a1=new Account();
		try {
			//the code could contain error is mentioned in try 
			a1.salaryCheck(salary);
		}
		catch(InvalidDataException e) {
			//handling the error
			System.out.println("Please enter valid number: error "+e);
		}
		//sample code to confirm that error has been handled perfectly
		int[] a = {1,2,3,4,5,6} ;
		int n = a.length;
		int p = 2;
		int x = 9;
		int[] b = new int[n+1];
		for(int i=0; i<n+1; i++) {
			if(i<p) {
				b[i] = a[i];
			}else if(i == p) {
				b[i] = x;
			}else{
				b[i] = a[i-1];
			}
		}
		System.out.print("Final Array : " + Arrays.toString(b));
	}	
}

