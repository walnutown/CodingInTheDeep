public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length==0)   return 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i=0; i<tokens.length; i++){
            String s = tokens[i];
            if (!isOperator(s))
                st.push(Integer.parseInt(s));
            else{
                int b = st.pop(), a = st.pop(), res = 0;
                if (s.equals("+"))      res = a+b;
                else if (s.equals("-"))     res = a-b;
                else if (s.equals("*"))     res = a*b;
                else    res = a/b;
                st.push(res);
            }
        }
        return st.pop();
    }
    
    public boolean isOperator(String s){
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
}