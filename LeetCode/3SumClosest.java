/*
    Given an array S of n integers, find three integers in S such that the sum is closest
    to a given number, target. Return the sum of the three integers. You may assume that 
    each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

// Similar to 3Sum, the difference lies in that we need to update the closest result all the time
// time: O(n^2); sapce: O(1)
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num==null || num.length<3) return 0;
        int m = num.length; 
        Arrays.sort(num);                   // IMPORTANT, remember to sort here
        int min = num[0]+num[1]+num[2];
        for (int i=0; i<m; i++){
            int j=i+1, k=m-1;
            while(j<k){
                int sum = num[i] + num[j] + num[k];
                if (sum == target)    return target;
                else if (sum < target)  j++;
                else k--;
                if (Math.abs(target-sum) < Math.abs(target-min)) min = sum;
            }
        }
        return min;
    }
}