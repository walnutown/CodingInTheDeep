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
        for(int i = 0; i <= rowIndex; i++){
            curr.add(1);
        }
        for(int i = 2; i <= rowIndex; i++){
            for(int j = i-1; j >= 1; j--){
                curr.set(j, prev.get(j-1) + prev.get(j));
            }
            prev = curr;
        }
        
        return curr;
    }
}

// Accepted
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0)  return res;
        for (int i=0; i<=rowIndex; i++) res.add(1);
        for (int i=1; i<=rowIndex; i++){
            for (int j=i-1; j>=0; j--){             // from i-1 to 1, if from 1 to i-1, wrong. we have to ensure that the j-1 is not overriden
                res.set(j, res.get(j) + res.get(j-1));
            }
        }
        return res;
    }
}