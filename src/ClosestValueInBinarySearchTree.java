/**
Problem Description:
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/
 
 
class Solution {
 public int closestValue(TreeNode root, double target) {
         if (!root) return INT_MAX;
         if (!(root.left) && !(root.right)) return root.val;
         int left = closestValue(root.left, target);
         int right = closestValue(root.right, target);
         double td = abs(root.val - target), ld = abs(left - target), rd = abs(right - target);
         if (td < ld) return td < rd ? root.val : right;
         else return ld < rd ? left : right;
     }
 };
