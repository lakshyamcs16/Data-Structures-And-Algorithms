package careercup.hard;


public class CountPermutations {

	public int count(String str, String pat) {
	
		int M = str.length();
		int N = pat.length();
		int countper = 0;
		//123456342184321 1234
		for (int i = 0; i <= M - N; i++) {
			int count[] = new int[10];

			for (int j = i; j < N + i; j++) {
				count[Integer.parseInt(str.substring(j, j+1))]++;
			}
			
			for (int j = 0; j < N; j++) {
				count[Integer.parseInt(pat.substring(j, j+1))]--;
			}
			
			int j = 0;
			for (j = 0; j < count.length; j++) {
				if(count[j]!=0)
					break;
			}
			
			if(j == 10)
				countper++;			
		}
		
		return countper;
	}
	
	public static void main(String[] args) {
		CountPermutations permutations = new CountPermutations();
		String str = "122456242184321";
		String pat = "1224";
		
		System.out.println(permutations.count(str, pat));
	}
}
