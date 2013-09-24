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



// version wanghuaiqi
public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //Stack<Integer> hight = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            if(index.empty()) {
                //hight.push(A[i]);
                index.push(i);
                continue;
            }
            int last = A[index.peek()];
            int curr = A[i];
            if(curr < last) {
                //hight.push(A[i]);
                index.push(i);
            } else if (curr == last) {
                index.pop();
                index.push(i);
            } else {
                //hight.pop();
                index.pop();
                if(!index.empty()) {
                    int ll = A[index.peek()];
                    int llIndex = index.peek();
                    ans += (i - llIndex - 1) * (Math.min(ll, curr) - last);
                }
                i--;
            }
        }       
        return ans; 
    }
}
