// not pass large judge
public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0){
            return 1;
        }
        
        boolean neg = x < 0 && n%2 != 0 ? true: false;
        x = Math.abs(x);
        double res = 1;
        if (n > 0){
            res = x;
            for (int i = 1; i < n; i++){
                res *= x;
            }
        }
        if (n < 0){
            res = 1/x;
            for (int i = -1; i > n; i--){
                res /= x;
            }
        }
        
        return neg? -res : res;
        
    }
}


public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() functio
        
        if (n < 0){
            return 1.0 / power(x, -n);
        }      
        else if (n > 0){
            return  power(x, n);
        } 
        else{
            return 1.0;
        }
        
    }
    
    public double power(double x, int n){
        if (n == 0){
            return 1;
        }
        double v = power(x, n/2);
        if (n % 2 == 0){
            return v * v;
        }
        else{
            return v * v * x;
        }
    }
}