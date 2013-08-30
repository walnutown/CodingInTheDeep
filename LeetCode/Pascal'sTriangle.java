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