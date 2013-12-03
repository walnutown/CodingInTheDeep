// memory limit

//Submission Result: Wrong Answer
// Input:  "0", "0"
// Output: ""
// Expected:   "0"
public class Solution {
    public String multiply(String num1, String num2) {
        // arbitrarily large, take care of overflow
        // non-negative
        // 两数相乘的结果的最小和最大长度
        if (num1.length() == 0 || num2.length() == 0)
            return "";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length() ; i++){
            for (int j = 0; j < num2.length() ; j++){
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = res.length-1 ; i >= 0; i--){
            int curr = res[i];
            carry = (curr + carry) / 10;
            res[i] = (curr + carry) % 10;
        } // wrong here, should be the following
        // for (int i = res.length-1 ; i >= 0; i--){
        //     res[i] += carry;
        //     carry = res[i] / 10;
        //     res[i] = res[i] % 10;
        // }
        StringBuilder resStr = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0)
            i++;
        while (i < res.length)
            resStr.append(res[i]);
        return resStr.toString();
    }
}