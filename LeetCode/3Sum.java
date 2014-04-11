/*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
        For example, given array S = {-1 0 1 2 -1 -4},

        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2)
*/

// Note: [1] avoid duplicates; [2] triple in non-descending

// Based on 2Sum, one for loop to traverse first element, and 
// a inner while loop to do 2Sum of another 2 elements
// Use set to avoid duplicates
// time: O(n^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if (num == null || num.length <= 2)
            return new ArrayList<ArrayList<Integer>>(res);
        Arrays.sort(num); // Sort to avoid duplicates and keep ascending order
        for (int i = 0; i < num.length; i++){
            int first = num[i];
            int j = i+1, k = num.length-1;
            while (j < k){
                int sum = first + num[j] + num[k];
                if (sum == 0){
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(first);
                    r.add(num[j]);
                    r.add(num[k]);
                    if (!res.contains(r))
                        res.add(r);
                    j++;
                    k--;
                }else if (sum > 0)  k--;
                else j++;
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }
}

// without using set, more efficient than the above
// time: O(n^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length<=2)
            return res;
        int N = num.length;
        Arrays.sort(num);
        for (int k=0; k<N; k++){
            if (k>0 && num[k]==num[k-1]) // avoid duplicates
                continue;
            int i = k+1, j = N-1;
            while (i<j){
                if (num[k] + num[i] + num[j] == 0){
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(num[k]); r.add(num[i]); r.add(num[j]);
                    res.add(r);
                    // avoid duplicates
                    do{i++;}while(i<N && num[i]==num[i-1]);
                    do{j--;}while(j>=0 && num[j]==num[j+1]);
                }else if (num[k] + num[i] + num[j] < 0)
                    i++;
                else
                    j--;
            }
        }
        return res;
    }
}