package java8Practice.interview;

public class Node {

	private int value;
	private Node next;
	
	public Node (int val) {
		this.value = val;
		this.next = null;
	}
	
	public void setNext (Node node) {
		this.next = node;
	}
	
	public void setValue(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
}
