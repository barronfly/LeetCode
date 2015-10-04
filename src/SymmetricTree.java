/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
            
        return traversal(root.left, root.right);
    }
    
    boolean traversal(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode!=null && rightNode!=null) {
            if(leftNode.val != rightNode.val) 
                return false;
        }else if(leftNode==null && rightNode==null)
            return true;
        else
            return false;
            
        return traversal(leftNode.left, rightNode.right) && traversal(leftNode.right, rightNode.left);
    }
}
