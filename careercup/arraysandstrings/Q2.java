package careercup.arraysandstrings;

import java.util.Arrays;

public class Q2 {

	
	//O(nlogn) using sorting
	public boolean checkPermutation(String str1, String str2) {
	
		 char arr[] = str1.toCharArray();
		 char arr2[] = str2.toCharArray();
		 Arrays.sort(arr);
		 Arrays.sort(arr2);
		 
		 System.out.println(Arrays.toString(arr)+"\n"+Arrays.toString(arr2));
		 return Arrays.toString(arr).equals(Arrays.toString(arr2));
	}
	
	//using character set Time: O(n)
	public boolean isPermutation(String str1, String str2) {
		
		int length1 = str1.length();
		int length2 = str2.length();
		
		if(length1!=length2)
			return false;
		int count[] = new int[256];
		
		for (int i = 0; i < length2; i++) {
			count[str1.charAt(i)]++; 
		}
		
		for (int i = 0; i < length2; i++) {
			count[str2.charAt(i)]--;
		}
		
		for (int i = 0; i < 256; i++) {
			if(count[i]!=0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Q2 q2 = new Q2();
		String str1 = "taco cat";
		String str2 = "ccotat a";
		System.out.println(q2.checkPermutation(str1, str2));
		System.out.println(q2.isPermutation(str1, str2));
	}
}
