// no pass the large judge, time limit exceed

public int climbingStairs(int num){
	if (num == 0){
		return 0;
	}
	if (num == 1){
		return 1;
	}
	if (num == 2){
		return 2;
	}

	return climbingStairs(num -1) + 1 + climbingStairs(num -2) + 2;
}

// DP memoization, pass both
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        ArrayList<Integer> mem = new ArrayList<Integer>();
        mem.add(0, 0);
        mem.add(1, 1);
        mem.add(2, 2);
        int i = 3;
        while ( i <= n){
            mem.add(i, mem.get(i-2) + mem.get(i-1)) ;
            i++;
        }
        
	return mem.get(n);
    }
}