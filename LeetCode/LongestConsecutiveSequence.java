// TLE
public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length == 0){
            return 0;
        }
        if (num.length == 1){
            return 1;
        }
        int maxLong = 1;
        int count = 1;
        
        
        Set<Integer> set = new HashSet<Integer>();
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++){
            minNum = Math.min(minNum, num[i]);
            maxNum = Math.max(maxNum, num[i]);
            if (!set.contains(num[i])){
                set.add(num[i]);
            }  
        }
        
        for (int i = minNum; i <= maxNum; i++){
            if (!set.contains(i)){
                count = 1;
                continue;
            }
            if (set.contains(i + 1)){
                count++;
                maxLong = Math.max(count, maxLong);
            }
            else{
                count = 1;
            }
        
        }
        
        
        return maxLong;
    }
}


public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length == 0){
            return 0;
        }
        if (num.length == 1){
            return 1;
        }
        int maxLong = 1;
        int count = 1;
        
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++){
            if (!set.contains(num[i])){
                set.add(num[i]);
            }  
        }
        
        for (int number : num){
            if (set.contains(number)){
                set.remove(number);
                int len = 1 + findLen(set, number - 1, -1);
                len += findLen(set, number + 1, 1);
                maxLong = Math.max(len, maxLong);
            }
        }
        
        
        return maxLong;
    }
    
    public int findLen(Set<Integer> set, int number, int direction){
        int len = 0;
        while (set.contains(number)){
            set.remove(number);
            len++;
            number += direction;
            
        }
        return len;
    }
}



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
                max = Math.max(max, merge(n-1, n)); // as n is not in the map, we're sure that the range of n-1 is left range, but not right range
            if (mp.containsKey(n+1))
                max = Math.max(max, merge(n, n+1));
        }  
        return max;
    }
    public int merge(int left, int right){
        int start = left - mp.get(left) + 1;
        int end = right + mp.get(right) - 1;
        int len = end- start + 1;
        mp.put(start, len);
        mp.put(end, len);
        return len;
    }
}

// Accepted, Dec 31
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
            int len = 1;
            int i = mid;
            while (!set.isEmpty() && set.contains(--i)){
                len++;
                set.remove(i);
            }
            i = mid;
            while(!set.isEmpty() && set.contains(++i)){
                len++;
                set.remove(i);
            }
            max_len = Math.max(max_len, len);
        }
        return max_len;
    } 
}