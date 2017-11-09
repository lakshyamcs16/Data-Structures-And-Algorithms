package com.career.cup;

public class SortedMatrixSearch {

	public void searchMatrix(int arr[][], int key) {
		
		int result[] = searchMatrix(arr, 0, arr[0].length -1, key);
		
		if(result[0]!=-1) {
			System.out.println("Element "+key+" found at index ["+result[0]+"]["+result[1]+"]");
		}else {
			System.out.println("Element "+key+" not found!");
		}
	}
	
	public int[] searchMatrix(int arr[][], int row, int col, int key) {
	
		int mid = -1;
		if(isValid(row, col, arr)) {
			mid = arr[row][col];
			
			if(mid == key)
				return new int[] {row, col};
			else if(mid>key)
				return searchMatrix(arr, row, col-1, key);
			else
				return searchMatrix(arr, row+1, col, key);
		}
		
		return new int[] {-1};
	}
	
	private boolean isValid(int row, int col, int arr[][]) {
		return (row>=0 && col>=0 && row<arr.length && col<arr[0].length);
	}

	public static void main(String[] args) {
		SortedMatrixSearch search = new SortedMatrixSearch();
		int arr[][] = {
				{15, 20, 40,  80 },
				{20, 35, 80,  95 },
				{30, 55, 95,  105},
				{40, 80, 100, 120}
		};
		int key = 100;
		search.searchMatrix(arr, key);
		}
	
}
