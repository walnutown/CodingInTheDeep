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


// DP, TLE
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)   return 0;
        int[] mem = new int[s.length()+1];
        mem[0] = 0;
        mem[1] = 0;
        for (int i=2; i<=s.length(); i++){
            if (isPalindrome(s.substring(0, i)))    continue;
            mem[i] = Integer.MAX_VALUE;
            for (int j=i-1; j>0; j--){
                if (isPalindrome(s.substring(j, i)))    mem[i] = Math.min(mem[i], mem[j]+1);
            }
        }
        return mem[s.length()];
    }
    
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

// Two mixed DPs, Accepted, one dp to store the palindrome checking, another to update the minimum cuts
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)   return 0;
        int[][] p = new int[s.length()][s.length()];
        int[] mem = new int[s.length()+1];
        mem[0] = -1;
        mem[1] = 0;
        for (int i=2; i<=s.length(); i++){
            mem[i] = i-1;
            for (int j=i-1; j>=0; j--){
                if (s.charAt(j)==s.charAt(i-1) && ( j>=i-2 || p[j+1][i-2]==1)){
                    p[j][i-1] = 1;
                    mem[i] = Math.min(mem[i], mem[j]+1);
                }
            }
        }
        return mem[s.length()];
    }
}