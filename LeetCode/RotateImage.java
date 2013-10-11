public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = matrix.length;
        if (len == 0){
            return;
        }
        
        for (int layer = 0; layer < len/2; layer++){
            int first = layer;
            int last = len-1- layer;
            for (int i = first; i< last; i++){
                int offset = i-first;
                // save top
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
    }
}

// spiral matrix
int start = 0, end = matrix.length -1;
        while(start < end){
            for(int i=0; i<end - start; i++){
                int temp =matrix[start+i][end];
                matrix[start+i][end]= matrix[start][start+i];
                matrix[start][start+i]= matrix[end-i][start]; 
                matrix[end -i][start]= matrix[end][end-i];
                matrix[end][end-i]=temp;
            }
            start++;
            end--;
        }
