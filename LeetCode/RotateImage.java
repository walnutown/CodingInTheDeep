public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = matrix.length;
        if (len == 0){
            return;
        }
        
        for (int layer = 0; layer < len/2; layer++){
            int fisrt = layer;
            int last = n-1- layer;
            for (int i = first; i< last; i++){
                int offset = i-first;
                // save top
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] 
                
            }
        }
    }
}