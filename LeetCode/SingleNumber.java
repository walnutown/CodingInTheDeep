public class Solution {
    public int singleNumber(int[] A) {
        // O(n) time, without extra space
        if (A == null || A.length == 0)
            return 0;
        int single = A[0];
        for (int i = 1; i < A.length; i++){
            single ^= A[i];
        }
        return single;
    }
}