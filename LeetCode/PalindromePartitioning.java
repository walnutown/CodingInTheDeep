public class Solution {
    Map<Integer, ArrayList<ArrayList<String>>> mem;
    //ArrayList<ArrayList<String>> resList;
    //ArrayList<String> res;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        mem = new HashMap<Integer, ArrayList<ArrayList<String>>>();
        mem.put(0, new ArrayList<ArrayList<String>>());
        if (len == 0){
            return mem.get(0);
        }
        //resList = new ArrayList<ArrayList<String>>();    
    //    res = new ArrayList<String>();
      //  res.add(s.substring(0, 1));
        //resList.add(res);
        //mem.put(1, new ArrayList<ArrayList<String>>(resList)));
        //if (len == 1){
          //  return mem.get(1);
    //    }
        
        for (int i = 2; i <= len; i++){
            int last = i;
            int mid = i-1;
            while (mid >=0){
                String right = s.substring(mid, last);
                if (isPalindrome(right)){
                    ArrayList<ArrayList<String>> tempList = new ArrayList<ArrayList<String>>(mem.get(mid));
                    for (ArrayList<String> temp:tempList){
                        temp.add(right);
                    }
                    mem.put(mid, tempList);
                }
                mid--;
            }
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