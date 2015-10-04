//Given a binary tree, determine if it is height-balanced.
//For this problem, a height-balanced binary tree is defined as a binary tree in which 
// the depth of the two subtrees of every node never differ by more than 1.

// Rewrite !!!

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
    // An empty tree is height-balanced. A non-empty binary tree T is balanced if:
    // 1) Left subtree of T is balanced
    // 2) Right subtree of T is balanced
    // 3) The difference between heights of left subtree and right subtree is not more than 1.
    
    // Standard solution, not efficient
    // 递归地计算每个节点的左右子树深度，看其是否平衡。由于节点被重复访问，效率较低。
    // O(n^2) in worst case
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null)
    //         return true;
            
    //     int lh = height(root.left);
    //     int rh = height(root.right);
    //     if(Math.abs(lh-rh) <=1 && isBalanced(root.left) && isBalanced(root.right))
    //         return true;
            
    //     return false;
    // }
    
    // private int height(TreeNode root) {
    //     if(root == null)
    //         return 0;
        
    //     return 1 + Math.max(height(root.left), height(root.right));
    // }
    
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right)>1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
    
    // private boolean isBalanced(TreeNode root, int depth) {
    //     if (root == null) {
    //         depth = 0;
    //         return true;
    //     }
        
    //     int lh = 0, rh = 0;
    //     if(isBalanced(root.left, lh) && isBalanced(root.right, rh)) {
    //         if (Math.abs(lh - rh) > 1)
    //             return false;
    //         depth = 1 + Math.max(lh, rh);
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }
}
