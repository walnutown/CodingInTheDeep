// Output Limit Exceed
public class Solution {
   ArrayList<String[]> resList;
   Set<Integer> reached;

   public ArrayList<String[]> solveNQueens(int n)
   {
      // Start typing your Java solution below
      // DO NOT write main() function
      resList = new ArrayList<String[]>();
      reached = new HashSet<Integer>();
      if (n == 0)
      {
         return resList;
      }

      if (n == 1)
      {
         resList.add(new String[]
         { "Q" });
      }
      String[] res = new String[n];
      DFS(1, n, res, -1, -1);

      return resList;
   }

   public void DFS(int depth, int n, String[] res, int left, int right)
   {
      if (depth > n)
      {
         return;
      }

      for (int i = 0; i < n; i++)
      {
         if (reached.contains(i) || left == i || right == i)
         {
            continue;  // attention! not return here
         }
         else
         {
            reached.add(i);
            res[depth - 1] = createStr(i, n);
            int l = -1;
            int r = -1;
            if (i - 1 >= 0)
            {
               l = i-1;
               //reached.add(i - 1);
            }
            if (i + 1 <= n - 1)
            {
               r = i+1;
               //reached.add(i + 1);
            }
            if (depth == n)
            {
               String[] temp = (String[]) res.clone();
               resList.add(temp);
            }
            DFS(depth + 1, n, res, l, r);

            reached.remove(i);
         }
      }
   }

   public String createStr(int i, int n)
   {
      StringBuilder s = new StringBuilder();
      int index = 0;
      while (index < n)
      {
         s.append('.');
         index++;
      }
      s.setCharAt(i, 'Q');
      return s.toString();
   }
}


// DFS
public class Solution {
   ArrayList<String[]> resList;
   
   int[] pos;
   public ArrayList<String[]> solveNQueens(int n)
   {
      // Start typing your Java solution below
      // DO NOT write main() function
      resList = new ArrayList<String[]>();
      pos = new int[n];
      if (n == 0)
      {
         return resList;
      }

      DFS(1, n);

      return resList;
   }

   public void DFS(int depth, int n)
   {
      if (depth > n)
      {
         return;
      }

      for (int i = 0; i < n; i++)
      {
         pos[depth-1] = i;
         if (isValid(depth-1))
         { 
            if (depth == n){
                addToList(n);
            }
            DFS(depth + 1, n);

         }
      }
   }
   
   public boolean isValid(int index){
       for (int i = 0; i < index; i++){
           if (pos[i] == pos[index] || Math.abs(pos[index] - pos[i]) == index-i){
               return false;
           }
       }
       return true;
   }

   public void addToList(int n)
   {
      String[] res = new String[n];
      for (int i = 0; i < n; i++){
          StringBuilder row = new StringBuilder();
          for (int j = 0 ; j< n; j++){
              if (pos[i] == j){
                  row.append('Q');
              }
              else{
                  row.append('.');
              }
          }
          res[i] = row.toString();
      }
      
      resList.add(res);
   }
}


//Output Limit Exceed, #2 trial
public class Solution {
    ArrayList<String[]> res;
    Set<Integer> prev;
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<String[]>();
        prev = new HashSet<Integer>();
        if (n <= 0)
            return res;
        for(int i  =0 ; i < n; i++){
            DFS(i, 0, new String[n]);
        }
        return res;
    }
    
    public void DFS(int x, int y, String[] m){
        
        prev.add(x);
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < m.length; i++){
            if (x != i)
                row.append('.');
            else
                row.append('Q');
        }
        m[y] = row.toString();
        if (y == m.length-1){
            prev.remove(x);
            res.add(m);
            return;
        }
        for(int i=0; i< m.length; i++){
            if (i != x-1 && i !=x+1 && !prev.contains(i))
                DFS(i, y+1, m);
        }
        prev.remove(x);
    }
}