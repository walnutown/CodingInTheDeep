/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

// stack, time: O(n); space: O(n)
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{')    
                st.push(ch);
            else if (ch == ']' || ch == ')' || ch == '}'){
                if (st.isEmpty())   return false;
                char left = st.pop();
                if ((ch == ']' && left != '[') || (ch == ')' && left != '(') || (ch == '}' && left != '{'))
                    return false;
            }else return false;
        }
        return st.isEmpty();            // don't forget to check st.isEmpty() here
    }
}