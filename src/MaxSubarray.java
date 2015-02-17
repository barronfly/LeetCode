/**
Find the contiguous subarray within an array (containing at least one number) 
which has the largest sum.

For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4]
the contiguous subarray [4, -1, 2, 1] has the largest sum = 6
 */

public class MaxSubarray {
	//Kadane orithm, time O(n)
	public static int maxSubArray(int[] A) {
		int max_tmp = 0;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<A.length; i++){
			if (max_tmp < 0) max_tmp = 0;
			max_tmp += A[i];
			max = Math.max(max_tmp, max);
		}
		return max;
	}
	
	// Divide and Conquer
	public static int maxSubArray2(int[] A) {
		int max = Integer.MIN_VALUE;
		return findMax(A, 0, A.length-1, max);
	}
	
	public static int findMax(int[] A, int left, int right, int max){
		if (left > right)	return Integer.MIN_VALUE;
		int mid = (left + right) / 2;
		int left_max = findMax(A, left, mid-1, max);
		int right_max = findMax(A, mid+1, right, max);
		max = Math.max(max, Math.max(left_max, right_max));
		
		int sum=0, mid_lmax=0, mid_rmax=0;
		for (int i=mid-1; i>=left; i--)	{
			sum += A[i];
			if (sum > mid_lmax) mid_lmax = sum;
		}
		// clear sum
		sum = 0;
		for (int i=mid+1; i<=right; i++) {
			sum += A[i];
			if (sum > mid_rmax) mid_rmax = sum;
		}
		
		max = Math.max(max, mid_lmax+A[mid]+mid_rmax);
		return max;
	}
	
	// Divide and Conquer V2
	// http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
	public static int max(int a, int b) { return (a > b)? a : b; }
	public static int max(int a, int b, int c) { return max(max(a, b), c); }
	public static int maxSubArray3(int[] A) {
		return maxSubArraySum(A, 0, A.length-1);
	}
	public static int maxSubArraySum(int[] A, int left, int right) {
		//if (left > right) return Integer.MIN_VALUE;
		if (left == right) return A[left];
		int mid = (left + right) / 2;
		return max(maxSubArraySum(A, left, mid),
				maxSubArraySum(A, mid+1, right),
				maxCrossingSum(A, left, mid, right));
	}
	public static int maxCrossingSum(int[] A, int left, int mid, int right) {
		int sum=0, left_sum=Integer.MIN_VALUE, right_sum=Integer.MIN_VALUE;
		for (int i=mid; i>=left; i--) {
			sum += A[i];
			if (sum > left_sum)	left_sum = sum;
		}
		sum = 0; 
		for (int i=mid+1; i<=right; i++) {
			sum += A[i];
			if (sum > right_sum) right_sum = sum;
		}
		return left_sum + right_sum;
	}
	
	public static void main(String args[]) {
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("Max: " + maxSubArray3(A));
	}
}