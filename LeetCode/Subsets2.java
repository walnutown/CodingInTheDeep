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