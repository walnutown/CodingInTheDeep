// doesn't work, mainly about math deduction, but not program
// http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html
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

// TLE, use nextPermutation
public class Solution {
    public String getPermutation(int n, int k) {
        // assume 1<=n<=9
        char[] p = new char[n];
        for (int i=0; i<n; i++) p[i] = (char)(i+'1');
        int len=1;
        for (int i=1; i<=n; i++) len*=i;
        k = k%len==0 ? len:k%len;       // in case k is larger than the total number of sequence
        for (int i=2; i<=k; i++){
            nextPermutation(p);
        }
        return String.valueOf(p);
    }
    public void nextPermutation(char[] p){
        int l = p.length - 1;
        while (l > 0 && p[l - 1] > p[l])    l--;
        Arrays.sort(p, l, p.length);
        if (l == 0) return;
        int i = l;
        while (p[l-1] >= p[i] && i<p.length)    i++;
        char tmp = p[l-1];
        p[l-1] = p[i];
        p[i] = tmp;
    }
}

// Accepted, from AnnieKim
public class Solution {
    public String getPermutation(int n, int k) {
        // assume 1<=n<=9, k<n!
      StringBuilder num = new StringBuilder();
      StringBuilder res = new StringBuilder();
      int len=1;
      for (int i=1; i<=n; i++){
          num.append(i);
          len *= i;
      }
      k--;  
      while (n > 0){
          len /= n;
          int i = k/len;
          k %= len;
          res.append(num.charAt(i));
          num.deleteCharAt(i);
          n--;
      }
      return res.toString();
    }
}