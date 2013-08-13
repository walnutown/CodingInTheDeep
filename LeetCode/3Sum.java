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