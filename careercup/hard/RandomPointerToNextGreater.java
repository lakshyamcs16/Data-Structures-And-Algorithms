package careercup.hard;

import java.util.Stack;

class Node {
	int data;
	Node next;
	Node random;
	
	Node(int data) {
		this.data = data;
		next = random = null;
	}
}

class LinkedList {

	Node head, tail;
	
	public void insert(int data) {
		Node node  =  new Node(data);
		if(head == null) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			tail = node;
		}
	}
	
	public void insert(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}
	
	public void display() {
		Node temp = head;
		
		System.out.println("Data"+"\t "+"Random Pointer");
		while(temp!=null) {
			System.out.print(temp.data);
				
			if(temp.random!=null)
				System.out.println("\t "+temp.random.data);
			else
				System.out.println("\t "+"NULL");
			temp = temp.next;
		}
	}
	
	public void PointToGreater(Node head) {
		Stack<Node> st = new Stack<Node>();
		
		if(head == tail)
			return;
					
		Node temp = head.next;
		st.push(head);
		
		while(temp!=null) {
			if(!st.isEmpty() && temp.data>st.peek().data) {
				st.pop().random = temp;
				continue;
			}
				
			st.push(temp);
			temp = temp.next;
		}
	}
}

public class RandomPointerToNextGreater {
	
	public static void main(String[] args) {
		LinkedList list	 = new LinkedList();
		int arr[] = {5,10,2,3};
		list.insert(arr);
		list.PointToGreater(list.head);
		list.display();
	}
}
