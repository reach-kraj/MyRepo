package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder SubSequence method returns the sequence of character values 
which is a subsequence of the given string.
Here the start index position value is inclusive and end index position value is exclusive.

StringBuilder SubSequence method has been implemented from CharSequence interface. 
 */
public class StringBuilderSubSequence {
	public static void main(String[] args) {

		StringBuilder s = new StringBuilder("Sub Sequence Method");
		System.out.println(s);

		System.out.println(s.subSequence(0, 12));

	}
}
