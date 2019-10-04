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
	
	//Cracking 4.2
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
	
	public int findMinHeight(TreeNode node, int height) {
		if(node == null) { return height; }
		if(node.right==null && node.left==null) {
			return height+1;
		}
		else {
			return Math.min(findMinHeight(node.left, height+1), findMinHeight(node.right, height+1));
		}
	}
	
	public int findMaxHeight(TreeNode node, int height) {
		if (node == null) { return height; }
		else {
			return Math.max(findMaxHeight(node.left, height+1), findMaxHeight(node.right, height+1));
		}
	}
	
	//Cracking 4.4
	public int getHeight(TreeNode node) {
		if (node == null) {return 0;}
		else {
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
		}
	}
	
	public boolean isbalanced(TreeNode node) {
		if (node == null) {
			return true;
		}else {
			return (isbalanced(node.left) &&
					isbalanced(node.right) &&
					Math.abs(getHeight(node.left)-getHeight(node.right))<=1);
		}
	}
	
	//Cracking 4.5
	static Integer last_value;
	public boolean isBST(TreeNode node) {
		if (node == null) {
			return true;
		}
		if(!isBST(node.left)) {return false;}
		if(last_value != null && node.val<last_value) {
			return false;
		}else {
			last_value = node.val;
		}
		if(!isBST(node.right)) {return false;}
		return true;
		
	}
	
	//Cracking 4.6
	public TreeNode nextSuccessor(TreeNode node) {
		TreeNode curr;
		TreeNode parent;
		if (node.right != null) { //if right sub tree is not empty
			curr = node.right;
			while(curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}
		else {
			//iterate up until curr is a left subtree
			curr = node;
			parent = node.parent;
			while(parent.left != curr && parent!=null) {
				curr = parent;
				parent = parent.parent;
			}
			return parent;
		}

	}
	
	
}
