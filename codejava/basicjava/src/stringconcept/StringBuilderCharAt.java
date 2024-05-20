package stringconcept;

import java.lang.StringBuilder;
/*
Returns the char value at the specified index position in the string.
StringBuilder charAt method has been implemented from Char Sequence interface.
*/
public class StringBuilderCharAt 
{
public static void main(String[] args) 
{

	StringBuilder b=new StringBuilder("Java DataBase Connection");
	System.out.println(b);
	
	char c=b.charAt(5);
	System.out.println(c);

	char d=b.charAt(9);
	System.out.println(d);
	
}
}

