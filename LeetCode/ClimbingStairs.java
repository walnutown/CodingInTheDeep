/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?    
*/

// Dynamic Programming, time: O(n); space: O(n)
public class Solution {
    public int climbStairs(int n) {
        // we use DP here to store the solution to each step
        if (n <= 2)
            return n;
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }
}

// DP, optimize the space. time: O(n); space: O(1)
public class Solution {
    public int climbStairs(int n) {
        if (n<=0)
            return 0;
        if (n<=2)
            return n;
       int a = 1, b = 2, c = 0;
       for (int i=3; i<=n; i++){
           c = a + b;
           a = b;
           b = c;
       }
        return c;
    }
}