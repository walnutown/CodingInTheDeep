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


// #2 trial, Output Limit Exceeded
// points to be taken care of here
// 1. numbers in a set are unique
// 2. number in list can repeat, yet, list should be unique
// 3. all numbers are positive, so that DFS will not stuck
public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);  // take care of sort here, to make sure the list is non-descending
        DFS(candidates, target, 0, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void DFS(int[] candidates, int target, int sum, int dep, ArrayList<Integer> list){
        if (sum > target)
            return;
        if (sum == target){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = dep; i < candidates.length; i++){  // start from dep here, to make sure the list is unqiue
            if (cnadidates[i] > target) continue; //A small improvement is to skip candidates if they are larger then the target. It won't reduce big-O complexity but it can reduce the running time practically.
            list.add(candidates[i]);
            DFS(candidates, target, sum + candidates[i], i, list);  // error : DFS(candidates, target, sum + candidates[i], dep+1, list);
            list.remove(list.size()-1);
        }
    }
}

// iterative
public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(candidates == null || candidates.length ==0)
            return new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        
        for(int i=1; i<=target; i++){
            ArrayList<ArrayList<Integer>> v = new ArrayList<ArrayList<Integer>>();
            for(int j=0; j<= candidates.length; j++){// notice j=0 , not j=c
                if(i == candidates[j]){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    v.add(temp);
                }else if(i> candidates[j]){
                    int prev_num = i-candidates[j];
                    ArrayList<ArrayList<Integer>> prev = map.get(prev_num);// here lead to duplicate
                    if(prev!=null){
                        for(ArrayList<Integer> list: prev){
                            if(list.get(list.size() -1) <= candidates[j]){
                                ArrayList<Integer> new_list = new ArrayList<Integer>(list);
                                new_list.add(candidates[j]);
                                v.add(new_list);
                            }
                        }
                    }
                }
            }
            if(v.size() > 0){
                map.put(i, v);
            }
        }
        if(map.get(target) == null)
            return new ArrayList<ArrayList<Integer>>();
        return map.get(target);
    }

