package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder Length method returns the length of the given string i.e. 
Number of characters in the string.
Return type is integer.
StringBuilder Length method has been implemented from CharSequence interface.
 */
public class StringBuilderLength {
	public static void main(String[] args) {

		StringBuilder s1 = new StringBuilder("Inheritance");
		System.out.println(s1);

		int a = s1.length();
		System.out.println(a);

	}
}
