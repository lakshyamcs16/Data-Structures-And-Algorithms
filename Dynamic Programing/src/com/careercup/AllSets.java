package com.careercup;

import java.util.ArrayList;

public class AllSets {

	public ArrayList<ArrayList<Integer>> sets(ArrayList<Integer> set, int index) {
	
		ArrayList<ArrayList<Integer>> allsubsets = null;
		
		if(set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else {
			allsubsets = sets(set, index+1);
			int item = set.get(index);
			
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset:allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			
			allsubsets.addAll(moresubsets);
		}
		
		return allsubsets;
		
	}
	
	public static void main(String[] args) {
		AllSets sets = new AllSets();
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1); set.add(2); set.add(3); 
		ArrayList<ArrayList<Integer>> subsets  =  sets.sets(set, 0);
		
		for (ArrayList<Integer> arrayList : subsets) {
			System.out.print("{ ");
			for (Integer integer : arrayList) {
				System.out.print(integer+", ");
			}
			System.out.println("}");
		}
	}
}
