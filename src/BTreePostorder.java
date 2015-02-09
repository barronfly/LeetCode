import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BTreePostorder {
	// 1. resursive 202 ms.
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		help(root, list);
		return list;
	}
	
	private void help(TreeNode root, List<Integer> list) {
		if (root == null) return;
		help(root.left, list);
		help(root.right, list);
		list.add(root.val);
	}
	
	// 2. non-recursive 201ms
	// https://www.youtube.com/watch?v=XUZxmxmistg
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode previousNode = root;
		TreeNode currentNode = root;
		stack.push(root);
		while(!stack.isEmpty()) {
			currentNode = stack.peek();
			if (currentNode == null)
				stack.pop();
			// leaf node, visit current
			else if (currentNode.left==null && currentNode.right==null) {
				list.add(currentNode.val);
				stack.pop();
			}
			// previous node is current node's left child, then push right child
			else if (currentNode.left == previousNode)
				stack.push(currentNode.right);
			// previous node is current node's right child, visit current
			else if (currentNode.right == previousNode) {
				list.add(currentNode.val);
				stack.pop();
			}
			// otherwise, push the left child
			else
				stack.push(currentNode.left);
			// update the previous node
			previousNode = currentNode;
		}
		return list;
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.right = n2;
		n2.left = n3;
		System.out.println("Postorder Traversal: ");
		BTreePostorder bt = new BTreePostorder();
		
		for (int i : bt.postorderTraversal2(root)) {
			System.out.print(i + ", ");
		}
	}
}