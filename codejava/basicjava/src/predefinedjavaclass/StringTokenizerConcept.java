package predefinedjavaclass;

import java.util.StringTokenizer;

public class StringTokenizerConcept {
		 public static void main(String args[])  
		 {    
		   StringTokenizer st = new StringTokenizer("This is a test to StringTokenizer");    
		     while (st.hasMoreElements())   
		     {    
		         System.out.println(st.nextToken());    
		     }    
		 }    
}
