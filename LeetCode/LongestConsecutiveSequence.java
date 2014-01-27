/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/


// cluster merge , const mem
// http://discuss.leetcode.com/questions/1070/longest-consecutive-sequence
public class Solution {
    Map<Integer, Integer> mp;
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length == 0)
            return 0;
        mp = new HashMap<Integer, Integer>();
        int max = 1;
        for (int n : num){
            if (mp.containsKey(n)) continue;
            mp.put(n,1);
            if (mp.containsKey(n-1))
                max = Math.max(max, merge(n-1, n)); // n is not in the map, so is not in the range of (n-1). Thus, we're sure that the range of n-1 is left range, but not right range
            if (mp.containsKey(n+1))
                max = Math.max(max, merge(n, n+1));
        }  
        return max;
    }
    public int merge(int left, int right){
        int start = left - mp.get(left) + 1;
        int end = right + mp.get(right) - 1;
        int len = end- start + 1;
        mp.put(start, len); // here, len denotes length of left range
        mp.put(end, len);   // here, len denotes length of right range
        return len;
    }
}

// Use a set of available numbers, time: O(n), space: O(n)
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num==null || num.length==0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<num.length; i++){
            set.add(num[i]);
        }
        int max_len = Integer.MIN_VALUE;
        while (!set.isEmpty()){
            int mid = set.iterator().next();        // to get the next available value in the set
            set.remove(mid);
            int start = mid, end=mid;
            while (!set.isEmpty() && set.contains(start-1)) set.remove(--start);
            while(!set.isEmpty() && set.contains(end+1))    set.remove(++end);
            max_len = Math.max(max_len, end-start+1);
        }
        return max_len;
    } 
}