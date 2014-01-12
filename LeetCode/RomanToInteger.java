/*
    Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.
*/

// time: O(n); space: O(1)
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

// AnnieKim, time: O(n); space: O(1)
// This sol is better
public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length()==0) return 0;
          Map<Character, Integer> map = new HashMap<Character, Integer>();
          map.put('I', 1);
          map.put('V', 5);
          map.put('X', 10);
          map.put('L', 50);
          map.put('C', 100);
          map.put('D', 500);
          map.put('M', 1000);
          int num = 0, m = s.length();
          for (int i=0; i<m; i++){
              if (i<m-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1)))   num -= map.get(s.charAt(i));
              else num += map.get(s.charAt(i));
          }
          return num;
    }
}