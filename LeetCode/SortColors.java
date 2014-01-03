// one pass
public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int red = 0;
        int blue = A.length - 1;
        int i = 0;
        while (i <= blue){
            if (A[i] == 0){
                int temp = A[red];
                A[red] = A[i];
                A[i] = temp;
                red++;
                i++;
            }
            else if (A[i] == 2){
                int temp = A[blue];
                A[blue] = A[i];
                A[i] = temp;
                blue--;
            }
            else{
                i++;
            }
        }
    }
}

// Accepted
public class Solution {
    public void sortColors(int[] A) {
        if (A==null || A.length==0) return;
        int r=0, b=A.length-1, i=0;
        while (i <= b){
            int color = A[i];
            if (color == 0) swap(A, i++, r++);
            else if (color == 2) swap(A, i, b--); 
            else i++;
        }
    }
    public void swap(int[] A, int i, int j){
        int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
    }
}