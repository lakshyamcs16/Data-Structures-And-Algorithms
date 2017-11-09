package careercup.moderate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromicSeries {
	
	
	public Set<Integer> allPalindromic(int limit) {

	    Set<Integer> result = new HashSet<Integer>();

	    for (int i = 0; i <= 9 && i <= limit; i++)
	        result.add(i);

	    boolean cont = true;
	    for (int i = 1; cont; i++) {
	        StringBuffer rev = new StringBuffer("" + i).reverse();
	        cont = false;
	        for (String d : ",0,1,2,3,4,5,6,7,8,9".split(",")) {
	        	//System.out.println(i);
	            int n = Integer.parseInt("" + i + d + rev);
	            if (n <= limit) {
	                cont = true;
	                result.add(n);
	            }
	        }
	    }

	    return result;
	}
	
	public static void main(String[] args) {
		PalindromicSeries series = new PalindromicSeries();
		Set<Integer> s= series.allPalindromic(2000);
	
		List<Integer> list = new ArrayList<Integer>();
		
		for (Integer integer : s) {
			list.add(integer);
		}
		
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}
		
	}
}
