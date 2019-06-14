package com.gfg.setone;

public class EditDistance {

	int minEditDist(char one[], char two[]) {
		
		int m = one.length;
		int n = two.length;
		int sol [][] = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			sol[i][0] = i;
		}
		
		for(int j = 0; j <= n; j++) {
			sol[0][j] = j;
		}
		
		for(int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				
				if(one[i-1] == two[j-1]) {
					sol[i][j] = sol[i-1][j-1];
				}else {
					sol[i][j] = Math.min(Math.min(sol[i-1][j], sol[i][j-1]), sol[i-1][j-1]) + 1;
				}
			}
		}
		
		for (int[] i : sol) {
			System.out.println();
			for (int j : i) {
				System.out.print(j+" ");
			}
		}
		
		return sol[m][n];
	}
	
	public static void main(String[] args) {
		EditDistance dist = new EditDistance();
		char one[] = "cat".toCharArray();
		char two[] = "cut".toCharArray();
		
		System.out.println("\n"+dist.minEditDist(one, two));
	}
}
