package com.timms.list;

//5. Maximum sum path
import java.util.LinkedList;
import java.util.Queue;

class Res {
	int val;
}

public class TimmsPracticeQuestions {

	//----------------------------------------------------------------------------------------------

	static class Node{
		int data;
		Node left, right, nextRight;
		
		Node(){
			left = right = nextRight = null;
		}
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	//----------------------------------------------------------------------------------------------

	
	static Node root, root2;
	static int max = Integer.MIN_VALUE, preIndex, staticIndex;
	
	private void leftLeavesSum(Node node, Res s, boolean isLeft) {

		if(node == null) {
			return;
		}

		if(node.left == null && node.right == null && isLeft) {
			s.val += node.data;
			return;
		}

		if(node.left !=null) {
			leftLeavesSum(node.left, s, true);
		}

		if(node.right !=null) {
			leftLeavesSum(node.right, s, false);
		}
	}
	
	private void connectNodes(Node root) {

		if(root == null) {
			return;
		}

		LinkedList<Node> q = new LinkedList<Node>();
		Node prev = null;
		q.add(root);
		int size = 1;
		root.nextRight = null;

		while(!q.isEmpty()) {		
			if(size == 0) {
				prev = null;
				size = q.size();
			}
			Node curr = q.removeFirst();
			size--;
			
			if(curr.right != null) {
				curr.right.nextRight = prev;
				prev = curr.right;
				q.add(curr.right);
			}

			if(curr.left != null) {
				curr.left.nextRight = prev;
				prev = curr.left;
				q.add(curr.left);
			}
		}
		
	}
	
	private void printConnectedNodes(Node root) {
		
		System.out.println(root.data + "->" + root.nextRight);
		System.out.println(root.left.data + "->" + root.left.nextRight.data + "->" + root.left.nextRight.nextRight);
		System.out.println(root.left.left.data + 
				"->" + root.left.left.nextRight.data + 
				"->" + root.left.left.nextRight.nextRight.data + 
				"->" + root.left.left.nextRight.nextRight.nextRight.data +
				"->" + root.left.left.nextRight.nextRight.nextRight.nextRight);
		System.out.println(root.left.right.left.data + 
				"->" + root.left.right.left.nextRight.data + 
				"->" + root.left.right.left.nextRight.nextRight.data +
				"->" + root.left.right.left.nextRight.nextRight.nextRight);
		System.out.println(root.right.left.left.right.data + 
				"->" + root.right.left.left.right.nextRight.data +
				"->" + root.right.left.left.right.nextRight.nextRight);

	}
	
	private int maximumSumPath(Node node, Res tot) {
		if(node == null)
			return 0;
		
		int l = maximumSumPath(node.left, tot);
		int r = maximumSumPath(node.right, tot);
		
		int curr_max = Math.max(l, r);
		int max_single = Math.max(curr_max + node.data, node.data);
		int max_top = Math.max(max_single, l + r + node.data);
		
		tot.val = Math.max(tot.val, max_top);
		
		return max_single;
	}
	
	public static void main(String[] args) {

		TimmsPracticeQuestions travel = new TimmsPracticeQuestions();
		/*
		 * 			10
		 * 		  /    \
		 * 		 5		15
		 * 		/ \    /  \
		 *     1   3  12  30
		 *     	  /  /  \
		 *     	 16	11   7
		 *            \   \
		 *            45  42
		 * 
		 * 			26
		 * 		   /  \
		 * 		  10   6
		 * 		 /  \   \
		 *      4    6	21
		 *          / \
		 *         11 15
		 *         
		 * 		     	26
		 *      	   /  \
		 *     	      26   6
		 *           /    /
		 *          10   6
		 *         /  \
		 *        10  6 
		 *       /   / 
		 *      4   6
		 *     / 
		 *    4   
		 */
		
	    root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.right = new Node(30);
		root.left.left = new Node(1);
		root.right.left = new Node(12);
		root.left.right = new Node(3);
		root.left.right.left = new Node(16);
		root.right.left.left = new Node(11);
		root.right.left.right = new Node(7);
		root.right.left.left.right = new Node(45);
		root.right.left.right.right = new Node(42);
		
//		root = new Node(26);
//		root.left = new Node(10);
//		root.right = new Node(6);
//		root.left.left = new Node(4);
//		root.left.right = new Node(6);
//		root.right.right = new Node(21);
//		root.left.right.left = new Node(11);
//		root.left.right.right = new Node(15);
		
		root2 = new Node(26);
		root2.left = new Node(10);
		root2.right = new Node(6);
		root2.left.left = new Node(4);
		root2.left.right = new Node(6);
		
		int i = 0;
		
		System.out.println(++i+". Max sum path");	
		Res res = new Res();
		travel.maximumSumPath(root, res);
		System.out.println(res.val);
		
		System.out.print(++i+". Left Leaves Sum: ");		
		Res result = new Res();
		travel.leftLeavesSum(root, result, false);
		System.out.println(result.val);
		
		System.out.println(++i+". Connected Nodes");	
		travel.connectNodes(root);
		travel.printConnectedNodes(root);

	}
}
