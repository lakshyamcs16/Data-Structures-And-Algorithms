package careercup.moderate;

import java.util.LinkedList;

public class DigitsToWords {

	String smalls[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
					   "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
					   "Nineteen"};
	String tens[]	= {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String hundred  = "hundred";
	String bigs[]	= {"", "Thousand", "Million", "Billion"};
	String negative = "Negative";
	
	
	public void convert(int amount) {

		LinkedList<String> result = new LinkedList<String>();
		boolean flag = false;
		if(amount == 0) {
			System.out.println(smalls[amount]);
		}else if(amount < 0){
			flag = true;
			amount = amount*-1;
		}
		
		int chunkCount = 0;
		
		while(amount>0) {
			
			if(amount % 1000 != 0) {
				result.addFirst(chunks(amount%1000) + " " + bigs[chunkCount]);
			}			
			amount /= 1000;
			chunkCount++;
		}


		if(flag)
			result.addFirst(negative);

		for (String string : result) {
			System.out.print(string+" ");
		}
	}
	
	public String chunks(int chunk) {
		
		String result = "";
		if(chunk >= 100) {
			result += smalls[chunk/100] + " " + hundred;
		}
		
		chunk %= 100;
		
		if(chunk >=10 && chunk <= 19) {
			result += " " + smalls[chunk];
		}else if( chunk >= 20 ) {
			result += " " + tens[chunk/10]; 
			chunk %= 10;
		}
			
		if(chunk >= 1 && chunk <= 9) {
			result += " " + smalls[chunk];
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		DigitsToWords words = new DigitsToWords();
		int amount = 254617;
		words.convert(amount);
	}
}
