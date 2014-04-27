/*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
    You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
    The solution is guaranteed to be unique.
*/

// The naive solution is to choose each station as starting point and see if we can get
// finish the journey.
// time: O(n^2); space: O(1)


// Maintain two pointers, to mark the starting and ending point of the journey
// Each time, if the vol is enough, we go to next station;
// otherwise, change the 'start' to until we can get to 'end' with the vol
// time: O(n); space: O(1)
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || cost==null)
            return -1;
        int N = gas.length, start=0, end = 1, vol =gas[0]-cost[0];
        if (N==1)   return vol>=0? 0 : -1;
        while (true){
            while (start!=end && vol<0){
                vol -= gas[start]-cost[start];
                start = (start+1)%N;
                if (start==0)   return -1;  // all the starting points have been tried
            }
            vol += gas[end]-cost[end];
            end = (end+1)%N;
            if (end==start && vol>=0)  return start;     // we've finished a loop
        }
    }
}


// The following solution use the observations that:
// [1] we can finish the journey if the sum of gas[i]-cost[i] is no less than 0
// [2] Because there's only one valid starting point, if we find that we cannot go from
// i to j (sum[i,j]<0), then we cannot go from k (k is in [i,j)) to j. 
// Why? if we can go from k to j, sum[k,j]>0, then sum[i,k)<0, we should have 
// changed the starting point here, which contradicts the fact.
// time : O(n); space: O(1)   
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, sum = 0, res = 0;
        for (int i=0; i<gas.length; i++){
            rest += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum<0){
                res = i+1;
                sum = 0;
            }
        }
        return rest>=0 ? res : -1;
    }
}