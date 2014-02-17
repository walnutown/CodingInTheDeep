/*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
    You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
    The solution is guaranteed to be unique.
*/

// two points: 
//    <1> condition of traveling around the circuit
//    <2> maximum subarray 
// time : O(n)    
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