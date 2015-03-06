import java.util.ArrayList;
import java.util.List;

/**
The gray code is a binary numeral system where two successive values differ in only one bit.

http://en.wikipedia.org/wiki/Gray_code

Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

n = 3
0 0 0 - 0
0 0 1 - 1
0 1 1 - 3
0 1 0 - 2
1 1 0 - 6
1 1 1 - 7
1 0 1 - 5
1 0 0 - 4

第n位的格雷码由两部分构成，
一部分是n-1位格雷码，
再加上 1<<(n-1)和n-1位格雷码的逆序的和

 */

public class GrayCode {
    public static List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
        if (n==0) {
        	res.add(0);
        	return res;
        }
        
        List<Integer> res2 = grayCode(n-1);
        
        res.addAll(res2);
        for (int i=res2.size()-1; i>=0; i--){
        	res.add(res2.get(i) + (int)Math.pow(2, n-1));  // 1 << n-1
        }
        return res;
    }
    
    public static void main(String args[]) {
    	List<Integer> res = grayCode(1);
    	for (int i=0; i<res.size(); i++)
    		System.out.println(res.get(i));
    }
}