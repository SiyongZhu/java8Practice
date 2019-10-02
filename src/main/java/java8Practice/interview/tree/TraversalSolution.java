package java8Practice.interview.tree;

import java.util.ArrayList;

import java8Practice.interview.TreeNode;

public class TraversalSolution {

	
	public void preorderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			preorderTraversal(root.left, list);
			preorderTraversal(root.right, list);
		}
	}
	
	public void inorderTraveral(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			inorderTraveral(root.left, list);
			list.add(root.val);
			inorderTraveral(root.right, list);
		}
	}
	
	public void postOrderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			postOrderTraversal(root.left, list);
			postOrderTraversal(root.right, list);
			list.add(root.val);
		}
	}
}
