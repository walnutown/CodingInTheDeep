// Accepted
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