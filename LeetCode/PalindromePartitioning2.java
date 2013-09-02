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