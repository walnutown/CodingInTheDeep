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

// Wrong answer
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int level=0; level<n/2; level++){
            int offset = n - level - 2;
            for (int i=0; i<=offset; i++){          // change one line here
                int tmp = matrix[level][i];
                matrix[level][i] = matrix[n-1-i][level];
                matrix[n-1-i][level] = matrix[n-1-level][n-1-i];
                matrix[n-1-level][n-1-i] = matrix[i][n-1-level];
                matrix[i][n-1-level] = tmp;
            }
        }
    }
}
// Accepted, Dec 28
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int level=0; level<n/2; level++){
            int offset = n - level - 2;
            for (int i=level; i<=offset; i++){
                int tmp = matrix[level][i];
                matrix[level][i] = matrix[n-1-i][level];
                matrix[n-1-i][level] = matrix[n-1-level][n-1-i];
                matrix[n-1-level][n-1-i] = matrix[i][n-1-level];
                matrix[i][n-1-level] = tmp;
            }
        }
    }
}
