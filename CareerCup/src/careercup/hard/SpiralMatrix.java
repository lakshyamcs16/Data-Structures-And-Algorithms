package careercup.hard;

public class SpiralMatrix {

	public void spiralMatrix(int arr[][]) {
	
		int rows = arr.length;
		int cols = arr[0].length;
		
		for(int i = 0; i < Math.ceil((double)arr.length/2); i++) {
			for(int j = i; j < rows - i; j++) {
				System.out.print(arr[i][j]+" ");
			}
			
			for (int j = i + 1; j < cols - i ; j++) {
				System.out.print(arr[j][cols-i-1]+" ");
			}
		
			for (int j = rows - i - 1; j > i; j--) {
				System.out.print(arr[rows - i - 1][j-1]+" ");
			}
			
			for (int j = rows - i - 2; j > i; j--) {
				System.out.print(arr[j][i]+" ");
			}
			
		}
	}
	
	public static void main(String[] args) {
		SpiralMatrix matrix = new SpiralMatrix();
		
		int arr[][] = {{1,2,3,4,21},
					   {5,6,7,8,22},
					   {9,10,11,12,23},
					   {13,14,15,16,24}, 
					   {17,18,19,20,25}};
		
		matrix.spiralMatrix(arr);
						   
					   
		}
	
}
