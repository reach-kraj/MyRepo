package advancejava;

import java.util.Arrays;
import java.util.List;

public class ForEachMethod {
public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
//		for(int i=0;i<list.size();i++) { // iterate the list using for loop
//			System.out.println("Printing the elements in the list : "+list.get(i));
//		}
		
//		for(int j : list) { // iterate the list using for each loop
//			System.out.println("Printing the elements in the list : "+j);
//		}
		
		list.forEach(k -> System.out.println("Printing the elements in the list : "+k)); 
		// iterate the list using forEach method, this forEach method is available since java 1.8
	}

}
