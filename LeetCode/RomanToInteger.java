public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.isEmpty()){
            return 0;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        int res = 0;
        int i = 0;
        while (i+1 < s.length()){
            String curr = s.substring(i, i+1);
            String next = s.substring(i+1, i+2);
            if (map.get(next) <= map.get(curr)){
                res += map.get(curr);
                i++;
            }
            else{
                res += map.get(curr + next);
                i += 2;  
            }
            
        }
        
        if (i == s.length()-1){
            res += map.get(s.substring(i, i+1));   
        }
        
        return res;
        
    }
}

// Accepted, Dec 25
public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length()==0) return 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int num = 0;
        for (int i = 0; i < s.length(); i++){
            if (i+1 < s.length() && map.containsKey(s.substring(i, i+2))){
                num += map.get(s.substring(i, i+2));
                i++;
            }else   num += map.get(s.substring(i, i+1));
        }
        return num;
    }
}