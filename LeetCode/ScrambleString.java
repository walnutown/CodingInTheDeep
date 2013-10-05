// misunderstanding the Q
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 != len2){
            return false;
        }
        
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        for (int i = 0; i < len1; i++){
            char curr1 = s1.charAt(i);
            char curr2 = s2.charAt(i);
            
            if (map1.containsKey(curr1)){
                map1.put(curr1, map1.get(curr1)+1);
            }
            else{
                map1.put(curr1, 1);
            }
            
            if (map2.containsKey(curr2)){
                map2.put(curr2, map2.get(curr2)+1);
            }
            else{
                map2.put(curr2, 1);
            }
        }
        
        for (Map.Entry<Character,Integer> entry : map1.entrySet()){
            char curr = entry.getKey();
            if (!map2.containsKey(curr)){
                return false;
            }
            else{
                if (entry.getValue() != map2.get(curr)){
                    return false;
                }
            }
            
        }
        
        return true;
    }
}


// recursive, TLE, need 3d array DP
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 != len2){
            return false;
        }
       
        
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        for (int i = 0; i < len1; i++){
            char curr1 = s1.charAt(i);
            char curr2 = s2.charAt(i);
            
            if (map1.containsKey(curr1)){
                map1.put(curr1, map1.get(curr1)+1);
            }
            else{
                map1.put(curr1, 1);
            }
            
            if (map2.containsKey(curr2)){
                map2.put(curr2, map2.get(curr2)+1);
            }
            else{
                map2.put(curr2, 1);
            }
        }
        
        for (Map.Entry<Character,Integer> entry : map1.entrySet()){
            char curr = entry.getKey();
            if (map2.containsKey(curr) && entry.getValue() == map2.get(curr)){
                if (len1 == 1){
                    return true;
                }
                for (int i =1; i < len1; i++){
                    if (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i, len1), s2.substring(i, len2)) || isScramble(s1.substring(0,i), s2.substring(len2 -i,len2)) && isScramble(s1.substring(i, len1), s2.substring(0, len2-i))){
                        return true;
                    }
                }
            }
        }   
        return false;
    }  
}