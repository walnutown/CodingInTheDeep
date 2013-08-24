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

// recursive, pass small judge, not pass large judge
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
        if (set.contains(number)){
            set.remove(number);
            number += direction;
            len = 1 + findLen(set, number, direction);
        }
        return len;
    }
}


// pass both
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