public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
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