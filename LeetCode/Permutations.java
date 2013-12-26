public class Solution {
     ArrayList<ArrayList<Integer>> resList;
     ArrayList<Integer> res;
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        resList = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0){
            return resList;
        }
        res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        permuteHelper(num, 0, set);
        
        return resList;
    }
    
    public void permuteHelper(int[] num, int depth, Set<Integer> set){
        if (depth == num.length){
            return;
        }
        for (int i = 0 ; i < num.length; i++){
            if (set.contains(num[i])){
                continue;
            }
            else{
                set.add(num[i]);
                res.add(num[i]);
                if (depth == num.length-1){
                    ArrayList<Integer> temp = new ArrayList<Integer>(res);
                    resList.add(temp);
                }
                permuteHelper(num, depth +1, set);
                
                set.remove(num[i]);
                res.remove(depth);
            }
        }
    }
}


// Accepted, Dec25
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        finder(num, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    public void finder(int[] num, int dep, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
        if (dep == num.length){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        for (int i = 0; i < num.length; i++){
            if (r.contains(num[i])) continue;
            r.add(num[i]);
            finder(num, dep+1, res, r);
            r.remove(r.size()-1);
        }
    }
}

