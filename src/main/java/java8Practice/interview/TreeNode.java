package java8Practice.interview;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
	
	public void addLeft(TreeNode left) {
		this.left = left;
	}
	
	public void addRight(TreeNode right) {
		this.right = right;
	}
	
	
}
