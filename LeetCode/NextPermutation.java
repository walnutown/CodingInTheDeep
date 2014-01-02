// Accepted 
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

// Accepted, modified from AnnieKim
// more clear logic
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