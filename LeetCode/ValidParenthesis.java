/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
        
// Maintain a stack to store all characters that hasn't been matched yet.
// Each time, we check current char with top of the stack to find potential match
// Finally, all characters are matched, the stack should be empty.
// time: O(n); space: O(n)
public class Solution {
    public boolean isValid(String s) {
        if (s==null || s.length()==0)
            return false;
        Stack<Character> st = new Stack<Character>();
        int N = s.length();
        for (int i=0; i<N; i++){
            char ch = s.charAt(i);
            if (st.isEmpty())
                st.push(ch);
            else{
                if (isMatch(st.peek(), ch))
                    st.pop();
                else
                    st.push(ch);
            }
        }
        return st.isEmpty();
    }
    
    private boolean isMatch(char l, char r){
        return l=='[' && r==']' || l=='(' && r==')' || l=='{' && r=='}';
    }
}