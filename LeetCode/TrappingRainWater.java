public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length < 3){
            return 0;
        }
        
        int sum = 0;
        
        int leftMaxH = A[0];
        int[] leftH = new int[A.length];
        for (int i = 1; i < A.length; i++){
            leftH[i] = leftMaxH;
            leftMaxH = Math.max(leftMaxH, A[i]);
        }
        
        int rightMaxH = A[A.length-1];
        //int[] rightH = new int[A.length];
        for (int i =A.length-2; i >= 0; i--){
            //rightH[i] = rightMaxH;
            if (A[i] < rightMaxH && A[i] < leftH[i]){
                sum += Math.min(rightMaxH, leftH[i]) - A[i];
            }
            rightMaxH = Math.max(rightMaxH, A[i]);
        }
        
        return sum;
    }
}