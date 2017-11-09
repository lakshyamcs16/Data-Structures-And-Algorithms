package careercup.arraysandstrings;

public class Q7 {

	public void rotateby90(char image[][]) {
	
		for (int i = 0; i < image.length/2; i++) {
			int lastrow = image.length - i - 1;
			int lastcol = lastrow;
			
			for (int j = i; j < image[0].length  - i - 1; j++) {
				
				char temp = image[i][j];

				
				image[i][j] = image[lastcol][i];
				
				image[lastcol][i] = image[lastrow][lastcol];
				
				image[lastrow][lastcol] = image[j][lastrow];
				
				image[j][lastrow] = temp;
			
				lastcol--;
			}
		}
	}
	
	public static void main(String[] args) {
		Q7 r = new Q7();
		
		char image[][] = new char[5][5];

		char ch = 'a';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				image[i][j] = ch++;
			}
		}
		
		for (char[] cs : image) {
			System.out.println();
			for (char c : cs) {
				System.out.print(c+" ");
			}
		}
		
		r.rotateby90(image);
		
		System.out.println();
		for (char[] cs : image) {
			System.out.println();
			for (char c : cs) {
				System.out.print(c+" ");
			}
		}
		
	}
}
