package leetcode;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumber {
	public List<String>letterCombinations(String digits) {
		HashMap<Character, String> map = new HashMap<>();

		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		List<String> letter = new ArrayList<>();
		if (digits.length() == 0) {
			return null;
		}

		if (digits.length() == 1 && map.get(digits.charAt(0)).length() < 4) {
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(0)));
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(1)));
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(2)));

			return letter;
		}
		else if (digits.length() == 1 && map.get(digits.charAt(0)).length() == 4) {
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(0)));
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(1)));
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(2)));
			letter.add(Character.toString(map.get(digits.charAt(0)).charAt(3)));

			return letter;
		}
		List<String> letters = new ArrayList<>();

		if (digits.length() == 2) {
			for (int i = 0; i < digits.length(); i++) {
				if (i == digits.length() - 1) {
					break;
				}
				for (int j = i + 1; j < digits.length(); j++) {
					for (int k = 0; k < map.get(digits.charAt(i)).length(); k++) {
						for (int n = 0; n < map.get(digits.charAt(j)).length(); n++) {
							String combo = Character.toString(map.get(digits.charAt(i)).charAt(k)) 
									+ map.get(digits.charAt(j)).charAt(n);
							letters.add(combo);  
						}
					}
				}
			}
			return letters;
		}
		return null;
	}
	public static void main(String[] args) {
		String digits = "27";
		PhoneNumber p1=new PhoneNumber();

		System.out.println(p1.letterCombinations(digits));
	}

}
