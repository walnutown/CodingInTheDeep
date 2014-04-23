/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
*/

// Maintain the max distance we can reach
// Traverse the array and update the max
// Once we find that current distance out of reach, return false
// time: O(n); space: O(1)
public class Solution {
    public boolean canJump(int[] A) {
        if (A==null || A.length==0)
            return true;
        int N = A.length, max = 0;
        for (int i=0; i<N; i++){
            if (max < i)    return false;
            max = Math.max(max, i+A[i]);
        }
        return true;
    }
}

// Use two max reaches as in JumpGame2
// time: O(n); space: O(1)
public class Solution {
    public boolean canJump(int[] A) {
        if (A==null || A.length<=1) return true;
        int N = A.length, prevMax=0, currMax=0;
        for (int i=0; i<N; i++){
            if (i > prevMax) prevMax = currMax;
            currMax = Math.max(currMax, A[i] + i);
            if (currMax == i && i!=N-1) return false;     // notice here, i!= N-1
        }
        return true;
    }
}
