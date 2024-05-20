package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder SetCharAt method sets the given Character value at the specified index.
 */
public class StringBuilderSetCharAt {
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("HashSet");
		System.out.println(sb);

		sb.setCharAt(4, 'G');
		System.out.println(sb);

	}
}
