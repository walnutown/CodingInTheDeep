// the data structure of this question is interesting, otherwise, we have to use ArrayList<ArrayList<ArrayList<Character>>>
public class Solution {
    ArrayList<String[]> resList;
    Set<Integer> reached;
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<String[]>();
        reached = new HashSet<Integer>();
        if (n == 0){
            return resList;
        }
        
        if (n == 1){
            resList.add(new String[]{"Q"});
        }
        String[] res = new String[n];
        DFS(1, n, res);
        
        return resList;
    }
    
    public void DFS(int depth, int n, String[] res){
        if (depth > n){
            return;
        }
        
        for (int i = 0; i < n; i++){
            if (reached.contains(i)){
                return;
            }else{
                reached.add(i);
                boolean left = false;
                boolean right = false;
                res[depth-1] = createStr(i, n);
                if ( i-1 >= 0 && !reached.contains(i-1)){
                    left = true;
                    reached.add(i-1);
                }
                if ( i+1 <= n-1 && !reached.contains(i+1)){
                    right = true;
                    reached.add(i+1);
                }
                if (depth == n){
                    resList.add(res);
                }
                DFS(depth+1, n, res);
                
                reached.remove(i);
                if ( left){
                    reached.remove(i-1);
                }
                if ( right){
                    reached.remove(i+1);
                }
                
            }
        }
    }
    
    public String createStr(int i, int n){
        StringBuilder s = new StringBuilder();
        int index = 0;
        while ( index < n){
            s.append(".");
            
        }
        
        s.setCharAt(i, 'Q');
        return s.toString();
    }
}