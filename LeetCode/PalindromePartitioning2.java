
// DFS 
public class Solution {
    int cut;
    int minCut;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        cut = -1;
        minCut = Integer.MAX_VALUE; 
        if (len == 0){
            return 0;
        }
        
        DFS(s, 0);

      return minCut;
   }
   
   public void DFS(String s, int start){
       if (start == s.length()){
           minCut = Math.min(minCut, cut);
           return;
       }
       for (int i=start; i < s.length(); i++){
           String left = s.substring(start, i+1);
           if (isPalindrome(left)){
               cut++;
               DFS(s, i+1);
               cut--;
           }
           
       }
   }
    
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}

// trial 2
public class Solution {
    public int minCut(String s) {
        // of course, we can use DFS here like in PP, just need a var to record the min cut
        // we try to solve use DP here
        int[] mem = new int[s.length() +1];
        mem[0] = 0;
        mem[1] = 0;
        for (int i = 1; i <= s.length() ; i++){
            mem[i] = Integer.MAX_VALUE;
            for (int j = i-1; j > 0; j--){
                if (isPalindrome(s.substring(j,i))){
                    mem[i] = Math.min(mem[i], mem[j] + 1);
                }
            }
            if (isPalindrome(s.substring(0,i)))
                mem[i] = 0;
        }
        return mem[s.length()];
    }
    public boolean isPalindrome(String s){
        if (s.length() <= 1)
            return true;
        int start = 0;
        int end = s.length()-1;
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{  return false;   }
        }
        return true;
    }
}