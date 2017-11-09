package careercup.moderate;

public class Swap {

	public void swap(int a, int b) {
	
		System.out.println(a+" "+b);
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a+" "+b);
		
	}
	
	public static void main(String[] args) {
		Swap swap = new Swap();
		swap.swap(5, 4);
	}
}
