// TLE in large judge
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
        // not new int[len1][len2] here
        int[][] mem = new int[len1+1][len2+1];
        
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
                    mem[i][j] = 1+ Math.min( Math.min(mem[i-1][j], mem[i][j-1]), mem[i-1][j-1]);
                }
            }
        }
        
        return mem[len1][len2];
    }
}


//If the String equals null, like b, Java would throw a NullPointerException if you tried invoking, say:
//b.length()

// #2 trial, game tree, TLE , Last executed input: "dinitrophenylhydrazine", "acetylphenylhydrazine"
public class Solution {
    int min;
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1 == null || word2 == null){
            if (word1 == null && word2 == null)
                return 0;
            return word1 == null ? word2.length(): word1.length();
        }
        if (word1.length() == 0 || word2.length() == 0){
            return word1.length() == 0? word2.length(): word1.length();
        }
        min = Integer.MAX_VALUE;
        DFS(word1, word2, 0);
        return min;
    }
    
    public void DFS(String word1, String word2, int count){
        if (word1.length() == 0 || word2.length() == 0){
            count += word1.length() == 0? word2.length() : word1.length();
            Math.min(min, count);
            return;
        }
        if (word1.charAt(0) == word2.charAt(0)){
            DFS(word1.substring(1), word2.substring(1), count);
        }
        else{
            DFS(word1.substring(1), word2.substring(1), count+1);
            DFS(word1, word2.substring(1), count+1);
            DFS(word1.substring(1), word2, count+1);
        }
    }
}

// trial #2, DP, Accepted
// error: for (int i= 1; i < word2.length(); i++), missing '=' in 'i < word2.length()'
public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1 == null || word2 == null){
            if (word1 == null && word2 == null)
                return 0;
            return word1 == null ? word2.length(): word1.length();
        }
        int[][] min = new int[word1.length()+1][word2.length()+1];
        min[0][0] = 0;
        for (int i= 1; i <= word2.length(); i++)
            min[0][i] = i;
        for (int i= 1; i <= word1.length(); i++)
            min[i][0] = i;
        for (int i = 1; i <= word1.length(); i++){
            for (int j =1; j <= word2.length(); j++){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    min[i][j] = min[i-1][j-1];
                else
                    min[i][j] = 1+ Math.min(Math.min(min[i-1][j], min[i][j-1]), min[i-1][j-1]); 
            }
        }
        return min[word1.length()][word2.length()];
    }
}
