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