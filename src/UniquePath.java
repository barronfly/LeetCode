/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid 
(marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.
 */

public class UniquePath {
	// recursive time out...
    public static int uniquePaths(int m, int n) {
        if (m==1 || n==1) return 1;
        return uniquePaths(m, n-1) + uniquePaths(m-1, n);
    }
    
    // O(n^2) space & time
    public static int uniquePaths2(int m, int n) {
    	int[][] res = new int[m][n];
    	for(int i=0; i<m; i++)
    		res[i][0] = 1;
    	for(int j=0; j<n; j++)
    		res[0][j] = 1;
    	for(int i=1; i<m; i++) {
    		for (int j=1; j<n; j++) {
    			res[i][j] = res[i][j-1] + res[i-1][j];
    		}
    	}
    	return res[m-1][n-1];
    }
    
    public static int uniquePaths3(int m, int n) {
    	int[] res = new int[n];
    	for (int i=0; i<n; i++)
    		res[i] = 1;
    	for (int i=1; i<m; i++){
    		for (int j=1; j<n; j++) {
    			res[j] += res[j-1];
    		}
    	}
    	return res[n-1];
    }
    
    public static void main(String args[]) {
    	System.out.println(uniquePaths3(3,3));
    }
}