package com.career.cup;

import java.util.Arrays;

public class CareerCup {

	public void mergeSorted(int arr1[], int arr2[], int arr1Size, int arr2Size) {
	
		int i = arr1Size - 1;
		int j = arr2Size - 1;
		int last = arr1.length - 1;
		
		while(i>=0 && j>=0) {
			
			if(arr1[i]>=arr2[j]) {
				arr1[last] = arr1[i];
				i--;
			}else {
				arr1[last] = arr2[j];
				j--;
			}
			last--;
		}
		
		if(j!=-1) {
			while(j>=0) {
				arr1[last] = arr2[j];
				j--;
				last--;
			}
		}
		
		System.out.println(Arrays.toString(arr1));
	}
	
	public static void main(String[] args) {
		CareerCup cup = new CareerCup();
		int arr1[] = new int[9];
		int x = 1;
		for(int i=0; i<6; i++) {
			arr1[i] = x;
			x += 2;
		}
		
		int arr2[] = { 2, 4, 6 };
		
		System.out.println(Arrays.toString(arr1)+"\n"+Arrays.toString(arr2));
		cup.mergeSorted(arr1, arr2, 6, 3);
	}
}
