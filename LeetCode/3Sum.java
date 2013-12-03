// brute force, time litmit exceed
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // no duplicates, non-descending order
        Set<Long> resultSet = new HashSet<Long>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3){
            return resultList;
        }
        
        for (int i = 0; i < num.length -2; i++){
            for(int j = i + 1; j < num.length -1; j++){
                for (int k = j + 1; k < num.length; k++){
                    if (num[i] + num[j] + num[k] == 0){
                        
                        // use native APi to sort
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        int[] res = {num[i], num[j], num[k]};
                        Arrays.sort(res);
                        result.add(res[0]);
                        result.add(res[1]);
                        result.add(res[2]);
                        
                        //ArrayList<Integer> result;
                        //result = sort(new int[]{num[i], num[j], num[k]}); 
                        long resultHash = hash(result);
                        if (!resultSet.contains(resultHash)){
                            resultList.add(result);
                            resultSet.add(resultHash);
                        }
                        
                    }
                }
            }
        }
        
        return resultList;
    }
    
    public ArrayList<Integer> sort(int[] num){
       // bubble sort
       for (int i = 0; i < num.length -1 ; i ++){
           for ( int j = i + 1; j < num.length; j ++){
               if (num[i] > num[j]){
                   int temp = num[i];
                   num[i] = num[j];
                   num[j] = temp;
               }
           }
       }
       
       // store result into arraylist
       ArrayList<Integer> result = new ArrayList<Integer>();
       for(int k = 0; k < num.length; k ++){
           result.add(num[k]);
       }
       
       return result;
    }
    
    public long hash(ArrayList<Integer> result){
        long hashNum = result.get(0) * 12345 + result.get(1) * 6789 + result.get(2) * 888; 
        return hashNum;
    }
}

// sort the array, one traverse, in which is a 2Sum method
// the one travser of the first change the 3SUm to 3Sum problem
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3){
            return resList;
        }
        
        Set<ArrayList<Integer>> resSet = new HashSet<ArrayList<Integer>>(); 
        Arrays.sort(num);
        
        for (int i = 0; i < num.length-2; i++){
            int two_sum = 0 - num[i];
            
            // find two sum
            int j = i +1;
            int k = num.length -1;
            while (j < k){
                if (num[j] + num[k] == two_sum){
                    int[] resArr = {num[i], num[j], num[k]};
                    Arrays.sort(resArr);
                    ArrayList<Integer> resArrList = new ArrayList<Integer>();
                    resArrList.add(resArr[0]);
                    resArrList.add(resArr[1]);
                    resArrList.add(resArr[2]);
                    if (!resSet.contains(resArrList)){
                        resSet.add(resArrList);
                        resList.add(resArrList);
                    }
                    j++;
                    k--;
                }
                else if (num[j] + num[k] < two_sum){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        
        return resList;
    }
}

// trial #2, wrong answer
//Input:    []
//Output: null
//Expected:   []
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // sum = a + b + c; we traverse the array in a , then solve the porblem as two-sum-problem, sum -a = b + c
        // to get the non-descending order, we sort the array first
        // to remove duplicates, we skip the visited integer and traverse b,c with b > a && c > a
        
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length <= 2)
            return null;
        Arrays.sort(num);
        int prev = 0;
        for (int i = 0; i < num.length; i++){     // i should be less than num.lenght -2 
            if (i > 0){
                if (num[i] == prev )
                    continue;
            }
            int j = i + 1;
            int k = num.length-1;
            while (j < k){
                if (num[j] + num[k] < 0 - num[i])
                    j++;
                else if (num[j] + num[k] > 0 - num[i])
                    k--;
                else{
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(num[i]);
                    res.add(num[j]);
                    res.add(num[k]);
                    resList.add(res);
                    break;                  // cannot break here, (e.g.  [-2,0,1,1,2], will miss [-2,1,1])
                }
            }
            prev = num[i];                      // ridiculous to use prev, why not num[i-1]?
        }
        return resList;
    }
}
// without set
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length <= 2)
            return resList;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++){
            if (i > 0 && num[i] == num[i-1])
                continue;
            int j = i + 1;
            int k = num.length-1;
            while (j < k){
                if (num[j] + num[k] < 0 - num[i])
                    j++;
                else if (num[j] + num[k] > 0 - num[i])
                    k--;
                else{
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(num[i]);
                    res.add(num[j]);
                    res.add(num[k]);
                    resList.add(res);
                    do{j++;} while (j < k && num[j] == num[j-1]);
                    do{k--;} while (j < k && num[k] == num[k+1]);
                }
            }
        }
        return resList;
    }
}




