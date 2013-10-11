// use the original array as storage, to achieve constant space
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (A == null || len == 0){
            return 1;
        }
        
        for (int i = 0; i < len; i++){
            while( A[i] != i+1){
                if (A[i] > len || A[i] <= 0 || A[i] == A[A[i]-1]){
                    break;
                }
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
        }
        
        for (int i = 0; i < len; i++){
            if (A[i] != i+1){
                return i+1;
            }
        }
        
        return len+1;
    }
}

// Bitset, like Hashmap, not constant space
public int firstMissingPositive(int[] A){
        int length = A.length >> 3 +1;
        BitSet s = new BitSet(length);
        for(int a: A){
            if(a > 0 && a<= length )
                s.set(a);
        }
        return s.nextClearBit(1);
    }


// trial #2, worst case is O(2n), the first number swaps all the remaining, which 
// takes O(n-1), and we need O(n-1) to traverse the remaing numbers
// TLE, case[1,1],   an interesting case is [1,1,1,1,1,1,1,1,2]
public class Solution {
    public int firstMissingPositive(int[] A) {
        // we put positive number a in the pos of i + 1, the first missing positive is the first number in the wrong position
        if (A == null || A.length == 0)
            return 1;
        for (int i = 0 ; i < A.length; i++){
            while ( A[i] != i + 1){  
                if (A[i] <= 0 || A[i] > A.length)   break;  // missing  if (...|| A[i] == A[A[i]-1]), otherwise, TLE in case: [1,1]
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i++){
            if (A[i] != i +1)
                return i + 1;
        }
        return A.length +1;
    }
    public void swap(int[] A, int x, int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
// Accepted
public class Solution {
    public int firstMissingPositive(int[] A) {
        // we put positive number a in the pos of i + 1, the first missing positive is the first number in the wrong position
        if (A == null || A.length == 0)
            return 1;
        for (int i = 0 ; i < A.length; i++){
            while ( A[i] != i + 1){  
                if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] -1])   break;  // missing  if (...|| A[i] == A[A[i]-1]), otherwise, in loop
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i< A.length; i++){
            if (A[i] != i +1)
                return i + 1;
        }
        return A.length +1;
    }
    public void swap(int[] A, int x, int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
