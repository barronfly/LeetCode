/**
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	For example,
Given n = 3, there are a total of 5 unique BST's.
	Solution:
http://blog.sina.com.cn/s/blog_71d59f9a01017irg.html
 */

public class UniBiSearchTree {
	// 176 ms
	public int numTrees(int n) {
		if (n==0 || n==1) return 1;
		int left=0, right=0, sum=0;
		for (int k=1; k<=n; k++) {
			left = numTrees(k-1);
			right = numTrees(n-k);
			sum += left * right;
		}
		return sum;
	}
	
	// 184 ms
	public int numTrees2(int n) {
		if (n==0 || n==1) return 1;
		
		int[] f = new int[n+1];
		f[0] = 1; f[1] = 1;

		for (int i=2; i<=n; i++)
			for (int j=1; j<=i; j++)
				f[i] += f[i-j] * f[j-1];
		
		return f[n];
	}
	
	public static void main(String args[]){
		UniBiSearchTree ubst = new UniBiSearchTree();
		System.out.println("Sum BST of 1 is : " + ubst.numTrees2(1));
		System.out.println("Sum BST of 2 is : " + ubst.numTrees2(2));
		System.out.println("Sum BST of 3 is : " + ubst.numTrees2(3));
		System.out.println("Sum BST of 4 is : " + ubst.numTrees2(4));
	}
}