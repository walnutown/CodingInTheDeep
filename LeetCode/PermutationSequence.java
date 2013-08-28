// TLE in large judge
public class Solution {
    String res;
    StringBuilder s;
    int count;
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = "";
        s = new StringBuilder();
        count = 0;
        if(n < 1 || n > 9 || k < 1){
            return res;
        }
        int seqLen = 1;
        for (int i = 1; i <= n; i++){
            seqLen *= i;
        }
        
        if (k > seqLen){
            return res;
        }
        
        permuteHelper(n, k, 1, new HashSet<Integer>());
        return res;
    }
    
    public void permuteHelper(int n, int k, int depth, Set<Integer> visited){
        if (depth > n){
            return;
        }
        
        for (int i = 1; i <= n; i++){
            if (visited.contains(i)){
                continue;
            }
            
            visited.add(i);
            s.append(i);
            if (depth == n){
                count++;
                if (count == k){
                    res = s.toString();
                }
            }
            
            permuteHelper(n, k, depth+1, visited);
            
            visited.remove(i);
            s.deleteCharAt(depth-1);
        }
    }
}



public class Solution {
    String res;
    StringBuilder s;
    int count;
    int startIndex;
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = "";
        s = new StringBuilder();
        
        if(n < 1 || n > 9 || k < 1){
            return res;
        }
        int seqLen = 1;
        for (int i = 1; i <= n; i++){
            seqLen *= i;
        }
        
        if (k > seqLen){
            return res;
        }
        
        if (n == 1 && k != 1){
            return res;
        }
        
        if (n == 1 && k == 1){
            return res+n;
        }
        
        if (k % (n-1) == 0){
            startIndex = k/(n-1);    
        }else{
            startIndex = k/(n-1) + 1;
        }
        
        count = (startIndex-1) * (n-1);
        
        
        permuteHelper(n, k, 1, new HashSet<Integer>());
        return res;
    }
    
    public void permuteHelper(int n, int k, int depth, Set<Integer> visited){
        if (depth > n){
            return;
        }
        
        for (int i = 1; i <= n; i++){
            if (depth == 1 && i != startIndex){
                continue;
            }
            
            if (visited.contains(i)){
                continue;
            }
            
            visited.add(i);
            s.append(i);
            if (depth == n){
                count++;
                if (count == k){
                    res = s.toString();
                }
            }
            
            permuteHelper(n, k, depth+1, visited);
            
            visited.remove(i);
            s.deleteCharAt(depth-1);
        }
    }
}



