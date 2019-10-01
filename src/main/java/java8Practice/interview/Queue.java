package java8Practice.interview;

public class Queue {

	public Node head;
	public Node tail;
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	public void enqueue(Node node) {
		if (tail == null) {
			head = node;
			tail = node;
		}else {
			tail.setNext(node);
			tail = node;
		}
	}
	
	public Node dequeue() {
		if (head == null) {
			return null;
		}else {
			Node n = new Node(head.getValue());
			head = head.getNext();
			return n;
		}
	}
	
	
}
