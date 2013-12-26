public class Solution {
    int[] ways;
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len == 0){
            return 0;
        }
        ways = new int[len+1];
        ways[0] = 1; // cannot init ways[0] = 0 here, notice case 10
        if (isValid(s.substring(0,1))){
            ways[1] = 1;
        }
        else{
            return 0;
        }
        
        for (int i=2; i <= len; i++){
            char curr = s.charAt(i-1);
            char prev = s.charAt(i-2);
            if (curr == '0'){
                if (prev == '1' || prev == '2'){
                    ways[i] = ways[i-2];
                }
                else{
                    return 0;
                }
            }
            else{
                if (prev == '1' || prev == '2' && curr <= '6'){
                    ways[i] = ways[i-1] + ways[i-2];
                }
                else{
                    ways[i] = ways[i-1];
                }
                
            }  
        }
        
        
        return ways[len];
    }
    
    public boolean isValid(String s){
        int num = Integer.parseInt(s);
        // avoid "0" in string
        if (num >=1 && num <= 26 && !s.startsWith("0")){
            return true;
        }
        return false;
    }
}

// #2 , doesn't ocnsider 0, totally wrong
// Input:  "0"
// Output: 1
// Expected:   0

// Input:  "10"
// Output: 2
// Expected:   1


public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
            return 0;
        int[] count = new int[s.length()+1];
        count[0] = 0;
        count[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            if (Integer.parseInt(s.substring(i-2, i)) <= 26)
                count[i]++;
            count[i]++;
        }
        return count[s.length()];
    }
}
// Accepted
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
            return 0;
        int[] count = new int[s.length()+1];
        
        if (s.charAt(0) == '0')
            return 0;
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            int left = s.charAt(i-2) - '0';
            int right = s.charAt(i-1) - '0';
            if (right == 0){
                if (left == 1 || left == 2)
                    count[i] = count[i-2];
                else
                    return 0;
            }
            else{
                if (left == 1 || left == 2 && right <= 6)
                    count[i] = count[i-2] + count[i-1];
                else
                    count[i] = count[i-1];
            }
        }
        return count[s.length()];
    }
}


// tong version
  public int numDecodings(String s) {
      // Note: The Solution object is instantiated only once and is reused by
      // each test case.
      if (s == null || s.length() == 0)
         return 0;
      int[] res = new int[s.length() + 1];
      res[s.length()] = 1;
      for (int i = s.length() - 1; i >= 0; i--) {
         if (s.charAt(i) == '0')
            res[i] = 0;
         else
            res[i] = res[i + 1];

         if (i < s.length() - 1 && (s.charAt(i) - '0' == 1 || (s.charAt(i) - '0' == 2 && s.charAt(i) - '0' > 0 && s.charAt(i + 1) - '0' < 7 && s.charAt(i + 1) - '0' >= 0)))
            res[i] += res[i + 2];
      }
      return res[0];
   }



// Submission Result: Runtime Error

// Last executed input:    "0"
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)   return 0;
        int[] mem = new int[s.length()];
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            int curr = Integer.parseInt(s.substring(i-1,i));
            int prev = Integer.parseInt(s.substring(i-2,i-1));
            if (curr == 0 ){
                if (prev == 1 || prev == 2) mem[i] = mem[i-1];
                else return 0;
            }else{
                int two_digits = Integer.parseInt(s.substring(i-2,i));
                if ( two_digits <= 26 && two_digits > 10)   mem[i] = mem[i-1] + mem[i-2];
                else    mem[i] = mem[i-1];
            }
        }
        return mem[s.length()];
    }
}

// Accepted, Dec 25, 
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)   return 0;
        int[] mem = new int[s.length()+1];
        mem[0] = 1;
        for (int i = 1; i <= s.length(); i++){
            int curr = s.charAt(i-1) - '0';
            if (curr == 0 ) mem[i] = 0;         // check '0' first
            else    mem[i] = mem[i-1];
            if (i -2 >= 0){
                int prev = s.charAt(i-2) - '0';
                if (prev==1 || (prev==2 && curr>=0 && curr<=6))    mem[i] += mem[i-2];
            }
            if (mem[i] == 0)    return 0;       // if 0, invalid string
        }
        return mem[s.length()];
    }
}