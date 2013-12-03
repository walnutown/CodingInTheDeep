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



// trial 2
// Submission Result: Wrong Answer
// Input:  "a"
// Output: []
// Expected: [["a"]]

// Submission Result: Wrong Answer
// Input:  "ab"
// Output: [["b","a"]]
// Expected: [["a","b"]]

// Submission Result: Wrong Answer
// Input:  "bb"
// Output: []
// Expected: [["b","b"],["bb"]]

// same alogrithm as the first attempt, but complex and hard to implement, fail
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // the basic idea is to traverse the string with index i
        // if sbustring(0, i + 1) is a palindrome, check if the remaining
        // substring(i+1, s.length()) is a palindrome, if yes, add into the result list
        // otherwise, continue
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s.length() == 0)
            return res;
        if (s.length() == 1){
            ArrayList<String> r = new ArrayList<String>();
            r.add(s);
            res.add(r);
            return res;
        }
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s.substring(0, i+1))){
               String newStr = s.substring(0, i+1);
               res = partition(s.substring(i+1, s.length()));
               if (res != null){
                   for (int j = 0; j < res.size(); j++)
                       res.get(j).add(newStr);
               }
            }
        }
        return res;
    }      
    public boolean isPalindrome(String s){
        if (s.length() == 0 || s.length() == 1)
            return true;
        int i = 0;
        int j = s.length()- 1;
        while (i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }
}
// refactor DFS, Time Complexity: n * (n-1) * (n-2)... * 1
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s.length() == 0)
            return res;
        DFS(s, 0, res, new ArrayList<String>());
        return res;
    }  
    public void DFS(String s, int start, ArrayList<ArrayList<String>> res, ArrayList<String> r){
        if (start == s.length()){
            res.add(new ArrayList<String>(r));
            return;
        }
        for (int i = start+1 ; i <= s.length(); i++){
            String newStr = s.substring(start, i);
            if (isPalindrome(newStr)){
                r.add(newStr);
                DFS(s, i, res, r);
                r.remove(r.size()-1);
            }
        }
    }    
    public boolean isPalindrome(String s){
        if (s.length() == 0 || s.length() == 1)
            return true;
        int i = 0;
        int j = s.length()- 1;
        while (i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }
}

// DP, modified from the first attempt, O(n*n)
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // mem stores the result of valid partitions of substring(0,i)
      Map<Integer, ArrayList<ArrayList<String>>> mem = new HashMap<Integer, ArrayList<ArrayList<String>>>();
      mem.put(0, new ArrayList<ArrayList<String>>());
      for (int i = 1; i <= s.length(); i++) {
         ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
         for (int j = i - 1; j >= 0; j--) {
            String newStr = s.substring(j, i);
            if (isPalindrome(newStr)) {
               ArrayList<ArrayList<String>> tmp = new ArrayList<ArrayList<String>>();
               ArrayList<ArrayList<String>> prev = mem.get(j);
               if (prev.size() == 0) {
                  ArrayList<String> r = new ArrayList<String>();
                  r.add(newStr);
                  tmp.add(r);
               } else {
                  for (ArrayList<String> p : prev) {
                     ArrayList<String> r = new ArrayList<String>(p);
                     r.add(newStr);
                     tmp.add(r);
                  }
               }
               res.addAll(tmp);
            }
         }
         mem.put(i, res);
      }
      return mem.get(s.length());
    }      
    public boolean isPalindrome(String s){
        if (s.length() == 0 || s.length() == 1)
            return true;
        int i = 0;
        int j = s.length()- 1;
        while (i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }
}




