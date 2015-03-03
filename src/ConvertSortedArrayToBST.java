
/**
 Given an array where elements are sorted in ascending order, 
 convert it to a height balanced BST. 
 */

public class ConvertSortedArrayToBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length-1);
    }
    
    private TreeNode buildBST(int[] num, int start, int end) {
    	if (start > end) return null;
    	if (start == end) return new TreeNode(num[start]);
    	int mid = (start + end) / 2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = buildBST(num, start, mid-1);
    	root.right = buildBST(num, mid+1, end);
    	return root;
    }
}