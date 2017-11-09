package careercup.hard;

import java.util.Arrays;
import java.util.Random;

public class Permutation {

	public void permute(int cards[]) {
	
		Random r = new Random();
		for (int i = 0; i < cards.length; i++) {
			int k = r.nextInt(i+1);
			int temp = cards[i];
			cards[i] = cards[k];
			cards[k] = temp;
		}
		
		System.out.println(Arrays.toString(cards));
	}
	
	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		int cards[] = {1,2,3,4};
		permutation.permute(cards);
	}
}
