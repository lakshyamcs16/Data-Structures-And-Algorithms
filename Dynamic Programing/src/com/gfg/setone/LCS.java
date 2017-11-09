package com.gfg.setone;


public class LCS {

	int longestCommonSubsequence(char one[], char two[]) {
		
		int lcs[][] = new int[one.length+1][two.length+1];
		
		for(int i=0; i<=one.length; i++)
			lcs[i][0] = 0;
		
		for(int j=0; j<=two.length; j++)
			lcs[0][j] = 0;
		
		for(int i=1; i<=one.length; i++) {
			for(int j=1; j<=two.length; j++) {
				
				if(one[i-1] == two[j-1]) {
					lcs[i][j] = 1 + lcs[i-1][j-1];
				}
				
				else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
					
			}
		}
		for(int arr[]:lcs) {
			System.out.println();
			for(int i:arr)
				System.out.print(i+" ");
		}
		
		return lcs[one.length][two.length];
	}
	
	public static void main(String[] args) {
		LCS lcs = new LCS();
		char one[] = "ABCDGH".toCharArray();
		char two[] = "AEDFHR".toCharArray();
		
		System.out.println("\n"+lcs.longestCommonSubsequence(one, two));
	}
}
