public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if (rowIndex == 0){
            return res;
        }
        
        res.add(1);
        if (rowIndex == 1){
            return res;
        }
        
        ArrayList<Integer> prev = new ArrayList<Integer>(res);
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        for(int i = 2; i <= rowIndex; i++){
            for(int j = 1; j < prev.size(); j++){
                curr.set(j, prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
        }
        
        return curr;
    }
}