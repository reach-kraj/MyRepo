package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder IndexOf method returns the index position of First Occurrence of the specified char in the string,
starting at the specified index.
Return type is integer.
 */
public class StringBuilderIndexOfFromInex {
	public static void main(String[] args) {

		StringBuilder s = new StringBuilder("HashMap and HashSet");
		System.out.println(s);

		int a = s.indexOf("Hash", 4);
		System.out.println(a);

	}
}
