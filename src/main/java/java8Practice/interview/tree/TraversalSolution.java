package java8Practice.interview.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java8Practice.interview.TreeNode;

public class TraversalSolution {

	
	public void preorderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			preorderTraversal(root.left, list);
			preorderTraversal(root.right, list);
		}
	} 
	
	public ArrayList<Integer> preorderTraversal (TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		stack.push(curr);
		while(stack.size() > 0) {
			curr = stack.pop();
			list.add(curr.val);
			if(curr.right != null) {
				stack.push(curr.right);
			}
			if(curr.left != null) {
				stack.push(curr.left);
			}
		}
		return list;
	}
	
	public void inorderTraveral(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			inorderTraveral(root.left, list);
			list.add(root.val);
			inorderTraveral(root.right, list);
		}
	}
	
	public ArrayList<Integer> inorderTraveral(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		while (stack.size()>0 || curr!=null) {
			while(curr!=null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;

		}
		
		return list;
	}
	
	public void postOrderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			postOrderTraversal(root.left, list);
			postOrderTraversal(root.right, list);
			list.add(root.val);
		}
	}
	
	public void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		
		if(root == null) { return; }
		int height = 1;
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println("level "+height+":");
			for (int i=0; i<size; i++) {
				TreeNode n = q.poll();
				System.out.println(n.val);
				if(n.left != null) {
					q.offer(n.left);
				}
				if(n.right != null) {
					q.offer(n.right);
				}
			}
			height++;
		}
	}
}
