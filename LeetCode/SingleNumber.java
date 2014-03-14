/*
    Given an array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// Bit manipulation, xor. a^a = 0;
// time: O(n); space: O(1)
public class Solution {
    public int singleNumber(int[] A) {

        if (A == null || A.length == 0)
            return 0;
        int single = A[0];
        for (int i = 1; i < A.length; i++){
            single ^= A[i];
        }
        return single;
    }
}