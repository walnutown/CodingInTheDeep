/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
*/


// [1] find the head (H) of the descending subarray ending at the last element
// [2] reverse this subarray to make it in ascending order
// [3] find the smallest element in the subarray that is larger than the num[H-1], swap the two.
// time: O(n); space: O(1)
public class Solution {
    public void nextPermutation(int[] num) {
        if (num==null || num.length<=1) return;
        int i=num.length-1;
        while (i>0 && num[i] <= num[i-1])   i--;
        reverse(num, i, num.length-1);
        if (i==0)   return;
        int j = i;
        while (j<num.length && num[j]<=num[i-1])   j++;
        swap(num, i-1, j);
    }

    private void swap(int[] num, int i, int j){
        int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
    }

    private void reverse(int[] num, int start, int end){
        while (start<end)
            swap(num, start++, end--);
    }
}