public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = word1.length();
        int len2 = word2.length();
        
        // to avoid NPE in ' new int[][] '
        if (len1 == 0){
            return len2;
        }
        if (len2 == 0){
            return len1;
        }
        
        int[][] mem = new int[len1][len2];
        
        mem[0][0] = 0;
        
        for (int i= 1; i <= len1; i++){
            mem[i][0] = i;
        }
        
        for (int i =1; i <= len2; i++){
            mem[0][i] = i;
        }
        
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    mem[i][j] = mem[i-1][j-1];
                }
                else{
                    // choose the min from 
                    // delete one from word1: mem[i-1][j]
                    // insert one to word1: mem[i][j-1]
                    // replace one in word1: mem[i-1][j-1]
                    mem[i][j] = Math.min( Math.min(mem[i-1][j], mem[i][j-1]), mem[i-1][j-1]);
                }
            }
        }
        
        return mem[len1][len2];
    }
}

