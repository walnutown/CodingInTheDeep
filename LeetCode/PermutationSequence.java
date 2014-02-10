/*
    The set [1,2,3,…,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order,
    We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.

    Note: Given n will be between 1 and 9 inclusive.
*/

// use nextPermutation, TLE
public class Solution {
    public String getPermutation(int n, int k) {
        char[] p = new char[n];
        for (int i=0; i<n; i++) p[i] = (char)(i+'1');
        int len=1;
        for (int i=1; i<=n; i++) len*=i;
        k = k%len==0 ? len:k%len;       // in case k is larger than the total number of sequence
        for (int i=2; i<=k; i++){
            nextPermutation(p);
        }
        return String.valueOf(p);
    }
    public void nextPermutation(char[] p){
        int l = p.length - 1;
        while (l > 0 && p[l - 1] > p[l])    l--;
        Arrays.sort(p, l, p.length);
        if (l == 0) return;
        int i = l;
        while (p[l-1] >= p[i] && i<p.length)    i++;
        char tmp = p[l-1];
        p[l-1] = p[i];
        p[i] = tmp;
    }
}

// from AnnieKim, calculate each digit one by one
public class Solution {
    public String getPermutation(int n, int k) {
      StringBuilder num = new StringBuilder(), res = new StringBuilder();
      int len=1;
      for (int i=1; i<=n; i++){
          num.append(i);
          len *= i;
      }
      k--;      // notice, IMPORTANT here
      while (n > 0){
          len /= n;
          int i = k/len;
          k %= len;
          res.append(num.charAt(i));
          num.deleteCharAt(i);
          n--;
      }
      return res.toString();
    }
}