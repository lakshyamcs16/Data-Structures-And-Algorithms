package careercup.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pattern {

	public void printPattern(int n) {
		
		int j = 0, k = 0;
		for(int i=0; i<=n; i++) {
			for(j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			
			for(k=1; (k+j)<=n; k++) {
				System.out.print(k);
			}
			
			for(int l = k-2; l>=1; l--) {
				System.out.print(l);
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Pattern pattern = new Pattern();
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		String dec = "";
		
		do {
			try {
				System.out.println("Enter a number to build a triangle");
				int n = Integer.parseInt(in.readLine());
				
				pattern.printPattern(n);
				System.out.println("Do you want to see more patterns?(yes/no)");
				dec = in.readLine();
			}catch(IOException e) {
				System.out.println("Problem in IO");
			}catch(NumberFormatException e) {
				System.out.println("Enter a number");
			}
		}while(dec.equals("yes"));
	}
}
