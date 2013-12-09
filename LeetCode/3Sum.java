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