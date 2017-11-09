package com.career.cup;

import java.util.Arrays;

public class PeaksAndValleys {

	public void peaksAndValleys(int array[]) {
			
			for (int i= 1; i < array.length; i += 2) {
				int biggestindex = maxindex(array, i - 1, i, i + 1);
			
				if (i != biggestindex) {
			
					swap(array, i, biggestindex);
				}
			}
			
			System.out.println(Arrays.toString(array));
	}
	 
	private void swap(int[] arr, int i, int biggestindex) {
		int temp = arr[i];
		arr[i]   = arr[biggestindex];
		arr[biggestindex] = temp;
    }
	
	int maxindex(int[] array, int a, int b, int c) {
			int len = array.length;
			
			
			int aValue = a >= 0 && a < len? array[a] : Integer.MIN_VALUE;
			
			int bValue = b >= 0 && b < len? array[b] : Integer.MIN_VALUE;
			
			int cValue = c >= 0 && c < len? array[c] : Integer.MIN_VALUE;
			int max= Math.max(aValue, Math.max(bValue, cValue));
			
			if(aValue == max) 
				return a;
			else if(bValue == max) 
				return b;
			else 
				return c;
			
	}

	public static void main(String[] args) {
		PeaksAndValleys peaksAndValleys = new PeaksAndValleys();
		int arr[] = {5, 3, 1, 2, 3};
		peaksAndValleys.peaksAndValleys(arr);
	}
}
