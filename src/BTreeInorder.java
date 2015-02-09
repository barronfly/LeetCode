import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	TreeNode () {}
}

public class BTreeInorder {
	// 1. recursive - 189 ms.
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		helper(root, list);
		return list;
	}
	
	private void helper(TreeNode root, List<Integer> list) {
		if (root == null) return;
		helper(root.left, list);
		list.add(root.val);
		helper(root.right, list);
	}
	
	// 2. non-recursive - 252 ms.
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(root!=null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.right = n2;
		n2.left = n3;
		System.out.println("Preorder Traversal: ");
		BTreeInorder bt = new BTreeInorder();
		
		for (int i : bt.inorderTraversal2(root)) {
			System.out.print(i + ", ");
		}
	}
}