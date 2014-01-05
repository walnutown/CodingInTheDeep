
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

// Accepted
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num==null || num.length<3) return 0;
        int m = num.length; 
        Arrays.sort(num);                   // IMPORTANT, remember to sort here
        int min = num[0]+num[1]+num[2];
        for (int i=0; i<m; i++){
            int j=i+1, k=m-1;
            while(j<k){
                int sum = num[i] + num[j] + num[k];
                if (sum == target)    return target;
                else if (sum < target)  j++;
                else k--;
                if (Math.abs(target-sum) < Math.abs(target-min)) min = sum;
            }
        }
        return min;
    }
}