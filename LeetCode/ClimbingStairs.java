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

// trail #2
// Last executed input: 1

public class Solution {
    public int climbStairs(int n) {
        // we use DP here to store the solution to each step
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }
}
// Accepted
public class Solution {
    public int climbStairs(int n) {
        // we use DP here to store the solution to each step
        if (n <= 2)
            return n;
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }
}