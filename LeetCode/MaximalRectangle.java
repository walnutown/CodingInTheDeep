// Accepted, O(m*n)
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m=matrix.length, n=matrix[0].length;
        int[] h = new int[n];
        int max = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++) h[j] = matrix[i][j]=='0' ? 0:h[j]+1;
            max = Math.max(max, finder(h));
        }
        return max;
    }
    public int finder(int[] h){
        Stack<Integer> left = new Stack<Integer>();
        int r=0, max=0;
        while (r<h.length){
            if (left.isEmpty() || h[r]>=h[left.peek()])    left.push(r++);
            else{
                int height = h[left.pop()];
                int len = left.isEmpty() ? r:r-left.peek()-1;
                max = Math.max(max, height*len);
            }
        }
        while (!left.isEmpty()){
            int height = h[left.pop()];
            int len = left.isEmpty() ? r:r-left.peek()-1;
            max = Math.max(max, height*len);
        }
        return max;
    }
}