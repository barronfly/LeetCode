public class Solution {
    // Consider case when n < 0
    public boolean isPowerOfTwo(int n) {
        int count=0;
        while(n > 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count == 1;
    }
    
    //如果一个数是2的次方数的话，根据上面分析，那么它的二进数必然是最高位为1，其它都为0，
    //那么如果此时我们减1的话，则最高位会降一位，其余为0的位现在都为变为1，那么我们把两数相与，就会得到0
    public boolean isPowerOfTwo(int n) {
        //return (n>0) && (n&(n-1) == 0); -- & must be seperated by blanks
        return n > 0 && (n & (n - 1)) == 0;
    }
}
