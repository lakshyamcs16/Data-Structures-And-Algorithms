package careercup.moderate;

public class MaximumOfTwo {

	public int max(int a, int b) {
	
		int x = sign(a - b);
		int y = flip(x);
		
		return x*a + y*b;
	}
	
	public int sign(int a) {
		
		return flip(a>>31 & 0x1);
	}
	
	public int flip(int a) {
		return 1^a;
	}
	public static void main(String[] args) {
		MaximumOfTwo two = new MaximumOfTwo();
		System.out.println(two.max(-2, -15));
	}
}
