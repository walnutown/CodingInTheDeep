/*
    Given a string, find the length of the longest substring without repeating characters. 
    For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
    with the length of 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

// use map to store visited character and its index
// time: O(n^2); space: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSub = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch, i);
                count++;
            }
            else{
                i = map.get(ch);
                map.clear();
                count = 0;     
            }
             maxSub = Math.max(maxSub, count);
             i++;
        }  
        return maxSub;
    }
}

// sliding window, use a variable to record the start index of the window
// time: O(n); space: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)   return 0;
        int len = s.length();
        boolean[] used = new boolean[256];
        int start=0, end=0, max=0;
        char[] str = s.toCharArray();
        while (end<len){
            if (!used[str[end]])    used[str[end++]] = true;
            else    used[str[start++]]=false;
            max = Math.max(max, end-start);
        }
        return max;
    }
}