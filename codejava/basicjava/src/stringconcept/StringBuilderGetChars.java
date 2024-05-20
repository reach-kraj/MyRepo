package stringconcept;

import java.lang.StringBuilder;
/*
Characters in the StringBuilder sequence are copied to a Character array.
The value at the 1st parameter denotes the first character to be copied,
The value at the 2nd parameter denotes upto which character to be copied,
The value at the 3rd parameter denotes where the characters are to be copied i.e destination
The value at the 4th parameter denotes from which position the copied values are to be stored

*/
public class StringBuilderGetChars 
{
public static void main(String[] args) 
{

	StringBuilder s=new StringBuilder("ArrayList");
	System.out.println(s);
	
	char[] a=new char[20];
	s.getChars(0, 5, a, 2);
	
	System.out.println(a);
	
}
}

