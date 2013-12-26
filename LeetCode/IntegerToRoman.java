public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        int[] m = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int i = m.length -1;
        StringBuilder res = new StringBuilder();
        while(i >= 0 && num > 0){
            if (num -m[i] >= 0){
                res.append(map.get(m[i]));
                num -= m[i];
            }
            else{
                i--;
            }
        }
        
        return res.toString();
    }
}


// Accepted, Dec 25
public class Solution {
    public String intToRoman(int num) {
        if (num == 0)   return "";
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (num > 0){
           if ((num - nums[index]) < 0) index++;
           else{
               num -= nums[index];
               res.append(romans[index]);
           }
        }
        return res.toString();
    }
}