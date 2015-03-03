/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbingStairs {
	// 如何爬到第n层呢，因为每次只能爬1或2步，
	// 那么爬到第n层的方法要么是从第n-1层一步上来的，要不就是从n-2层2步上来的，
	// 所以递推公式非常容易的就得出了：
	// dp[n] = dp[n-1] + dp[n-2]
		
	// similar to Fibonacci recursive solution
    public static int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    
    public static int climbStairs2(int n) {
    	int[] array = new int[n+1];
    	array[0] = 0;
    	array[1] = 1;
    	array[2] = 2;
    	for (int i=3; i<=n; i++) {
    		array[i] = array[i-1] + array[i-2];
    	}
    	return array[n];
    }
    
    public static int climbStairs3(int n) {
    	if (n<4) return n;
    	int a=2, b=3, c=5;
    	for (int i=5; i<=n; i++) {
    		a = c;
    		c = b + c;
    		b = a;
    	}
    	return c;
    }
    
    public static void main(String args[]) {
    	System.out.println("stairs of 5 is :" + climbStairs3(5));
    }
}