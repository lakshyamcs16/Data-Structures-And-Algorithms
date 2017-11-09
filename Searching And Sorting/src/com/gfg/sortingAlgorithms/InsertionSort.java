package com.gfg.sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

	public void insertionSort(Double arr[]) {
	
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			double temp = arr[i];
			
			while(j>=0 && temp<arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = temp;
			
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		Double arr[] = { 9.0, 5.0, 3.0, 0.0, 1.0, 6.0, 2.0};
		insertionSort.insertionSort(arr);
	}
}
