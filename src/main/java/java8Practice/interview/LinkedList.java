package java8Practice.interview;


public class LinkedList {

	private Node first;
	
	public LinkedList() {
		first = null;
	}
	
	public LinkedList(Node first) {
		this.first = first;
	}
	
	public void addNode(Node node) {
		if (first == null)
			first = node;
		else {
			Node n = first;
			while (n.getNext()!= null) {
				n = n.getNext();
			}
			n.setNext(node);
		}
	}
	
	public String toString() {
		String result="result: ";
		Node node = first;
		while (node != null) {
			result += node.getValue()+", ";
			node = node.getNext();
		}
		return result;
	}
	
	

	
}
