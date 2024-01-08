package leetcode;

import java.util.ArrayList;

public class RemoveDuplicate {
	public void removeDupli(ArrayList<String> country) {

		        ArrayList<String> NewList = new ArrayList<>();
		        int i = 0;
		        do {
		            String currentString = country.get(i);

		            if (!NewList.contains(currentString)) {
		            	NewList.add(currentString);
		            }else {
		            	NewList.remove(currentString);
		            }
		            i++;
		        } while (i < country.size());

		        System.out.println("Unique strings list: " + NewList);
	}
	public static void main(String[] args) {
		ArrayList<String> country = new ArrayList<String>();
		country.add("India");
		country.add("Italy");
		country.add("London");
		country.add("America");
		country.add("India");
		country.add("Italy");
		country.add("America");
		RemoveDuplicate r1=new RemoveDuplicate();
		r1.removeDupli(country);
	}
}
//	public void removeDupli(String[] s1) {
//		boolean check=false;
//		for(int i=0;i<s1.length;i++) {
//			check=false;
//			for(int j=0;j<s1.length;j++) {
//				if((s1[i]==s1[j])&&(i!=j)) {
//					check=true;
//				}
//			}
//			if(!check){
//				System.out.println(s1[i]);
//			}
//		}
//	}
//	public static void main(String[] args) {
//		String[] s1= {"chennai","london","delhi","mumbai","mumbai","london"};
//		RemoveDuplicate r1=new RemoveDuplicate();
//		r1.removeDupli(s1);
//	}
//}
