/*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target,
    where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
*/

// use map to store value-index, then traverse form both sides. 
// time: O(nlgn); space: O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2)      return result;
        // create index mapping
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i+1);
        } 
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length -1;
        while (i < j){
            if (numbers[i] + numbers[j] == target){
                result[0] = map.get(numbers[i]);
                result[1] = map.get(numbers[j]);
                Arrays.sort(result);
                return result;
            } 
            else if (numbers[i] + numbers[j] < target)      i++;
            else   j--;
        } 
        return result;
    }
}

// use map to find the index of 'target-value'
// Note that we may have two indices have the same value, so we need a list
// time: O(n); space: O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length<=1)
            return null;
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int N = numbers.length;
        for (int i=0; i<N; i++){
            int num = numbers[i];
            if (!map.containsKey(num)){
                ArrayList<Integer> lists = new ArrayList<Integer>();
                map.put(num, lists);
            }
            map.get(num).add(i+1);
        }
        for (int i=0; i<N; i++){
            int num = numbers[i];
            if (!map.containsKey(target-num))
                continue;
            for (int index : map.get(target-num)){
                if (index!=i+1){ // can not be itself
                    int[] res = new int[2];
                    res[0] = i+1; res[1] = index;
                    Arrays.sort(res);
                    return res;
                }
            }
        }
        return null;
    }
}