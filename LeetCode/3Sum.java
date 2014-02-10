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

// use set to avoid duplicates. time: O(n^3)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if (num == null || num.length <= 2)
            return new ArrayList<ArrayList<Integer>>(res);
        Arrays.sort(num);
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
// sum = a + b + c; we traverse the array in a , then solve the porblem as two-sum-problem, sum -a = b + c
// to get the non-descending order, we sort the array first
// to remove duplicates, we skip the visited integer and traverse b,c with b > a && c > a
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) { 
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length <= 2)
            return resList;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++){
            if (i > 0 && num[i] == num[i-1])            // to avoid duplicates
                continue;
            int j = i + 1;
            int k = num.length-1;
            while (j < k){
                if (num[i] + num[j] + num[k] < 0)
                    j++;
                else if (num[i] + num[j] + num[k] > 0)
                    k--;
                else{
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(num[i]);
                    res.add(num[j]);
                    res.add(num[k]);
                    resList.add(res);
                    // to avoid duplicates 
                    do{j++;} while (j < k && num[j] == num[j-1]);
                    do{k--;} while (j < k && num[k] == num[k+1]);
                }
            }
        }
        return resList;
    }
}