// count the number of each bit
public class Solution {
    public int singleNumber(int[] A) {
        int N = A.length, res = 0;
        for (int i=0; i<32; i++){
            int count = 0, bit = (1<<i);
            for (int j=0; j<N; j++){
                if ((A[j]&bit) != 0)   count++;
            }
            if (count%3 != 0)   res = (res | bit);
        }
        return res;
    }
}