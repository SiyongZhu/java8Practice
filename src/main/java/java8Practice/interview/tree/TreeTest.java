package java8Practice.interview.tree;

import java.util.ArrayList;

import java8Practice.JavaExampleTest;
import java8Practice.interview.TreeNode;

public class TreeTest implements JavaExampleTest {

//	            16
//			 /      \
//			10       20
//			/ \     /  \
//		  5	  13   17   25
//			 /  \       /
//			11  14	   22
	@Override
	public void run() {
		TreeNode node11 = new TreeNode(11);
		TreeNode node14 = new TreeNode(14);
		TreeNode node13 = new TreeNode(13);
		node13.addLeft(node11);
		node13.addRight(node14);
		TreeNode node22 = new TreeNode(22);
		TreeNode node5 = new TreeNode(5);
		TreeNode node10 = new TreeNode(10);
		node10.addLeft(node5);
		node10.addRight(node13);
		TreeNode node17 = new TreeNode(17);
		TreeNode node25 = new TreeNode(25);
		node25.addLeft(node22);
		TreeNode node20 = new TreeNode(20);
		node20.addLeft(node17);
		node20.addRight(node25);
		TreeNode node16 = new TreeNode(16);
		node16.addLeft(node10);
		node16.addRight(node20);
		
		TreeNode root = node16;
		
		TraversalSolution sol = new TraversalSolution();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.println("Preorder:");
		sol.preorderTraversal(root, list);
		list.forEach(a -> System.out.print(a+","));
		System.out.println();
		list = sol.preorderTraversal(root);
		list.forEach(a -> System.out.print(a+","));
		System.out.println("\n");
		
		System.out.println("Inorder:");
		list = new ArrayList<Integer>();
		sol.inorderTraveral(root, list);
		list.forEach(a -> System.out.print(a+","));
		System.out.println();
		list = sol.inorderTraveral(root);
		list.forEach(a -> System.out.print(a+","));
		System.out.println("\n");
		
		System.out.println("Postorder:");
		list = new ArrayList<Integer>();
		sol.postOrderTraversal(root, list);
		list.forEach(a -> System.out.print(a+","));
		System.out.println("\n");
		
		System.out.println("LevelOrder:");
		sol.levelOrderTraversal(root);
		
		
	
		

	}

}
