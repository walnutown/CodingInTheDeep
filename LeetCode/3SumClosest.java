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