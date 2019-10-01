package java8Practice.interview;

import java8Practice.JavaExampleTest;

public class BasicTest implements JavaExampleTest {

	@Override
	public void run() {
		System.out.println("Start Basic Test");
		LinkedList list = new LinkedList();
		list.addNode(new Node(1));
		list.addNode(new Node(2));
		list.addNode(new Node(6));
		
		System.out.println(list.toString());
		
		System.out.println("Start Stack Test");
		Stack stack = new Stack();
		stack.push(new Node(10));
		stack.push(new Node(11));
		stack.push(new Node(13));
		while (stack.top != null) {
			System.out.println(stack.pop().getValue());
		}
		
		System.out.println("Start Queuq Test");
		Queue queue = new Queue();
		queue.enqueue(new Node(20));
		queue.enqueue(new Node(21));
		queue.enqueue(new Node(22));
		
		while (queue.head != null) {
			System.out.println(queue.dequeue().getValue());
		}

	}

}
