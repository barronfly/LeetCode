/**
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

*/

public class Solution {
    // Use set to store the results
    // s.add(n) should be in the beginning, not the end
    
    public boolean isHappy(int n) {
        int a = 0;
        Set<Integer> s = new HashSet<Integer>();
        while(n!=1 && !s.contains(n)) {
            s.add(n);
            int sum = 0;
            while(n!=0) {
                a = n % 10;
                sum += a * a;
                n /= 10;
            }
            n = sum;
        }
        return n==1;
    }
}
