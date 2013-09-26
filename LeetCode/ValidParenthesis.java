// miss two cases, '((', '[])'
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len == 0){
            return true;
        }
        if (len == 1){
            return false;
        }
        
        Stack<Character> st = new Stack<Character>();
        for (int i = 0 ; i< len ; i++){
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{'){
                st.push(curr);
            }
            else{
                if (st.empty()){
                    return false;
                }
                if (curr == ')'){
                    if (st.peek() != '('){
                        return false;
                    }
                }
                else if (curr == ']'){
                    if (st.peek() != '['){
                        return false;
                    }
                }
                else if (curr == '}'){
                    if (st.peek() != '{'){
                        return false;
                    }
                }
                st.pop();
            }
        }
        
        if (!st.empty()){
            return false;
        }
        
        return true;    
    }
}



// #2 trial
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
            return true;
        
        Stack<Character> st = new Stack<Character>();
        for (int i = 0 ; i < s.length(); i++){
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{')
                st.push(curr);
            else{
                if (st.size() == 0)
                    return false;
                if (curr == ')' && st.peek() == '(' || curr == ']' && st.peek() == '[' || curr == '}' && st.peek() == '{')
                    st.pop();
                else
                    return false;
            }
        }
        if (st.size() > 0)
            return false;
        return true;
    }
}