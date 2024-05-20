package stringconcept;
/*
Appends the specified String to the Character sequence. 
 */

public class StringBufferConcepts {
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Exception");

		System.out.println("Example of StringBuffer: " + sb);

		// Append
		System.out.println(" ");
		sb.append("Handling");
		System.out.println("After Appended: " + sb);

		// charAt
		System.out.println(" ");
		char sbChatAt = sb.charAt(3);
		System.out.println("CharAt the given Index 3 is: " + sbChatAt);

		// delete
		System.out.println(" ");
		System.out.println("After Deleting: " + sb.delete(0, 4));

		// deleteCharAt
		System.out.println(" ");
		System.out.println("After Deleting CharAt 6: " + sb.deleteCharAt(6));

		// index of
		System.out.println(" ");
		int charAt = sb.indexOf("H");
		System.out.println("Char 'H' is at index: " + charAt);

		//Length
		System.out.println(" ");
		int lengthofString=sb.length();
	    System.out.println("Length of Given String: "+lengthofString);

	    
	    //replace
	    System.out.println(" ");
	    System.out.println(sb.replace(9, 12, "Candid Java"));
	    
	    //reverse
	    System.out.println(" ");
	    System.out.println("Given String Reverse: "+sb.reverse());
	    
	    //Substring
	    System.out.println(" ");
	    System.out.println("SubString of given word: "+sb.substring(0, 12));
	}
}
