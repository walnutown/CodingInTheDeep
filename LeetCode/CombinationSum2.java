// DFS, Accepted
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        finder(num, 0, target, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int[] num, int index, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = index; i< num.length; i++){
            if (i > index && num[i] == num[i-1])    continue;       // compare with CombinationSum, only add one sentence here
            r.add(num[i]);
            finder(num, i+1, target-num[i], res, r);
            r.remove(r.size()-1);
        }
    }
}