package com.gfg.sortingAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

class CustomComparator implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        return o1.compareTo(o2);
    }
}

public class BucketSort {

	public void bucketSort(Double arr[]) {
		
		Vector<ArrayList<Double>> buckets = new Vector<ArrayList<Double>>(10);
		ArrayList<Double> itemlist = null;
		for(double i = 0; i < 10; i++) {
			itemlist = new ArrayList<Double>();
			buckets.add(itemlist);
		}
		for(int i = 0; i < arr.length; i++) {
			
			int unitDigit = (int) (arr[i]*10);
			buckets.get(unitDigit).add(arr[i]);
			
		}
		

		for(int i = 0; i < buckets.size(); i++ ) {
			buckets.get(i).sort(new CustomComparator());
		}

		
		printBuckets(buckets);
	}
	
	private void printBuckets(Vector<ArrayList<Double>> buckets) {
		System.out.print("[ ");
		for (int i = 0; i < 10; i++) {
				for(int j = 0; j < buckets.get(i).size(); j++)
					System.out.print(buckets.get(i).get(j)+", ");
			
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		BucketSort bucketSort = new BucketSort();
	    Double arr[] = {0.897, 0.565, 0.666, 0.1234, 0.665, 0.3434};
	    bucketSort.bucketSort(arr);
	}
}
