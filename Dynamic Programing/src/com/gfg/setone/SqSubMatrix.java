package com.gfg.setone;

import java.util.Arrays;

public class SqSubMatrix {

	Object[] submatrix(int mat[][], int row, int col) {
	
		int sol[][] = new int[row+1][col+1];
		
		for(int i=0; i<row; i++)
			sol[i][0] = mat[i][0];
		
		for(int j=0; j<col; j++)
			sol[0][j] = mat[0][j];
		
		for(int i=1; i<row; i++) {
			for(int j=1; j<col; j++) {
				
				if(mat[i][j]==1)
					sol[i][j] = Math.min(Math.min(sol[i-1][j], sol[i][j-1]), sol[i-1][j-1]) + 1;
				else
					sol[i][j] = 0;
			}
		}
		int max = 0, row_i = 0, col_j = 0;
		for(int i=0; i<=row; i++) {
			System.out.println();
			for(int j=0; j<=col; j++) {
				
				System.out.print(sol[i][j]+" ");
				if(max<sol[i][j]) {
					max = sol[i][j];
					row_i = i;
					col_j = j;
				}
			}
		}
		
		
		Object results[] = {max, row_i, col_j};
		return results;
	}
	
	public static void main(String[] args) {
		SqSubMatrix mat = new SqSubMatrix();
		int matrix[][] = {{0, 1, 1, 0, 1},
					   {1, 1, 0, 1, 0},
					   {0, 1, 1, 1, 0},
					   {1, 1, 1, 1, 0},
					   {1, 1, 1, 1, 1},
					   {0, 0, 0, 0, 0}};
		
		System.out.println("\n"+Arrays.toString(mat.submatrix(matrix, 6, 5)));
		}
	
}
