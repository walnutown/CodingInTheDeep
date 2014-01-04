// Accepted, two ranges as jumpGame2
public class Solution {
    public boolean canJump(int[] A) {
        if (A==null || A.length<=1) return true;
        int prev_range=0, curr_range=0;
        for (int i=0; i<A.length; i++){
            if (i > prev_range) prev_range = curr_range;
            curr_range = Math.max(curr_range, A[i] + i);
            if (curr_range == i && i!=A.length-1) return false;     // notice here, i!= A.length-1
        }
        return true;
    }
}
// in fact, only one range needed
public class Solution {
    public boolean canJump(int[] A) {
        if (A==null || A.length<=1) return true;
        int range=0;
        for (int i=0; i<A.length; i++){
            if (i > range) return false;
            range = Math.max(range, A[i] + i);
            if (i >= A.length-1) return true;
        }
        return false;
    }
}