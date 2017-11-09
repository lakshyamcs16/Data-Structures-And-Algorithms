package com.gfg.pattern;

public class NaivePatternMatching {

	//AABAACAADAABAABA
	// AABA
	public void match(String str, String pat) {
		int j = 0;
		for(int i = 0; i <= str.length() - pat.length(); i++) {
			
			for(j = 0; j < pat.length(); j++) {
				if(str.charAt(i+j)!=pat.charAt(j))
					break;
			}
				
			
			if(j == pat.length()) {
				System.out.println("Pattern found at index "+(i));
			}
				
		}
	}
	public static void main(String[] args) {
		NaivePatternMatching matching = new NaivePatternMatching();
		String str = "AABAACAADAABAABA";
		String pat = "AABA";
		matching.match(str, pat);
	}
}
