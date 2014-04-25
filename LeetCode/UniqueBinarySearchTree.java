/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    For example,
    Given n = 3, there are a total of 5 unique BST's.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
*/

// The result of this combinational problem is called Catalan number
// http://en.wikipedia.org/wiki/Catalan_number
// Cn = (2n)!/[(n+1)!*n!] = 1/(n+1)*Com(2n, n)
// Another combinational example of Catalan number: the number of valid expressions in n pairs of parenthesis

// Number of unique binary tress given n nodes is  N! * Catalan
// Why? Catalan number calcualte the number of binary trees given the array [1...n]
// The array has n! permutaions, each can get Catalan number of binary trees. 

// Dynamic Programming
// cut array[1,2,...n] into 3 parts, [1...j-1],j,[j+1...n], use left and right half to construct bst
// time: O(n^2); space: O(n)
public class Solution {
    public int numTrees(int n) {
        if (n<=0)   return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            for (int j=1; j<=i; j++) 
                dp[i] += dp[j-1]*dp[i-j];
        }
        return dp[n];
    }
}

// Recursion + memoization
// time: O(n^2); space: O(n) + recursive stack
public class Solution {
    
    public int numTrees(int n) {
        int[] mem = new int[n+2];
        Arrays.fill(mem, -1);
        mem[0] = 1;mem[n+1]=1;
        return count(n, mem);
    }
    private int count(int n, int[] mem){
        if (mem[n]!=-1)
            return mem[n];
        int c = 0;
        for (int i=1; i<=n; i++){
            c += count(i-1, mem) * count(n-i, mem);
        }
        mem[n] = c;
        return c;
    }
}