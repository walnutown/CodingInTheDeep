// use two arraylsits to store index and sum, to find solution about mapping between index and sum
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> resSet = new HashSet<ArrayList<Integer>>();
        if (num == null || num.length < 4){
            return resList;
        }
        Arrays.sort(num);
        
        // store two num sum into map, O(n^2)
        Map<ArrayList<Integer>, Integer> sumMap = new HashMap<ArrayList<Integer>, Integer>();
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> indexList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i<num.length-1; i++ ){
            for(int j = i+1; j<num.length;j++){
                ArrayList<Integer> index = new ArrayList<Integer>();
                index.add(i);
                index.add(j);
                int sum = num[i] + num[j];
                sumList.add(sum);
                sumMap.put(index, sum);
            }
        }
        
        // index mixed here
        Collections.sort(sumList);
        
        int i = 0;
        int j = sumList.size() -1;
        while(i < j){
            if (sumList.get(i) + sumList.get(j) == target){
                ArrayList<Integer> indexOne = indexList.get(i);
                int[] indexOneArr = new int[2];
                indexOneArr[0] = indexOne.get(0);
                indexOneArr[1] = indexOne.get(1);
                ArrayList<Integer> indexTwo = indexList.get(j);
                int[] indexTwoArr = new int[2];
                indexTwoArr[0] = indexTwo.get(0);
                indexTwoArr[1] = indexTwo.get(1);
                if (indexOneArr[0] != indexTwoArr[0] && indexOneArr[1] != indexTwoArr[1] && indexOneArr[1] != indexTwoArr[0] && indexOneArr[0] != indexTwoArr[1]){   
                    int[] res = { num[indexOneArr[0]], num[indexOneArr[1]], num[indexTwoArr[0]], num[indexTwoArr[1]]};
                    Arrays.sort(res);
                    ArrayList<Integer> resArrList = new ArrayList<Integer>();
                    resArrList.add(res[0]);
                    resArrList.add(res[1]);
                    resArrList.add(res[2]);
                    resArrList.add(res[3]);
                    if (!resSet.contains(resArrList)){
                        resSet.add(resArrList);
                        resList.add(resArrList);
                    }
                }
                if (sumList.get(i+1) == sumList.get(i)){
                    i++;
                    continue;
                }
                if(sumList.get(j-1) == sumList.get(j)){
                    j--;
                    continue;
                }
                i++;
                j--;
            }
            else if (sumList.get(i) + sumList.get(j) < target){
                i++;
            }
            else{
                j--;
            }
        }   
        return resList;
    }
}

// Accepted
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if (num==null || num.length<4) return new ArrayList<ArrayList<Integer>>(res);
        Arrays.sort(num);
        for (int i=0; i<num.length; i++){
            int a = num[i];
            for (int j=i+1; j<num.length; j++){
                int b = num[j];
                int p = j+1, q=num.length-1;
                while (p < q){
                    int c = num[p], d=num[q];
                    if (a+b+c+d == target){
                        ArrayList<Integer> r= new ArrayList<Integer>();
                        r.add(a); r.add(b); r.add(c); r.add(d);
                        res.add(r);
                        p++;q--;
                    }else if (a+b+c+d < target) p++;
                    else q--;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }
}