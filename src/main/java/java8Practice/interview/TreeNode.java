package java8Practice.interview;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	
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