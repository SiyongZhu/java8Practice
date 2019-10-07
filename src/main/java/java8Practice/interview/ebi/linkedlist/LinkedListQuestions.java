package java8Practice.interview.ebi.linkedlist;

import java.util.ArrayList;

import java8Practice.interview.Node;

public class LinkedListQuestions {
	
	public static void printAllNodes(Node node) {
		while(node != null) {
			System.out.print(node.getValue()+"->");
			node = node.getNext();
		}
		System.out.println();
	}
	
	//8.1
	public static Node mergeSorted (Node n1, Node n2) {
		Node curr = new Node(0);
		Node head = curr; //create a dummy head, later return head.next
		while (n1 != null && n2 != null) {
			if (n1.getValue()<n2.getValue()) {
				curr.setNext(n1);
				n1 = n1.getNext();
			}else {
				curr.setNext(n2);
				n2 = n2.getNext();
			}
			curr = curr.getNext();
		}
		curr.setNext((n1==null)? n2: n1);
		return head.getNext();
	}
	
	//8.2
	public static Node reverseLinkedList(Node head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		Node curr = head;
		Node prev = null;
		while(curr!=null) {
			Node temp = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	//8.4
	public static Node isListCyclic(Node head) {
		Node slow = head;
		Node fast = head;
	
		
		while(fast != null && fast.getNext()!=null && fast.getNext().getNext()!=null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				//Find the length of the cycle
				int length = 1;
				fast = fast.getNext();
				while(fast!=slow) {
					length++;
					fast = fast.getNext();
				}
				//Fetch LinkedNode cycle length ahead of 
				Node curr = head;
				for(int i=0; i<length; i++) {
					curr = curr.getNext();
				}
				Node iter = head;
				while(curr!=iter) {
					curr=curr.getNext();
					iter=iter.getNext();
				}
				return iter;
			}
		}
		return null;
	}
	
	//8.8 
	public static Node removeKthLast(Node head, int k) {
		Node end = head;
		Node front = head;
		Node prev = null;
		int i=0;
		while (i<=k && end!=null) {
			end = end.getNext();
			i++;
		}
		while (end!=null) {
			prev = front;
			front = front.getNext();
			end = end.getNext();
		}
		if(prev==null) {
			head = head.getNext();
		}else {
			prev.setNext(front.getNext());
		}
		
		return head;
		
	}
	
	//8.11 space complexity is O(n)
	public static Node MergeEvenOddBrute(Node head) {
		ArrayList<Integer> evenlist = new ArrayList<>();
		ArrayList<Integer> oddlist = new ArrayList<>();
		boolean isEven = true;
		Node curr = head;
		while(curr != null) {
			if(isEven) {
				evenlist.add(curr.getValue());
			}else {
				oddlist.add(curr.getValue());
			}
			isEven = !isEven;
			curr = curr.getNext();
		}
		curr = head;
		for(int i=0; i<evenlist.size(); i++) {
			 curr.setValue(evenlist.get(i));				 
			 curr=curr.getNext();
		}
		for(int i=0; i<oddlist.size(); i++) {
			 curr.setValue(oddlist.get(i));				 
			 curr=curr.getNext();
		}
		return head;		
	}

	public static void main(String[] args) {
		System.out.println("This is for linked list interview questions");
		
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node0.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		printAllNodes(MergeEvenOddBrute(node0));
		
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		node10.setNext(node12);
		node11.setNext(node13);
		node13.setNext(new Node(14));
		printAllNodes(mergeSorted(node11, node10));
		
		printAllNodes(reverseLinkedList(node10));
		
		Node node20 = new Node(20);
		Node node21 = new Node(21);
		Node node22 = new Node(22);
		Node node23 = new Node(23);
		node20.setNext(node21);
		node21.setNext(node22);
		node22.setNext(node23);
		node23.setNext(node20);
		if(isListCyclic(node20)!=null) {
			System.out.println(isListCyclic(node20).getValue());
		}else {
			System.out.println("No cyclic");
		}
		
		Node node30 = new Node(30);
		Node node31 = new Node(31);
		Node node32 = new Node(32);
		Node node33 = new Node(33);
		Node node34 = new Node(34);
		Node node35 = new Node(35);
		node30.setNext(node31);
		node31.setNext(node32);
		node32.setNext(node33);
		node33.setNext(node34);
		node34.setNext(node35);
		
		printAllNodes(removeKthLast(node30, 0));
		

	}

}
