public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // assume that hte words in L is distinct
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null){
            return res;
        }
        
        int Slen = S.length();
        int wLen = L[0].length();
        int Llen = L.length * wLen;
         
        if (Llen == 0){
            res.add(0);
            return res;
        }
        if (Slen < Llen){
            return res;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++){
            if (map.containsKey(L[i])){
                map.put(L[i], map.get(L[i]) + 1);
            }
            else{
                map.put(L[i], 1);
            }  
        }
        
        for (int i = 0; i <= Slen - Llen ; i++){
            int sIndex = i;
             Map<String, Integer> tempMap = new HashMap<String, Integer>(map);
            String curr = S.substring(sIndex, sIndex + wLen);
            while(tempMap.containsKey(curr)){
                if (tempMap.get(curr) == 1){
                    tempMap.remove(curr);
                }
                else{
                    tempMap.put(curr, tempMap.get(curr) -1);    
                }
                
                if (tempMap.size() == 0){
                    res.add(i);
                    break;
                }
                sIndex += wLen;
                if (sIndex + wLen > Slen){
                    break;
                }
                curr = S.substring(sIndex, sIndex + wLen);
            }
        }         
        return res;
    }
}



public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S==null || S.length()==0 || L==null || L.length==0) return res;
        int n = L[0].length(), m=S.length();
        if (m < L.length * n)  return res;
        Map<String, Integer> dict = new HashMap<String, Integer>();
        for (String w : L){
            if (dict.containsKey(w))    dict.put(w, dict.get(w)+1);
            else dict.put(w, 1);
        }
        for (int i=0; i <= m-n*L.length; i++){          // i<= m - n*L.length, important here; if i<m, TLE
            Map<String, Integer> tmp = new HashMap<String, Integer>(dict);
            int j=i;
            while (j+n <= m){
                String w = S.substring(j, j+n);
                if (!tmp.containsKey(w)) break;
                tmp.put(w, tmp.get(w)-1);
                if (tmp.get(w) == 0)    tmp.remove(w);
                if (tmp.isEmpty()){
                    res.add(i); break;
                }
                j += n;
            }
        }
        return res;
    }
}
