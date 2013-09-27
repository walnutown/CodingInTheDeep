public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    ArrayList<Integer> res;
    Set<ArrayList<Integer>> set;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        set = new HashSet<ArrayList<Integer>>();
        resList = new ArrayList<ArrayList<Integer>>();
        res = new ArrayList<Integer>();
        resList.add(new ArrayList<Integer>());
        
        if (num.length == 0){
            return resList;
        }
        Arrays.sort(num);
        DFS(num, 0);
        return resList;
    }
    
    public void DFS(int[] num, int index){
        if (index == num.length){
            return;
        }
        for (int i = index ; i < num.length; i++){
            res.add(num[i]);
            if (!set.contains(res)){
                set.add(new ArrayList<Integer>(res));
                resList.add(new ArrayList<Integer>(res));
            }
            DFS(num, i+1);
            res.remove(res.size()-1);
        }
    }
}


// #2 trial, DFS, see the link for iteration solution
// http://n00tc0d3r.blogspot.com/2013/06/subsets.html
public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    res = new ArrayList<ArrayList<Integer>>();
    res.add(new ArrayList<Integer>());
    if (num == null || num.length == 0)
        return res;
    Arrays.sort(num);
    DFS(num, 0, new ArrayList<Integer>());
    return res;    
    }
    
    public void DFS(int[] num, int dep, ArrayList<Integer> row){
        if (dep == num.length)
            return;
        for (int i = dep; i < num.length; i++){
            if (i >dep && num[i] == num[i-1]) continue;  // i>dep, to make sure that the first occurance of a number should be added into the set. The duplicate one after the first one should be ignored to avoid duplicate
            row.add(num[i]);
            res.add(new ArrayList<Integer>(row));
            DFS(num, i+1, row);
            row.remove(row.size()-1);
        }
    }
}