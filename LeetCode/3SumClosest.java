// same as the 3Sum, add sum value to track the minimum diff

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        if (num == null || num.length < 3){
            return sum;
        }
        
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
            int two_sum = target - num[i];
            int j = i + 1;
            int k = num.length -1;
            while (j < k){
                if (num[j] + num[k] == two_sum){     
                    return target;  
                }
                else if(num[j] + num[k] < two_sum){
                    if (Math.abs(num[j] + num[k] - two_sum) < diff){
                        sum = num[i] + num[j] + num[k];
                        diff = Math.abs(num[j] + num[k] - two_sum);
                    }
                    j++;
                }else{
                    if (Math.abs(num[j] + num[k] - two_sum) < diff){
                        sum = num[i] + num[j] + num[k];
                        diff = Math.abs(num[j] + num[k] - two_sum);
                    }
                    k--;
                }
            }
        }
        
        return sum;
    }
} 


// #2 trial, ttraverse the array, and choose twoSum on the remaining 2 numbers in array
public class Solution {
    int res;
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == null || num.length < 3)
            return 0;
        Arrays.sort(num);
        res = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length; i++){
            twoSum(num, i, target);
        }
        return res;
    }
    
    public void twoSum(int[] num, int thirdIndex, int target){
        int i =0;
        int j = num.length-1;
        while (i < j){
            if (i == thirdIndex){
                i++;
                continue;
            }
            if (j == thirdIndex){
                j--;
                continue;
            }
            int sum = num[thirdIndex] + num[i] + num[j];
            if ( Math.abs(target-res) > Math.abs(target- sum))
                res = sum;
            if (sum > target)
                j--;
            else if (sum == target){
                return;
            }
            else
                i++;
        }
    }
}