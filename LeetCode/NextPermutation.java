/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
*/

// consider the case: 2,3,5,4,1 -> 2,4,1,3,5
public class Solution {
    public void nextPermutation(int[] num) {
        if (num==null || num.length<=1) return;
        // in place, no extra mem
        int i = num.length-2;
        while (i>=0 && num[i] >= num[i+1])  i--;
        if (i >= 0) {
            int k = i+1;
            while (k<num.length && num[i] < num[k])    k++;
            swap(num, i, k-1);    
        }
        i++;
        int j=num.length-1;
        while (i < j)   swap(num, i++, j--);
    }
    public void swap(int[] num, int i, int j){
        int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
    }
}

// from AnnieKim, more clear logic
public class Solution {
    public void nextPermutation(int[] num) {
        if (num==null || num.length<=1) return;
        int i=num.length-1;
        while (i>0 && num[i] <= num[i-1])   i--;
        Arrays.sort(num, i, num.length);            // range sort
        if (i==0)   return;
        int j = i;
        while (j<num.length && num[j]<=num[i-1])   j++;
        swap(num, i-1, j);
    }

    public void swap(int[] num, int i, int j){
        int tmp=num[i]; num[i]=num[j]; num[j]=tmp;
    }
}