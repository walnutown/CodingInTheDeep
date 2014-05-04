/*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

    For example,
    Given height = [2,1,5,6,2,3],
    return 10.
*/

// The naive solution is to choose each height as the center and strentch on both sides if the 
// heights are no less than the central height. Then, calcualte the area with width and center height
// time: O(n^2); space: O(1)

// use Stack to store the index of continuous sub-array in ascending order
// when the ascending sub-array terminates, calculate the area by
// using element before stack.top() as left border, and current index as right border
// time: O(n); sapce: O(n)
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
         return 0;
        Stack<Integer> left = new Stack<Integer>();
        int max = Integer.MIN_VALUE, r = 0;
        while (r < height.length) {
            if (left.isEmpty() || height[r] >= height[left.peek()])
                left.push(r++);
            else {      // Calculate the local max in [left, r)
                int h = height[left.pop()];
                int len = left.isEmpty() ? r : r - left.peek() - 1;   
                max = Math.max(max, h * len);
            }
        }
        while (!left.isEmpty()) {
            int h = height[left.pop()];
            int len = left.isEmpty() ? r : r - left.peek() - 1;
            max = Math.max(max, h * len);
        }
        return max;
    }
}

