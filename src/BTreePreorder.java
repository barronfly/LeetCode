import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTreePreorder {
	//1. recursive 228 ms. Time-O(n), space-O(logn) ? size of stack
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		helper(root, list);
		return list;
	}
	
	private void helper(TreeNode root, List<Integer> list) {
		if (root == null) return;
		TreeNode n = root;
		list.add(n.val);
		helper(n.left, list);
		helper(n.right, list);
	}
	
	// 2. non-recursive. 213 ms. Time-O(n), space-O(logn) ? size of stack
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(root!=null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				list.add(root.val);
				root = root.left;
			}else {
				root = stack.pop();
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
		BTreePreorder bt = new BTreePreorder();
		
		for (int i : bt.preorderTraversal(root)) {
			System.out.print(i + ", ");
		}
	}
}