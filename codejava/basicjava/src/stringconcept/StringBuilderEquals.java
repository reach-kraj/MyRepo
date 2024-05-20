package stringconcept;

import java.lang.StringBuilder;
/*
 Checks whether some other object is equal to the given object.Return type is boolean.
 Returns true if the object is the same as the given object,
 if not returns false.
 */
public class StringBuilderEquals 
{
public static void main(String[] args)
{

	StringBuilder sb=new StringBuilder("Candid Java");
	StringBuilder sb1=new StringBuilder("Candid Java");
	
	boolean a=sb1.equals(sb);
	System.out.println(a);

	boolean b=sb.equals(sb);
	System.out.println(b);
	
}
}

