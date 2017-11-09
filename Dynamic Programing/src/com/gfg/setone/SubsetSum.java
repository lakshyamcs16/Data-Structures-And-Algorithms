package com.gfg.setone;

public class SubsetSum {

	boolean isSubsetSum(int set[], int sum) {
	
		int n = set.length;
		boolean sol[][] = new boolean[sum+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			sol[0][i] = true;
		}
		
		for (int i = 1; i <= sum; i++) {
			sol[i][0] = false;
		}
		
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				
				sol[i][j] = sol[i][j-1];
				/*
				
				i is for sum either we include the current element from the set, reduce the sum by the amount of element
				and search from rest of the set
				or we DO NOT include the current element and search from rest of the items
																	   ------
				By making: sol[i][j] = sol[i][j-1] || sol[i-set[j-1]]   [j];
																	   ------
				we can reconsider the element whose weight we just added
				refer: knapsack problem!
																
				*/
				
				if(i >= set[j-1])
					sol[i][j] = sol[i][j] || sol[i-set[j-1]][j-1];
				
			}
		}
		
		return sol[sum][n];
	}
	
	public static void main(String[] args) {
		
		SubsetSum subsetSum = new SubsetSum();
		int set[] = {6, 1, 3, 2, 5};
        int sum = 14;
        if (subsetSum.isSubsetSum(set, sum) == true)
           System.out.println("Found a subset with given sum");
        else
           System.out.println("No subset with given sum");
	}
}
