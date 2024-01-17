package predefinedjavaclass;

import java.util.LinkedHashSet;

public class LinkedHashSetConcept {
	public static void main(String[] args) 
    { 
  
        // Creating an empty LinkedHashSet of string type 
        LinkedHashSet<String> lHashSet 
            = new LinkedHashSet<String>(); 
  
        // Adding element to LinkedHashSet 
        // using add() method 
        lHashSet.add("A"); 
        lHashSet.add("B"); 
        lHashSet.add("C"); 
        lHashSet.add("D"); 
  
        // Note: This will not add new element 
        // as A already exists 
        lHashSet.add("A"); 
        lHashSet.add("E"); 
  
        // Getting size of LinkedHashSet 
        // using size() method 
        System.out.println("Size of LinkedHashSet = "
                           + lHashSet.size()); 
  
        System.out.println("Original LinkedHashSet:"
                           + lHashSet); 
  
        // Removing existing entry from above Set 
        // using remove() method 
        System.out.println("Removing D from LinkedHashSet: "
                           + lHashSet.remove("D")); 
  
        // Removing existing entry from above Set 
        // that does not exist in Set 
        System.out.println( 
            "Trying to Remove Z which is not "
            + "present: " + lHashSet.remove("Z")); 
  
        // Checking for element whether it is present inside 
        // Set or not using contains() method 
        System.out.println("Checking if A is present="
                           + lHashSet.contains("A")); 
  
        // Now lastly printing the updated LinkedHashMap 
        System.out.println("Updated LinkedHashSet: "
                           + lHashSet); 
    } 
}
