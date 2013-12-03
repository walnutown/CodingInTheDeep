// http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
// still need debug
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = A.length;
        int len2 = B.length;
        if (len1 == 0 && len2 == 0){
            return 0.0;
        }
        int len = len1 + len2;
        if (len%2 == 1){
            return getMedian(A, B, len/2, 0, len1-1, 0, len2-1);
        }
        else{
            return (getMedian(A, B, len/2, 0, len1-1, 0, len2-1) + getMedian(A, B, len/2-1, 0, len1-1, 0, len2-1))/2.0;
        }
    }
    
    public double getMedian(int[] A, int[] B, int med, int astart, int aend, int bstart, int bend){
        if (astart > aend){
            return B[bstart + med];
        }
        if (bstart > bend){
            return A[astart + med];
        }
        int amid = (aend-astart)/2;
        int bmid = (bend-bstart)/2;
        if (amid + bmid  >= med){
            if (A[amid ]> B[bmid]){
                return getMedian(A, B, med, astart, astart + amid-1, bstart, bend);
            }
            else{
                return getMedian(A, B, med, astart, aend, bstart, bstart + bmid-1);
            }
        }
        else{
            if (A[amid] > B[bmid]){
                return getMedian(A, B, med-(bmid+1), astart, aend, bstart+ bmid+1, bend);
            }
            else{
                return getMedian(A, B, med-(amid+1), astart+ amid+1, aend, bstart, bend);
            }
        }
    }
}


public double findMedianSortedArrays(int A[], int B[]){
        if((A.length+B.length)%2==0){
            return (findMedianSortedArrays(A, B, (A.length + B.length) / 2) + findMedianSortedArrays(
                    A, B, (A.length + B.length) / 2 + 1)) / 2;
        }else{
            return findMedianSortedArrays(A, B, (A.length + B.length) / 2 + 1);
        }
    }
    // find kth number in A||B, clear! show on picture
    public double findMedianSortedArrays(int A[], int B[], int k){
        if(A.length==0)
            return B[k-1];
        if(B.length==0)
            return A[k-1];
        if(k==1)
            return Math.min(A[0], B[0]);
        if(A[A.length/2]>=B[B.length/2]){
            if(A.length/2+ B.length/2+1 >=k){
                return findMedianSortedArrays(Arrays.copyOf(A, A.length / 2),B, k);
            }else{
                return findMedianSortedArrays(A,Arrays.copyOfRange(B, B.length / 2 + 1, B.length),k-B.length/2 - 1);
            }
        }else{
            if(A.length/2+B.length/2 + 1>=k){
                return findMedianSortedArrays(A, Arrays.copyOf(B, B.length / 2), k);
            }else{
                return findMedianSortedArrays( Arrays.copyOfRange(A, A.length / 2 + 1, A.length), B, k-A.length/2 - 1);
            }
        }
    }
}
