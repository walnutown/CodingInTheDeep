public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    ArrayList<Integer> res;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        res = new ArrayList<Integer>();
        if(num == null || num.length == 0){
            return resList;
        }
        
        Set<Integer> visitedVal = new HashSet<Integer>();
        Set<Integer> visitedIndex = new HashSet<Integer>();
        
        permuteHelper(num, 0, visitedIndex);
        
        return resList;
    }
    
    public void permuteHelper(int[] num, int depth, Set<Integer> visitedIndex){
        if (depth == num.length){
            return;
        }
        Set<Integer> visitedVal = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++){
            if (visitedVal.contains(num[i])){
                continue;
            }
            if (visitedIndex.contains(i)){
                continue;
            }
            visitedVal.add(num[i]);
                visitedIndex.add(i);
                res.add(num[i]);
                if (depth == num.length - 1){
                    ArrayList<Integer> temp = new ArrayList<Integer>(res);
                    resList.add(temp);
                }
                permuteHelper(num, depth+1, visitedIndex);
                
                visitedIndex.remove(i);
                res.remove(depth);
        }
    }
}


