// A permutation is an ordered combination
// order does matter in permutation
// MLE in small judge
public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        resList.add(null);
        int len = S.length;
        if (S == null || len == 0){
            return resList;
        }
        
        for (int i = 1; i <= len; i++){
            int curr = S[i-1];
            for (int j = 0; j<resList.size(); j++){
                ArrayList<Integer> newRes; 
                if (resList.get(j) != null){
                    newRes = new ArrayList<Integer>(resList.get(j));
                }
                else{
                    newRes = new ArrayList<Integer>();
                }
                newRes.add(curr);
                resList.add(newRes);
            }
            
        }
        
        return resList;
    }
    
}

// DFS
public class Solution {
    ArrayList<ArrayList<Integer>> resList;
    ArrayList<Integer> res;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<Integer>>();
        res = new ArrayList<Integer>();
        resList.add(new ArrayList<Integer>());
        int len = S.length;
        if (S == null || len == 0){
            return resList;
        }
        // element in ubset should be in non-descending order
        Arrays.sort(S);
        
        DFS(S, 0);
        return resList;
    }
    
    public void DFS(int[] S, int depth){
        for(int i = depth; i < S.length; i++){
            res.add(S[i]);
            resList.add(new ArrayList<Integer>(res));
            DFS(S, i+1);
            res.remove(res.size()-1);
        }
    }
    
}


// better one, no extra space
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(num);
        
        int previousSize =0;
        for(int i=0; i< num.length;i++){
            int size = result.size();
            for(int j=0; j<size; j++){
                if(i==0 || num[i]!=num[i-1]|| j>=previousSize){
                    ArrayList<Integer> a = new ArrayList<Integer>(result.get(j));
                    a.add(num[i]);
                    result.add(a);
                }
            }
            previousSize = size;
        }
        return result;
    }
    
    //hashSet version, extra space, bad
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        return subsetsWithDup(num, num.length-1, new HashSet<ArrayList<Integer>>());
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int index, HashSet<ArrayList<Integer>> set){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(index <0){
            result.add(new ArrayList<Integer>());
        }else{
            result = subsetsWithDup(num, index -1, set);
            int size = result.size();
            for(int i=0; i<size; i++){
                ArrayList<Integer> tmp = new ArrayList<Integer>(result.get(i));
                tmp.add(num[index]);
                if(!set.contains(tmp)){
                    result.add(tmp);
                    set.add(tmp);
                }
            }
        }
        return result;
    }






