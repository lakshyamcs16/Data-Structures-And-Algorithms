package careercup.hard;

import java.util.Arrays;

public class NextGreaterNumber {

	public String next(String number) {
		
		char num[] = number.toCharArray();
		int i = 0, j = 0;
		char smallest = 'Z';
		for(i=number.length()-1; i>0; i--) {
			if(number.charAt(i) > number.charAt(i-1))
				break;
		}
		
		if(i == 0) {
			return "Not Possible";
		}
		
		int index = i;
		for(j = i; j<number.length(); j++) {
			if(number.charAt(i-1)<number.charAt(j) && smallest>number.charAt(j)) {
				smallest = number.charAt(j);
				index = j;
			}
		}
		
		if(index == number.length())
			return "Not Possible";
		
		num[index]= number.charAt(i-1);
		num[i-1] = smallest;
		
		Arrays.sort(num,i,number.length());
		
//		System.out.println(Arrays.toString(num));
		return String.valueOf(num);
		
	}
	
	public static void main(String[] args) {
		NextGreaterNumber number = new NextGreaterNumber();
		System.out.println(number.next("256871"));
	}
}
