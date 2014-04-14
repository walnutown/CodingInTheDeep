/*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container.
*/

// Maintain two pointers, one for left border, starting from head of array
// another for right border, starting from end of hte array
// Each time, we adjust left or right border to find if there's more water
// time: O(n); space: O(1)
public class Solution {
    public int maxArea(int[] height) {
        if (height==null || height.length==0)   return 0;
        int start=0, end=height.length-1, max=0;
        while (start < end){
            max = Math.max(max, Math.min(height[start], height[end])*(end-start));
            if (height[start] > height[end])    end--;
            else start++;
        }
        return max;
    }
}