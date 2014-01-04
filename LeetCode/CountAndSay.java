// Wrong understanding of the question, the starting number is 1, not n
public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0)
            return "";
        StringBuilder sb = new StringBuilder();
        
        sb.append(n);
        int count = 1;
        while (count < n){
            StringBuilder res = new StringBuilder();
            int num = 1;
            for (int i = 1; i < sb.length(); i++){
                if (sb.charAt(i) == sb.charAt(i-1))
                    num++;
                else{
                    res.append(num);
                    res.append(sb.charAt(i-1));
                    num = 1;
                }
            }
            res.append(num);
            res.append(sb.charAt(sb.length()-1));
            sb = new StringBuilder(res);
            count++;
        }
        return sb.toString();
    }
}


public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0)
            return "";
        StringBuilder sb = new StringBuilder();
        
        sb.append(1);     // just change one line here
        int count = 1;
        while (count < n){
            StringBuilder res = new StringBuilder();
            int num = 1;
            for (int i = 1; i < sb.length(); i++){
                if (sb.charAt(i) == sb.charAt(i-1))
                    num++;
                else{
                    res.append(num);
                    res.append(sb.charAt(i-1));
                    num = 1;
                }
            }
            res.append(num);
            res.append(sb.charAt(sb.length()-1));
            sb = new StringBuilder(res);
            count++;
        }
        return sb.toString();
    }
}

// Accepted
public class Solution {
    public String countAndSay(int n) {
        if (n<1)    return "";
        StringBuilder prev = new StringBuilder(); prev.append(1);
        for (int j=2; j<=n; j++){
            StringBuilder curr = new StringBuilder();
            int count = 1;
            for (int i=1; i<=prev.length(); i++){
                if (i < prev.length() && prev.charAt(i-1)==prev.charAt(i))   count++;
                else{
                    curr.append(count); curr.append(prev.charAt(i-1));
                    count=1;
                }
            }
            prev = curr;
        }
        return prev.toString();
    }
}