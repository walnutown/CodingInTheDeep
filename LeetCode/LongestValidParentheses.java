// misunderstand the question
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (s == null || s.length() <=1){
            return 0;
        }
        
        int max = 0;
        
        
        for (int i = 0; i < s.length(); i++){
            int index =i;
            int sum = 0;
            boolean done = false;
            boolean left = true;
            char curr = s.charAt(index);
            if (curr == '(' ){
                while (!done){
                    index++; 
                    if (index == s.length()){
                        done = true;
                        continue;
                    }
                    curr = s.charAt(index);
                    if (left && curr == '(' || !left && curr == ')'){
                        done = true;
                    }
                    else if (left && curr == ')'){
                        left = false;
                        sum += 2;
                        max = Math.max(max, sum);
                    }
                    else if (!left && curr == '('){
                        left = true;
                    }
                }
            }
        }
        
        return max;
    }
}

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


// trail #2, not verified
public class Solution {
    public int longestValidParentheses(String s) {
        // we use a var to count the number of valid pairs
        if (s == null || s.length() == 0)
            return 0;
        int lefts = 0, count = 0, max = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                lefts++;
            else{
                if (lefts > 0){
                    count++;
                    lefts--;
                }else{
                    max = Math.max(max, 2 * count);
                    count = 0;
                }
            }
        }
        return max;
    }
}

