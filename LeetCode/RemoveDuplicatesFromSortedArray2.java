/*
    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array A = [1,1,1,2,2,3],

    Your function should return length = 5, and A is now [1,1,2,2,3].
*/

// Use variable to count occurrence of each element. 
// time: O(n); space: (1)
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) return 0;
        int count=1, i=1, j=1;
        for (; i<A.length; i++){
            if (A[i]==A[i-1]){
                if( ++count>2) continue;
            }
            else    count=1;
            A[j++] = A[i];
        }
        return j;
    }
}

// Without using 'count', from AnnieKim. 
// time: O(n); space: O(1)
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) return 0;
        if (A.length <=2)  return A.length;
        int i=2, j=2;
        for (; i<A.length; i++){
            if (A[i]==A[j-1] && A[i]==A[j-2])  continue;
            else  A[j++] = A[i];
        }
        return j;
    }
}