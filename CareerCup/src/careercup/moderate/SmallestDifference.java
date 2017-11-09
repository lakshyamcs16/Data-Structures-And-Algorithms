package careercup.moderate;

import java.util.Arrays;

public class SmallestDifference {

	public int smallestdifference(int arr1[], int arr2[]) {
	
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i = 0, j = 0;
		int mindiff = Integer.MAX_VALUE;

		while(i<arr1.length && j<arr2.length) {
			
			if(Math.abs(arr1[i] - arr2[j]) < mindiff)
				mindiff = Math.abs(arr1[i] - arr2[j]);
			
			if(arr1[i]<arr2[j]) i++;
			else j++;
		}
		
		return mindiff;
		
	}
	
	public static void main(String[] args) {
		SmallestDifference difference = new SmallestDifference();
		int arr1[] = {1, 2, 11, 15};
		
		int arr2[] =  {4, 12, 19, 23, 127, 235};
		
		System.out.println(difference.smallestdifference(arr1, arr2));
	}
}
