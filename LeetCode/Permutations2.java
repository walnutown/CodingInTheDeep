/*
  Given a collection of numbers that might contain duplicates, return all possible unique permutations.

  For example,
  [1,1,2] have the following unique permutations:
  [1,1,2], [1,2,1], and [2,1,1].
*/

// DFS, O(n!)
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
          ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
          if (num==null || num.length==0) return res;
          Arrays.sort(num);   // Remember to sort here
          boolean[] visited = new boolean[num.length];
          finder(num, 0, res, new ArrayList<Integer>(), visited);
          return res;
      }
      public void finder(int[] num, int len, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r, boolean[] visited){
          if (len == num.length){
              res.add(new ArrayList<Integer>(r));
              return;
          }
          Set<Integer> visited_val = new HashSet<Integer>();        // to avoid using duplicate values in one loop
          for (int i=0; i<num.length; i++){
              if (visited_val.contains(num[i]) || visited[i])    continue;
              r.add(num[i]);
              visited[i] = true;
              visited_val.add(num[i]);
              finder(num, len+1, res, r, visited);
              r.remove(r.size()-1);
              visited[i] = false;
          }
      }
}


// In place swap, swap different values to current position
// if same value is encountered, skip it
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
          ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
          Arrays.sort(num);
          perm(num, 0, res);
          return res;
    }
     
    private void perm(int[] num, int index, ArrayList<ArrayList<Integer>> res){
        if (index==num.length){
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int val:num)   r.add(val);
            res.add(r);
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i=index; i<num.length; i++){
            if (set.contains(num[i])) // avoid same value
                continue;
            swap(num, index, i);
            perm(num, index+1, res);
            swap(num, index, i);
            set.add(num[i]);
        }
    }  
    
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

