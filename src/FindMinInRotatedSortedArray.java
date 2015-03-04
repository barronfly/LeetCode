/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */

public class FindMinInRotatedSortedArray {
    public static int findMin1(int[] num) {
        return findMinValue(num, 0, num.length-1);
    }
    
    private static int findMinValue(int[] num, int start, int end) {
    	if (end < start) return num[0];
    	if (end == start) return num[start];
    	if (end - start == 1) return Math.min(num[start], num[end]);
    	int mid = (start + end) / 2;
    	if (num[mid] < num[end]) return findMinValue(num, start, mid);
    	else return findMinValue(num, mid, end);
    }
    
    public static void main(String[] args) {
    	int[] arr1 = {0,1,2,3,4,5};
    	int[] arr2 = {5,0,1,2,3,4};
    	int[] arr3 = {1,2,3,4,5,0};
    	System.out.println(findMin1(arr3));
    }
}