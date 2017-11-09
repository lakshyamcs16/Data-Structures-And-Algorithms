package com.career.cup;

public class SearchWithBlanks {

	public void searchString(String arr[], String key) {
	
		if(key.equals("")) {
			System.out.println("Abey Bevde!");
			System.exit(0);
		}
		
		int result = searchString(arr, 0, arr.length-1, key);
		
		if(result!=-1)
			System.out.println("String \""+key+"\" found at index "+result);
		else
			System.out.println("String \""+key+"\" not found!");
		
	}
	
	public int searchString(String arr[], int start, int last, String key) {
		
		if(start<=last) {
			
			int mid = (start + last)/2;
			
			if(arr[mid].equals("")) {
				int i = mid; int j = mid;
				while(i<=last || j>=start) {
					if(i <= last && !arr[i].equals("")) {
						mid = i;
						break;
					}
					else if(j >= start && !arr[j].equals("")) {
						mid = j;
						break;
					}
					else {
						i++;
						j--;
					}
				}
				
			}
			if(arr[mid].equals(key))
				return mid;
			else if(arr[mid].compareTo(key)>0) 
				return searchString(arr, start, mid-1, key);
			else
				return searchString(arr, mid+1, last, key);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SearchWithBlanks searchWithBlanks = new SearchWithBlanks();
		String arr[] = { "at","","","","ball","","","car","","","dad","","ele"};
		String key   = "ball";
		searchWithBlanks.searchString(arr, key);
	}
}
