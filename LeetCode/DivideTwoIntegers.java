/*
    Divide two integers without using multiplication, division and mod operator.
*/

// map + bit manipulation
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0)  return 0;
        long d = Math.abs((long)dividend);              // avoid overflow
        long s = Math.abs((long)divisor);
        Map<Integer, Long> map = new HashMap<Integer, Long>();      // divisor mapping
        int key = 0;
        while (s <= d){
            map.put(key++, s);
            s = s << 1;
        }
        int res = 0;
        while (--key >= 0 ){                // remember to '--' first
            if (d >= map.get(key)){
                d -= map.get(key);
                res += 1 << key;
            }
        }
        return (dividend > 0) ^ (divisor > 0) ? -res : res;     // ^ is both bitwise and logical XOR in java
    }
}