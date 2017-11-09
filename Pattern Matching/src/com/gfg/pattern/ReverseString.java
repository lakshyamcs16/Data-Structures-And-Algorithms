package com.gfg.pattern;


public class ReverseString {

	public char[] reverseString(char cstr[], int start, int end) {
	
		
		for (int i = start, j = end - 1; i < (end + start)/2; i++, j--) {
			char temp = cstr[i];
			cstr[i]   = cstr[j];
			cstr[j]   = temp;
		}
		
		return cstr;
	}
	
	public void reverseString(String str) {
	
		char cstr[] = reverseString(str.toCharArray(), 0, str.length());
		
		int i = 0, j = 0;
		while(j<cstr.length) {
			
			while(j<cstr.length && cstr[j]!=' ') {
				j++;
			}
			reverseString(cstr, i, j);
			i = j + 1;
			j++;
		}
		
		System.out.println(String.copyValueOf(cstr));
	}
	
	public static void main(String[] args) {
		ReverseString string = new ReverseString();
		String str = " | ";
		string.reverseString(str);
	}
}
