package com.gfg.setone;

import java.util.Arrays;

public class Scramble {

	public boolean isScrambled(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		if(s1.length()==0 || s1.equals(s2))
			return true;
		
		char s1Arr[] = s1.toCharArray();
		char s2Arr[] = s2.toCharArray();
		
		Arrays.sort(s1Arr);
		Arrays.sort(s2Arr);
		
		if(!new String(s1Arr).equals(new String(s2Arr))) {
			return false;
		}
		
		for(int i=1; i<s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			
			if(isScrambled(s11, s21) && isScrambled(s12, s22)) {
				return true;
			}
			
			String s2b = s2.substring(s2.length() - i);
			String s2f = s2.substring(0, s2.length() - i);
			
			if(isScrambled(s11, s2b) && isScrambled(s12, s2f))
	            return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scramble sb = new Scramble();
		String s1 = "great";
		String s2 = "rgate";
		
		System.out.println(sb.isScrambled(s1, s2));
	}
}
