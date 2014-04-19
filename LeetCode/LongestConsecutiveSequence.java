/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Your algorithm should run in O(n) complexity.
*/

// The naive solution is to sort the array and get the longest sequence, yet this takes O(nlgn),
// which doesn't meet the time requirement of O(n)


// Add all elements into a set.
// Pick a random number N from set as starting point (through iterator),
// We extend the subarray's left and right border if they're in the set.
// Once a number is visited, we remove it from the set. When the extension terminates,
// we pick another random number from the remaining set
// time: O(n), space: O(n)
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num==null || num.length==0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int val:num)    set.add(val);
        int max = Integer.MIN_VALUE;
        while (!set.isEmpty()){
            int mid = set.iterator().next();        // to get the next available value in the set
            set.remove(mid);
            int start = mid, end=mid;
            while (!set.isEmpty() && set.contains(start-1)) set.remove(--start);
            while(!set.isEmpty() && set.contains(end+1))    set.remove(++end);
            max = Math.max(max, end-start+1);
        }
        return max;
    } 
}