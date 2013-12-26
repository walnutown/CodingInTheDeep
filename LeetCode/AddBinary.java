public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder res = new StringBuilder();
        if (a == null && b == null){
            return "";
        }
        if (a.length() == 0 && b.length() == 0){
            return "";
        }
        
        if (a.length() == 0 && b.length() > 0){
            return b;
        }
        if (a.length() > 0 && b.length() == 0){
            return a;
        }
        
        int i = a.length() -1;
        int j = b.length() -1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 && j >= 0){
            int A = a.charAt(i) - '0';
            int B = b.charAt(j) - '0';
            sum = A^B^carry;
            res.insert(0, sum);
            carry &= A^B;
            carry += A&B;
            i--;
            j--;
        }
        //if (i >= 0 && j == -1){
            while (i >= 0){
                int A = a.charAt(i) - '0';
                sum = A ^ carry;
                res.insert(0, sum);
                carry = (A + carry) /2;
                i--;
            }
            
        //}
        
        //if (i == -1 && j >= 0){
            while (j >= 0){
                int B = b.charAt(j) - '0';
                sum = B ^ carry;
                res.insert(0, sum);
                carry = (B + carry) /2;
                j--;
            }
        //}
        
        if (carry > 0){
                res.insert(0, carry);
            }
        
        return res.toString();
        
    }
}

// Accepted, Dec25
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a == null || b == null) return a == null ? b : a;
        if (a.length() == 0 || b.length() == 0) return a.length() == 0 ? b : a;
        int carry=0;
        int i = a.length()-1, j = b.length()-1;
        while (i>=0 && j>=0){
            int num1 = a.charAt(i--) - '0';
            int num2 = b.charAt(j--) - '0';
            sb.insert(0, (num1+num2+carry)%2);
            carry = (num1+num2+carry)/2;
        }
        while(i>=0){
            int num1 = a.charAt(i--) - '0';
            sb.insert(0, (num1+carry)%2);
            carry = (num1+carry)/2;
        }
        while(j>=0){
            int num2 = b.charAt(j--) - '0';
            sb.insert(0, (num2+carry)%2);
            carry = (num2+carry)/2;
        }
        if (carry > 0)  sb.insert(0, 1);
        return sb.toString();
    }
}


public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] newStrs = new String[strs.length];
        
        for (int i = 0; i < strs.length; i++){
            char[] charStr = strs[i].toCharArray();
            Arrays.sort(charStr);
            newStrs[i] = new String(charStr);
            if (!map.containsKey(newStrs[i])){
                map.put(newStrs[i], i);
            }
            else {
                if (int prev = map.get(newStrs[i]) >= 0){
                    res.add(strs[prev]);
                    map.put(newStrs[i], -1);
                }
                res.add(strs[i]);
            }
        }   
        return res;
    }
}

