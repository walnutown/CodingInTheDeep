/*
    /*Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?
*/

// Initialzie a array of size n at first
// In each level, we update the values in range of [1...level]
// Note we have to update from the end of the array. 
// time: O(n^2); space: O(n)
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] row = new int[rowIndex+1];
        row[0] = 1;
        int i = 0;
        while (i<=rowIndex){
            for (int j=i;j>=1; j--){
                row[j] = row[j-1] + row[j];
            }
            i++;
        }
        for (int num: row)
           res.add(num);
        return res;
    }
}