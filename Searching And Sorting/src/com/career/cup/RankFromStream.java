package com.career.cup;

class RankNode {
	int leftNodes;
	int data;
	RankNode left;
	RankNode right;
	public RankNode(int data) {
		this.data = data;
		leftNodes = 0;
		left	  = null;
		right	  = null;		
	}
}


public class RankFromStream {

	RankNode root = null;
	
	public void buildRank(int arr[]) {
		
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
		
		inorderDisplay(root);
		System.out.println("Ranks are as follows: ");
		for (int i:arr) {
			System.out.println(i+": "+getRank(root, i));
		}
	}
	
	public void insert(int data) {
		
		RankNode newNode = new RankNode(data);
		
		if(root == null) {
			root = newNode;
			return;
		}
		
		RankNode temp = root;
		RankNode prev = temp;
		while(temp!=null) {
			if(temp.data >= data) {
				temp.leftNodes = temp.leftNodes + 1;
				prev = temp;
				temp = temp.left;
			}
			else if(temp.data < data) {
				prev = temp;
				temp = temp.right;
			}
		}
		
		if(prev.left == null && prev.data >= data) {
			prev.left = newNode;
		}else {
			prev.right = newNode;
		}
	}
	
	public void inorderDisplay(RankNode node) {
		
		if(node == null)
			return;
		inorderDisplay(node.left);
		System.out.println(node.data+" Left Nodes: "+node.leftNodes);
		inorderDisplay(node.right);
	}
	
	public int getRank(RankNode node, int key) {
		
		RankNode temp = node;
		int rank 	  = 0;
		while(temp!=null) {
			if(temp.data == key) {
				rank += temp.leftNodes;
				return rank;
			}
			else if(temp.data > key) {
				temp = temp.left;
			}
			else if(temp.data < key){
				rank = rank + temp.leftNodes + 1;
				temp = temp.right;
			}
		}
		
		return -1;
		
	}
	public static void main(String[] args) {

		RankFromStream stream = new RankFromStream();
		int arr[] = {5, 1, 4, 4, 5, 9, 7, 13, 3};
		stream.buildRank(arr);
	}

}
