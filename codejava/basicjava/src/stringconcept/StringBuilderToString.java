package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder ToString method returns a string representing the data in the given sequence.
StringBuilder ToString method has been implemented from CharSequence interface. 
 */
public class StringBuilderToString {
	public static void main(String[] args) {

		StringBuilder a = new StringBuilder("Servlet");
		System.out.println(a);

		String b = a.toString();
		System.out.println(b);

	}
}
