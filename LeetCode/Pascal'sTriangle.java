public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (numRows == 0){
            return resList;
        }
        res.add(1);
        map.put(1, new ArrayList<Integer>(res));
        resList.add(new ArrayList<Integer>(res));
        if (numRows == 1){
            return resList;
        }
        res.add(1);
        map.put(2, new ArrayList<Integer>(res));
        resList.add(new ArrayList<Integer>(res));
        if (numRows == 2){
            return resList;
        }
        
        for(int i = 3 ; i<= numRows; i++){
            ArrayList<Integer> prev = map.get(i-1);
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for( int j = 1; j < prev.size(); j++){
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            map.put(i, curr);
            resList.add(curr);
        }

        return resList;
        
    }
}

// no map, get the previous line from arraylist
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (numRows == 0){
            return resList;
        }
        res.add(1);
        resList.add(new ArrayList<Integer>(res));
        if (numRows == 1){
            return resList;
        }
        res.add(1);
        resList.add(new ArrayList<Integer>(res));
        if (numRows == 2){
            return resList;
        }
        
        for(int i = 3 ; i<= numRows; i++){
            ArrayList<Integer> prev = resList.get(i-2);
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for( int j = 1; j < prev.size(); j++){
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            resList.add(curr);
        }

        return resList;
        
    }
}

// trial #2
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // n[row][0] = 1, n[row][last] = 1
        // n[row][i] = n[row-1][i-1] + n[row-1][i+1]
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return res;
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        res.add(new ArrayList<Integer>(prev));
        if (numRows == 1)
            return res;
        for (int i = 2; i <= numRows; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 1 ; j < prev.size(); j++){
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}
// refactor code
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // n[row][0] = 1, n[row][last] = 1
        // n[row][i] = n[row-1][i-1] + n[row-1][i+1]
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return res;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        for (int i = 2; i <= numRows; i++){
            ArrayList<Integer> prev = res.get(i-2);  // get prev directly here from the result arraylist
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 1 ; j < prev.size(); j++){
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}

// Accepted
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows <=0)    return res;
        ArrayList<Integer> prev = new ArrayList<Integer>(); prev.add(1);
        res.add(prev);
        for (int i=2; i<=numRows; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            for (int j=0; j<=prev.size(); j++){
                if (j==0)   curr.add(prev.get(0));
                else if (j==prev.size())  curr.add(prev.get(prev.size()-1));
                else    curr.add(prev.get(j-1) + prev.get(j));
            }
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}
// Accepted, Refactor code
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows <=0)    return res;
        ArrayList<Integer> prev = new ArrayList<Integer>(); prev.add(1);
        res.add(prev);
        for (int i=2; i<=numRows; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j=1; j<prev.size(); j++)   curr.add(prev.get(j-1) + prev.get(j));
            curr.add(1);
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}