package stringconcept;

import java.lang.StringBuilder;

/*
StringBuilder HashCode method returns the HashCode value of the object.
Return type is integer.
If two objects are equal by StringBuilder Equals method then their Hashcode values 
will also be same.
 */
public class StringBuilderHashCode {
	public static void main(String[] args) {

		StringBuilder s = new StringBuilder("Java");
		StringBuilder a = new StringBuilder("Java");
		StringBuilder b = new StringBuilder("Spring");

		int s1 = s.hashCode();
		System.out.println(s1);

		int a1 = a.hashCode();
		System.out.println(a1);

		int b1 = b.hashCode();
		System.out.println(b1);

	}
}
