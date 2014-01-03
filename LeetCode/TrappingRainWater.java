// from wanghuaiqi
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

// Accepted
public class Solution {
    public int trap(int[] A) {
        if (A==null || A.length==0) return 0;
        int[] left = new int[A.length], right = new int[A.length];
        int lmax=0, rmax=0, sum=0;
        for (int i=0; i<A.length; i++){
            left[i] = lmax;
            lmax = Math.max(lmax, A[i]);
            int j = A.length-1-i;
            right[j] = rmax;
            rmax = Math.max(rmax, A[j]);
        }
        for (int i=0; i<A.length; i++){
            int bar = Math.min(left[i], right[i]);
            if (bar > A[i]) sum += bar-A[i];
        }
        return sum;
    }
}
