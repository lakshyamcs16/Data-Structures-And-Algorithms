package com.gfg.sortingAlgorithms;


public class CountingSort {

	public void countSort(char arr[]) {
		
		
		int count[] = new int[256];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
			
		}

		int output[] = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i]]] = arr[i];
			count[arr[i]]--;
		}
		
		for (int i = 0; i < output.length; i++) {
			if(output[i]!=0)
				System.out.print((char)output[i]+" ");
			
		}
	}
	public static void main(String[] args) {
		CountingSort countingSort = new CountingSort();
		char arr[] = {'l','a','k','s','h','y','a'};
		countingSort.countSort(arr);
	}
}
