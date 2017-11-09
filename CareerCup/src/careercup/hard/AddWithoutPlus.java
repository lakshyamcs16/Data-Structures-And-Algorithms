package careercup.hard;

public class AddWithoutPlus {

	public int add(int x, int y) {
	
		if(y == 0)  return x; 
		
		int sum = x^y;
		int carry = (x&y)<<1;
		
		return add(sum,carry);
	}
	
	public static void main(String[] args) {
		AddWithoutPlus add = new AddWithoutPlus();
		System.out.println(add.add(51, 3));
	}
}
