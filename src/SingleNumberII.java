import java.util.HashMap;
import java.util.Map;

/** 
Given an array of integers, every element appears three times except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */

public class SingleNumberII{
	public static int singleNumber(int[] A) {
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i=0; i<A.length; i++) {
			if (!hash.containsKey(A[i])) {
				hash.put(A[i], 1);
			} else {
				hash.put(A[i], hash.get(A[i]) +1);
			}
		}
		for (Map.Entry<Integer, Integer> entry: hash.entrySet()) {
			if (entry.getValue() != 3)
				return entry.getKey();
		}
		return 0;
	}
	
	public static int singleNumber2(int[] A) {
		int[] count = new int[32];
		int result = 0;
		for (int i=0; i<32; i++) {
			for (int j=0; j<A.length; j++) {
				if (((A[j] >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= ((count[i]%3) << i);
		}
		return result;
	}
	
	/**
		(1). Check bits which have 1-time '1', use the XOR operation.
		(2). Check bits which have 2-times '1's, use current 1-time result & current number.
		(3). Check bits which have 3-times '1's, use '1-time' result & '2-times' result
		(4). To turn 3-times bits into 0:   ~(3-times result) & 1-time result
                                                     ~(3-times result) & 2-times result
     */
	public static int singleNumber3(int[] A) {
		int ones = 0, twos = 0, threes = 0;
		for (int i=0; i<A.length; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
	
	public static void main(String args[]) {
		int[] A = {3,5,3,6,8,3,8,6,8,6};
		System.out.println(singleNumber3(A));
	}
}