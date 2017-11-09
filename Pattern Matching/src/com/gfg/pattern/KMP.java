package com.gfg.pattern;

import java.util.Arrays;

public class KMP {

	//AABAACAADAABAABA
	//AABA
	public void patternMatching(char[] pat, char[] str) {
	
		int N = str.length;
		int M = pat.length;
		int i = 0, j = 0;
		int lps[] = generateLPS(pat);
		System.out.println("LPS: "+Arrays.toString(lps));
		while(i<N) {
			//if matches
			if(str[i] == pat[j]) {
				i++;
				j++;
			}
			//if it doesn't match
			else {
				j = lps[j-1];
			}
			
			//if it reaches the pattern length, we have found a pattern
			if(j == M) {
				System.out.println("Pattern found at "+(i-M));
				j = lps[j-1];
			}
			//if j reaches 0 mean pattern couldn't be found move on for next character in the string
			else if(j == 0){
					i++;
			}
				
		}
	}
	
	public int[] generateLPS(char[] pat) {
		
		int pattern_length = pat.length;
		int lps[] = new int[pattern_length];
		
		lps[0]    = 0;
		int j = 0;

		for(int i = 1; i<pattern_length; ) {
			
			//if pattern (prefix) matches(suffix) we move forward while saving the maximal match in the array
			if(pat[j] == pat[i]) {
				j++;
				lps[i] = j;
				i++;
			}
			//we keep going backwards unless we cannot anymore (i.e., until j != 0) 
			else {
				if(j!=0) {
					
					j = lps[j-1];
			
				}
			// it means we have reached the end and no prefix matches the suffix so we save 0 in lps array and move on	
				else {
					lps[i] = j;
					i++;
				}
				
			}
		}
		
		
		return lps;
	}
	
	public static void main(String[] args) {
		KMP kmp = new KMP();
		String str = "AABAACAADAABAABA";
		String pat = "AABA";
		kmp.patternMatching(pat.toCharArray(), str.toCharArray());
	}
}
