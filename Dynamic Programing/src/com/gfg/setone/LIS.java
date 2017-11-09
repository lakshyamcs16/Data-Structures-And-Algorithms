package com.gfg.setone;

import java.util.Arrays;

public class LIS {

	int longestIncreasinSequence(int arr[]) {
		
		int lis[] = new int[arr.length];
		lis[0] = 1;
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && lis[i]<lis[j]+1) {
					lis[i] = lis[j]+1;
				}else {
					lis[i] = Math.max(lis[i], lis[j]);
				}
			}
		}
		
		System.out.println(Arrays.toString(lis));
		return lis[arr.length-1];
	}
	public static void main(String[] args) {
		LIS lis = new LIS();
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis.longestIncreasinSequence(arr));
	}
}
