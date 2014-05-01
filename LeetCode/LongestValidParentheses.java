/*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    For "(()", the longest valid parentheses substring is "()", which has length = 2.

    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/


// how to differentiate "()(()" and "(()()", or "())()" and ")()()"

// DP
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() <=1){
            return 0;
        }
        int len = s.length();
        int max = 0;
        int[] mem = new int[len];
        mem[0] = 0;
        for(int i =1; i < len; i++){
            if (s.charAt(i) == ')'){
                int leftIndex = i -1 - mem[i-1];
                // check the match
                if (leftIndex >= 0 && s.charAt(leftIndex) == '('){
                    mem[i] = mem[i-1] + 2;
                    // plus the previous matches
                    if (leftIndex-1 >= 0){
                        mem[i] += mem[leftIndex-1];
                    }
                }
                
                max= Math.max(max, mem[i]);
            }
        }
        
        return max;
    }
}

// Accepted, from AnnieKim
// use stack to store the previous length, variant of DP 
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int max=0, count=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                st.push(count); count=0;
            }else{
                if (!st.isEmpty()){
                    count += 1+st.pop();
                    max = Math.max(max, count);
                }else   count=0;
            }
        }
        return max*2;
    }
}
