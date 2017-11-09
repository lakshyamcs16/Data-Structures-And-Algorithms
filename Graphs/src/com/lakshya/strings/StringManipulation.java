package com.lakshya.strings;

import java.util.Arrays;
import java.util.HashSet;

public class StringManipulation {

	HashSet<String> sets = new HashSet<String>();
	static int count = 0;
	void permutation(String str) {
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		stringPermutation(new String(arr),"", 20);
		
		/*for (String string : sets) {
			System.out.println(string+" ");
		}*/
	}
	private void stringPermutation(String str, String prefix, int n) {
		if(str.length()==0) {
			System.out.println(prefix);
			/*sets.add(prefix);
			if(sets.size() == n)
				System.out.println(prefix);*/
		}else {
			for(int i=0; i<str.length(); i++){
				//System.out.println(str.substring(0,i) + " "+ str.substring(i+1)+" "+ prefix);
				String rem = str.substring(0,i) + str.substring(i+1);
				stringPermutation(rem, prefix + str.charAt(i), n);
			}
		}
	}
	
	/*
	 * for every character a different bit will be set.
	 * which when ANDed with the previously ORed characters should give 0, otherwise
	 * it should be greater than 0
	 * Eg. abb
	 * a - 01
	 * b - 10
	 * checker - 00 -> 01 -> 11 -> 10 [ on second b ]
	 * checker & (1<<value) : will be > 0 only if a previously used bit pattern is occuring again
	 */
	boolean isUnique(String str) {
		
		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			int value = str.charAt(i) - 'a';
			if((checker & (1<<value)) > 0)
				return false;
			checker |= 1<<value;
		}
		
		return true;
	}
	
	String URLify(char str[], int length) {
		
		int i = 0, j = 0;
		for( i=str.length-1, j = length-1; j>=0; i--, j--){
				str[i] = str[j];
		}
		for(j = str.length - length -1; j>=0; j--)
			str[j] = ' ';
		
		i++;
		for(int l=0; l<str.length; l++, i++){
			if(str[i]==' ') {
				str[l] = '%';
				str[++l] = '2';
				str[++l] = '0';
			}
			else {
				str[l] = str[i];
			}
		}
		
		return String.valueOf(str);
		
		
	}
	static public void main(String args[]) {
		String str = "ab";
		String urlify = "Hello World!  ";
		char url[] = urlify.toCharArray();
		StringManipulation permute = new StringManipulation();
		permute.permutation(str);
		System.out.println("\nUnique? "+permute.isUnique(str));
		System.out.println("URL: "+permute.URLify(url, urlify.trim().length()));
	}
}
