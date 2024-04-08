//1723. Find Minimum Time to Finish All Jobs
package javacode;

public class Test {
    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            int result = divide(10, 2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Catching specific exception
        	e.printStackTrace();
            System.out.println("Error: Division by zero");
        } 
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
