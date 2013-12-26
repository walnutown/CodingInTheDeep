// Java arrayList reference is terrible if you wanna deep copy the arrayList
public class Solution {
    Map<Integer, ArrayList<ArrayList<String>>> mem;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        mem = new HashMap<Integer, ArrayList<ArrayList<String>>>();
        mem.put(0, new ArrayList<ArrayList<String>>());
        if (len == 0){
            return mem.get(0);
        }

       for (int i = 1; i <= len; i++)
      {
         int last = i;
         int mid = i - 1;
         ArrayList<ArrayList<String>> resList = new ArrayList<ArrayList<String>>();
         while (mid >= 0)
         {
            String right = s.substring(mid, last);
            if (isPalindrome(right))
            {
               ArrayList<ArrayList<String>> leftList = mem.get(mid);
               ArrayList<ArrayList<String>> tempList = new ArrayList<ArrayList<String>>(); // create a new arraylist<arraylist> each time
               if (leftList.size() == 0)
               {
                  ArrayList<String> temp = new ArrayList<String>();
                  temp.add(right);
                  tempList.add(temp);
               }
               else
               {
                  for (ArrayList<String> left : leftList)
                  {
                     ArrayList<String> temp = new ArrayList<String>(left);
                     temp.add(right);
                     tempList.add(temp);
                  }
               }
               resList.addAll(tempList);
            }
            mid--;
         }
         mem.put(i, resList);
      }

      return mem.get(len);
   }
    
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}

// DFS 
public class Solution {
    ArrayList<ArrayList<String>> resList;
    ArrayList<String> res;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        resList = new ArrayList<ArrayList<String>>();
        res = new ArrayList<String>();
        if (len == 0){
            return resList;
        }
        
        DFS(s, 0);

      return resList;
   }
   
   public void DFS(String s, int start){
       if (start == s.length()){
           resList.add(new ArrayList<String>(res));
           return;
       }
       for (int i=start; i < s.length(); i++){
           String left = s.substring(start, i+1);
           if (isPalindrome(left)){
               res.add(left);
               DFS(s, i+1);
               res.remove(res.size()-1);
           }
           
       }
   }
    
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}


// Memory Limited Exceeded
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)   return res;
        finder(s, 0, res, new ArrayList<String>());
        return res;
    }
    
    public void finder(String word, int index, ArrayList<ArrayList<String>> res, ArrayList<String> r){
        if (index == word.length()){
            res.add(new ArrayList<String>(r));
            return;
        }
        for (int i = index+1; i <= word.length(); i++){     // i = index+1, this may cause index == word.length() fails
            String w = word.substring(index, i);
            if (isPalindrome(w)){
                r.add(w);
                finder(word, i, res, r);
                r.remove(r.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String w){
        if (w == null || w.length() == 0)   return false;
        int i = 0, j = w.length()-1;
        while (i < j)
            if (w.charAt(i++) != w.charAt(j--)) break;
        return i >= j;
    }
}


// Accepted, Dec 25
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)   return res;
        finder(s, 0, res, new ArrayList<String>());
        return res;
    }
    
    public void finder(String s, int index, ArrayList<ArrayList<String>> res, ArrayList<String> r){
        if (index == s.length()){
            res.add(new ArrayList<String>(r));
            return;
        }
        for (int i = index; i < s.length(); i++){
            String w = s.substring(index, i+1);
            if (isPalindrome(w)){
                r.add(w);
                finder(s, i+1, res, r);
                r.remove(r.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String w){
        if (w == null || w.length() == 0)   return false;
        int i = 0, j = w.length()-1;
        while (i < j)
            if (w.charAt(i++) != w.charAt(j--)) return false;
        return true;
    }
}