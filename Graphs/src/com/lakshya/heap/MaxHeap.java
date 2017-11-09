package com.lakshya.heap;

public class MaxHeap {

	static final int CAPACITY = 100;
	int arr[] = new int[CAPACITY];
	int size = -1;
	int parent(int i) {
		return (i-1) / 2;
	}
	
	int left(int i) {
		return 2*i + 1;
	}
	
	int right(int i) {
		return 2*i + 2;
	}
	
	void insertHeap(int key) {
		
		if(size == CAPACITY) {
			System.out.println("Heap is full");
			return;
		}
		
		size++;
		arr[size] = key;
		int i = size;
		while(i!=0 && arr[i]>arr[parent(i)]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			i = parent(i);
		}
		
	}
	void maxHeapify(int key) {
		int l = left(key);
		int r = right(key);
		int smallest = key;
		if(l < size && arr[l]>arr[key]){
			smallest = l;		
		}
		
		if(r < size && arr[r]>arr[smallest]){
			smallest = r;			
		}
		
		if(smallest!=key) {
				int temp = arr[key];
				arr[key] = arr[smallest];
				arr[smallest] = temp;
				maxHeapify(smallest);
		}
	}
	
	int extractMax() {
		
		if (size <= 0)
	        return Integer.MAX_VALUE;
	    if (size == 1)
	    {
	        size--;
	        return arr[0];
	    }
	    
		int max = arr[0];
		
		int temp = arr[0];
		arr[0] = arr[size];
		arr[size] = temp;
		
		size--;
		maxHeapify(0);
		return max;
	}
	void printHeap() {
		System.out.println();
		for(int i=0; i<=size; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		
		MaxHeap heap = new MaxHeap();
		int input[] = {1, 23, 12, 9, 30, 2, 50};
		
		for(int i = 0 ; i<input.length; i++){
			heap.insertHeap(input[i]);
		}
		
		heap.printHeap();
		
		int k = 4;
		System.out.println();
		for(int i=0; i<k; i++) {
			System.out.print(heap.extractMax() + " ");
		}
		
		heap.printHeap();
	}

}
