package careercup.arraysandstrings;

import java.util.HashMap;

public class Q1 {

	//Time: O(n) Space: O(n)
	public boolean isUniqueExtraSpace(String str) {
	
		char arr[] = str.toCharArray();
		HashMap<Character, Integer> count  = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(count.get(arr[i]) != null) {
				return false;
			}
			count.put(arr[i], 1);
		}
		
		return true;
	}
	
	//without extra space with Time: O(n) 
	public boolean isUnique(String str) {
		int value = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int charIndex = str.charAt(i) - 'a';
			if((value & 1<<charIndex)>0) {
				return false;
			}
			
			value |= (1<<charIndex);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Q1 unique = new Q1();
		String str = "hell";
		System.out.println(unique.isUniqueExtraSpace(str));
		System.out.println(unique.isUnique(str));
	}
}
