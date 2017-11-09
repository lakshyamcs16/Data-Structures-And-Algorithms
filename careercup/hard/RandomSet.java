package careercup.hard;

import java.util.Arrays;
import java.util.Random;

public class RandomSet {

	public void shuffle(int m, int n, int arr[]) {
	
		Random r = new Random();
		int shuffle[] = new int[m];
		for (int i = 0; i < m; i++) {
			shuffle[i] = arr[i];
		}
		
		for (int i = m; i < n; i++) {
			int k = r.nextInt(i);
			
			if(k<m)
				shuffle[k] = arr[i];
		}
		
		System.out.println(Arrays.toString(shuffle));
	}
	
	public static void main(String[] args) {
		RandomSet set = new RandomSet();
		int m = 4;
		int n = 6;
		int arr[] = {2,2,2,3,3,3};
		set.shuffle(m, n, arr);
	}
}
