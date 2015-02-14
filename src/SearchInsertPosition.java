/**
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0
 */

public class SearchInsertPosition {
	public int searchInsert(int A[], int target) {
		if (target <= A[0]) return 0;
		int length = A.length;
		for (int i=0, j=1;i<length && j<length; i++, j++){
			if (A[i] == target) return i;
			else if (A[i] < target && A[j] > target) return j;
		}
		if (A[length-1] == target) return length-1;
		return length;
	}
	
	// binary search !
	public int searchInsert2(int A[], int target) {
		int length = A.length;
		int min = 0, max = length-1, i = 0; 
		while (min>=0 && max>=0 && min<length && max<length && min<=max) {
			i = (min + max) / 2;
			if ( A[i] == target) return i;
			else if (A[i] < target) min = i + 1;
			else if (A[i] > target) max = i - 1;
		}
		return min;
		
	}
	
	public static void main(String args[]) {
		int[] A = {1};
		SearchInsertPosition sip = new SearchInsertPosition();
		System.out.println("Position: " + sip.searchInsert2(A, 1));
	}
}