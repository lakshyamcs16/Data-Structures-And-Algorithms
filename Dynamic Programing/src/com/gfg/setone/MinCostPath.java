package com.gfg.setone;

public class MinCostPath {

	int minCost(int path[][], int m, int n) {
		
		int sol[][] = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
				if(i == 0 && j == 0)
					sol[i][j] = path[i][j];
				else if(i == 0)
					sol[i][j] = sol[i][j-1] + path[i][j];
				else if(j == 0)
					sol[i][j] = sol[i-1][j] + path[i][j];
				else
					sol[i][j] = Math.min(Math.min(sol[i-1][j], sol[i][j-1]), sol[i-1][j-1]) + path[i][j];
			}
		}
		
		for(int i[]:sol) {
			System.out.println();
			for(int j: i)
				System.out.print(j+" ");
		}
		
		return sol[m-1][n-1];
	}
	public static void main(String[] args) {
		MinCostPath cost = new MinCostPath();
		int path[][] = {{1, 2, 3},
						{4, 8, 2},
						{1, 5, 3}};
		
		System.out.println("\n"+cost.minCost(path, 3, 3));
	}
}
