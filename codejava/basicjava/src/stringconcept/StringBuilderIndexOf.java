package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder IndexOf method returns the index position of First Occurrence of the specified char in the string.
Return type is integer.
 */
public class StringBuilderIndexOf {

	public static void main(String[] args) {

		StringBuilder s = new StringBuilder("ArrayList and LinkedList");
		System.out.println(s);

		int a = s.indexOf("List");
		System.out.println(a);

	}
}
