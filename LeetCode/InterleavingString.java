// doesn'r work, too many caese to check
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // judge null
        int nullCount = 0;
        if (s1 == null){
            nullCount++;
        }
        if (s2 == null){
            nullCount++;
        }
        if (s3 == null){
            nullCount++;
        }
        
        if (nullCount < 3 && nullCount > 0){
            return false;
        }
        if (nullCount == 3){
            return true;
        }
        // judge length
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3){
            return false;
        }
        
        int i = 0;
        int j = 0;
        for (int k = 0; k < len3; k++){
            char curr = s3.charAt(k);
            
            // make sure no nullPointException
            if (i == len1){
                if (!s2.substring(j,len2).equals(s3.substring(k,len3))){
                    return false;
                }
                else{
                    return true;
                }
            }
            if (j == len2){
                if (!s1.substring(i,len1).equals(s3.substring(k,len3))){
                    return false;
                }
                else{
                    return true;
                }
            }
            
            
            if (s1.charAt(i) != curr && s2.charAt(j) != curr){
                return false;
            }
            else if (s1.charAt(i) == curr && s2.charAt(j) != curr){
                i++;
            }
            else if (s1.charAt(i) != curr && s2.charAt(j) == curr){
                j++;
            }
            // decide which string to take the char from
            else{
                int p = k + 2;
                while (p < len3){
                    String currStr = s3.substring(k, p);
                    if (!s1.substring(i, p).equals(currStr) && !s2.substring(j, p).equals(currStr)){
                        i++;
                        break;
                    }   
                    else if (s1.substring(i, p).equals(currStr) && !s2.substring(j, p).equals(currStr)){
                        i++;
                        break;
                    }  
                    else if (!s1.substring(i, p).equals(currStr) && s2.substring(j, p).equals(currStr)){
                        j++;
                        break;
                    }
                    
                    p++;
                }
            }
        }
        
        return true;
    }
}

// dp

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // judge null
        int nullCount = 0;
        if (s1 == null){
            nullCount++;
        }
        if (s2 == null){
            nullCount++;
        }
        if (s3 == null){
            nullCount++;
        }
        
        if (nullCount < 3 && nullCount > 0){
            return false;
        }
        if (nullCount == 3){
            return true;
        }
        // judge length
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if(len1 == 0 && len2 == 0 && len3 == 0){
            return true;
        }
        
        if (len1 + len2 != len3){
            return false;
        }
        
        boolean[][] match = new boolean[len1+1][len2+1];
        match[0][0] = true;
        for (int i = 1; i <= len1; i ++){
            if (s1.charAt(i-1) == s3.charAt(i-1)){
                match[i][0] = true;
            }
            else{
                break;
            }
        }
        
        for (int j = 1; j <= len2; j++){
            if (s2.charAt(j-1) == s3.charAt(j-1)){
                match[0][j] = true;
            }
            else{
                break;
            }
        }
        
        for (int i = 1; i <= len1; i++){
            char ch1 = s1.charAt(i-1);
            for (int j = 1; j <= len2; j++){
                char ch2 = s2.charAt(j-1);
                char ch3 = s3.charAt(i+j-1);
                if (ch1 == ch3){
                    match[i][j] = match[i-1][j];
                }
                if (ch2 == ch3){
                    match[i][j] = match[i][j-1] || match[i][j]; // or the result of previous if()
                }
            }
        }
        
        return match[len1][len2];
             
    }
}

// recursive, pass large judge
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()==0 && s2.length()==0 && s3.length()==0)
            return true;
        if(s3.length()!=s1.length()+s2.length()) 
            return false;
        if(s1.length()!=0 && s2.length()!=0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1) && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1)) {
            return isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1)) || 
                isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        }
        else if(s1.length()!=0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1)) {
            return isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1));
        }
        else if(s2.length()!=0 && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1)) {
            return isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        }
        else 
            return false;
    }
}