package advancejava;

import java.util.ArrayList;
import java.util.List;

public class GenericConcept {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();    
		//<String> is an generic we can't add other Datatype inside the list  
		list.add("hello");    
	//	list.add(32);//Compile Time Error   
		
		System.out.println(list);
	}
}
