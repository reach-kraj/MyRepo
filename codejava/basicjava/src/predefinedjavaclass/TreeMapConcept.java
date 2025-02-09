package predefinedjavaclass;

import java.util.TreeMap;

public class TreeMapConcept {
	public static void main(String args[])
    {
        TreeMap<Integer, String> tm
            = new TreeMap<Integer, String>();
 
        tm.put(3, "BMW");
        tm.put(2, "Audi");
        tm.put(1, "Suzuki");
        tm.put(4, "Honda");
 
        System.out.println("Original TreeMap:");
        System.out.println(tm);
 
        tm.remove(4);
 
        System.out.println("Updated TreeMap:");
        System.out.println(tm);
    }
}
