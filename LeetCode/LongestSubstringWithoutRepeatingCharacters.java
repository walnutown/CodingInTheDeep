/*
    Given a string, find the length of the longest substring without repeating characters. 
    For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
    with the length of 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

// Sliding window
// Maintain two pointers to mark the start and end of the substring
// Each time, move forward the end pointer if the substring is valid, 
// if the substring becomes invalid, move forward start pointer and update maxLength
// time: O(n); space: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)
            return 0;
        int N = s.length();
        int[] set = new int[256];
        int i=0, j=0, max = 0;
        while (j<N){
            int ch = (int) s.charAt(j);
            set[ch]++;
            if (set[ch]==2){
                while (i<=j && set[ch]==2){
                    set[(int)s.charAt(i++)]--;
                }
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}

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
