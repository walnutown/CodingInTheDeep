/*
    You are given a string, S, and a list of words, L, that are all of the same length. 
    Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    For example, given:
    S: "barfoothefoobarman"
    L: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).
*/



// use map to store word and freq
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
