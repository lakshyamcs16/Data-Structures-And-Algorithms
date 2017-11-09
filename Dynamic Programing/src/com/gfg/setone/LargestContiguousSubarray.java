package com.gfg.setone;

public class LargestContiguousSubarray {

	int largestSubarraySum(int arr[]) {
		
		int max_sum = arr[0];
		int max_so_far = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			
			max_so_far = Math.max(arr[i], max_so_far + arr[i]);
			max_sum    = Math.max(max_so_far, max_sum);
		}
		
		return max_sum;
	}
	public static void main(String[] args) {
		LargestContiguousSubarray sum = new LargestContiguousSubarray();
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(sum.largestSubarraySum(arr));
	}
}
