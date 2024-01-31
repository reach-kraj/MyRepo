package predefinedjavaclass;

import java.util.Enumeration;
import java.util.Vector;

public class VectorConcept {
	  public static void main(String[] args)  
	   {  
	      Vector<String> vec = new Vector<String>();  
	       vec.add("Emma");  
	       vec.add("Adele");  
	       vec.add("Aria");  
	       vec.add("Aidan");  
	       vec.add("Adriana");  
	       vec.add("Ally");  
	       Enumeration<String> data = vec.elements();  
	       while(data.hasMoreElements())  
	       {  
	           System.out.println(data.nextElement());  
	       }  
	   }  
	}
