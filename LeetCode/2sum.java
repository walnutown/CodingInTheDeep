// brute force, O(n^2)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        if (numbers == null || numbers.length == 1){
            return result;
        }
        
        for (int i = 0; i < numbers.length-1 ; i ++){
            for(int j = i +1; j < numbers.length; j++){
                if (numbers[i] + numbers[j] == target){
                    result[0] = i+1;
                    result[1] = j+1;
                }
            }
        }
        return result;
        
    }
}

// two map traverse, O(n)
// exactly one solution, so every number in the array is unique
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2){
            return result;
        }
        
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i < numbers.length; i ++){
            map.put(numbers[i], i);
        }
        
        for(int j = 0; j < numbers.length; j++){
            if (map.containsKey(target - numbers[j]) && map.get(target - numbers[j]) > j){
                result[0] = j + 1;
                result[1] = map.get(target - numbers[j]) +1;
                return result;
            }
        }
        return result;
        
    }
}

// from two ends to the middle, need to improve, how to solve the 
// index store problem? e.g. 1,4,4,5   we don't know the index of 4 after sort

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2){
            return result;
        }
        
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
            
            else if (numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        
        return result;
        
    }
}


// Submission Result: Wrong Answer

// Input:  [3,2,4], 6
// Output: 1, 1
// Expected:   2, 3
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> index_map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        if (numbers == null || numbers.length <= 1)
            return null;
        for (int i = 0; i < numbers.length; i++){
            index_map.put(numbers[i], i+1);
        }
        for (int i = 0; i < numbers.length; i++){
            if (index_map.containsKey(target - numbers[i])){
                res[0] = i+1;
                res[1] = index_map.get(target-numbers[i]);
                Arrays.sort(res);
                break;
            }
        }
        return res;
    }
}


// Accepted, Dec 24, use map to track the index of number
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> index_map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        if (numbers == null || numbers.length <= 1)
            return null;
        for (int i = 0; i < numbers.length; i++){
            index_map.put(numbers[i], i+1);
        }
        for (int i = 0; i < numbers.length; i++){
            int second = target - numbers[i];
            if (index_map.containsKey(second) && index_map.get(second) != i+1){   // index cannot be the same here
                res[0] = i+1;
                res[1] = index_map.get(second);
                Arrays.sort(res);
                break;
            }
        }
        return res;
    }
}