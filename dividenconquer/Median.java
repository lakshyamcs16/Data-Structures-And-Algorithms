package com.gfg.dividenconquer;

public class Median {

	public void median(int arr1[], int arr2[]) {
		float res = findMedian(arr1, arr2, 0, arr1.length-1, 0, arr2.length-1);
		System.out.println("Median is "+res);
	}
	
	public float findMedian(int arr1[], int arr2[], int start1, int end1, int start2, int end2) {
		
		int n = end1 - start1 + 1;
		if(n <= 0)
			return -1;
		
		if(n == 1)
			return ( Math.max(arr1[start1], arr2[start2]) )/ 2;
		
		if(n == 2)
			return (float)( Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]) ) / 2;
		
		int m1 = median(arr1, start1, end1);
		int m2 = median(arr2, start2, end2);
		
		System.out.println(m1+" "+m2);
		if(m1 == m2)
			return m1;
		
		if(m1<m2) {
			/* if m1 < m2 then median must exist in ar1[m1....] and
			ar2[....m2] */
			if(n%2 ==0) {
				return findMedian(arr1, arr2, start1 + (end1-start1)/2, end1, start2, (end2+start2)/2  + 1);
			}
			return findMedian(arr1, arr2, start1 + (end1-start1)/2, end1, start2, (end2+start2)/2 );
		}
		
		/* if m1 > m2 then median must exist in ar1[....m1] and
		ar2[m2...] */
		if (n % 2 == 0)
	        return findMedian(arr1, arr2, start1, start1 + (end1-start1)/2 + 1, (end2+start2)/2 , end2);
	    return findMedian(arr1, arr2, start1, start1 + (end1-start1)/2, (end2+start2)/2 , end2);
	}
	
	int median(int arr[], int start, int end)
	{
		int n = end - start + 1;
		
		int m = end + start + 1;
	    if (n%2 == 0)
	        return (arr[m/2] + arr[m/2-1])/2;
	    else
	        return arr[m/2];
	}
	
	public static void main(String[] args) {
		Median median = new Median();
		int ar1[] = {1, 12, 15, 26, 38, 42, 53, 56, 76, 80, 94, 97, 99};
	    int ar2[] = {2, 13, 17, 30, 45, 46, 67, 68, 73, 88, 100, 102, 105};
	    median.median(ar1, ar2);
	}
}
