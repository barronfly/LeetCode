// Given an array of integers, every element appears twice except for one. Find that single one.
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

import java.util.*;

public class SingleNumber {
	public int singleNumberHash(int[] A) {
		int sn = 0;
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i=0; i<A.length; i++) {
			if (hash.containsKey(A[i])) {
				hash.put(A[i], hash.get(A[i]) + 1);
			} else {
				hash.put(A[i], 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry: hash.entrySet()) {
			if (entry.getValue() == 1)
				sn = entry.getKey();
		}
		
		return sn;
	}
	
	// XOR
	public int singleNumber(int[] A) {
		int sn = 0;
		for (int i : A)
			sn ^= i;
		return sn;
	}
	
	public static void main(String args[]) {
		int[] A = {5,3,7,2,3,7,5};
		SingleNumber singleNum = new SingleNumber();
		System.out.print("The single number is: " + singleNum.singleNumber(A));
	}
}