public class Solution {
ArrayList<ArrayList<Integer>> resList;
Stack<Integer> res;
int sum;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        res = new Stack<Integer>();
        if (candidates == null || candidates.length == 0){
            return resList;
        }
        Arrays.sort(candidates);
        sum = 0;
        
        find(candidates, target, 0);
        
        return resList;
        
        
    }
    
    public void find(int[] candidates, int target, int index){
        if (sum > target){
            return;
        }
        if (sum == target){
            ArrayList<Integer> temp = new ArrayList<Integer>(res);
            Collections.sort(temp);
            resList.add(temp);
            return;
        }
        
        for (int i = index; i< candidates.length; i++){
            sum += candidates[i];
            res.push(candidates[i]);
            find(candidates, target, i);
            res.pop();
            sum -= candidates[i];
        }
    }
}

