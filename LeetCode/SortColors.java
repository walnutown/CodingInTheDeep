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