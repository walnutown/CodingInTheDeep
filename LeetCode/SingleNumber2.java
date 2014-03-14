/*
    Given an array of integers, every element appears three times except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

// sum the number of 1s in each gidit, 
// the sum should be divisible by 3 if only the element appearing three times contribute 1 to this digit
// time: O(32n); space (1)
public class Solution {
    public int singleNumber(int[] A) {
        if (A==null || A.length==0)
            return 0;
        int res = 0;
        for (int i=0; i<32; i++){
            int count = 0;
            for (int num : A){
                if (((num>>i)&1)!=0)
                    count++;
            }
            if (count%3!=0)
                res |= (1<<i);
        }
        return res;
    }
}