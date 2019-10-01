package java8Practice.interview;

public class Stack {

	Node top;
	
	public Stack() {
		this.top = null;
	}
	
	public Stack(Node node) {
		this.top = node;
	}
	
	public Node peek() {
		return top;
	}
	
	public void push(Node node) {
		if (node != null) {
			node.setNext(top);
			top = node;
		}
	}
	
	public Node pop() {
		Node n;
		if (top != null) {
			n = new Node(top.getValue());
			top = top.getNext();
			return n;
		}else {
			return null;
		}
		 
	}
	
}
