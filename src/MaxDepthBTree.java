//Given a binary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

/*
 * Depth first traversal - pre-order / in-order / post-order
 * http://www.wikiwand.com/en/Tree_traversal
 * Pre-order: duplicating nodes and edges can make a complete duplicate of a binary tree.
 *            make a prefix expression (Polish notation) from expression trees - traverse expression tree pre-order
 * In-order:  used on binary search trees
 * Post-order:deleting or freeing nodes and values can delete or free an entire binary tree
 *            generate a postfix representation of a binary tree
 */

public class MaxDepthBTree {

	// Definition for binary tree
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return (left_height > right_height) ? left_height+1 : right_height + 1;
    }
}