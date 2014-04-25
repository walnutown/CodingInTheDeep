/*
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...

    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.

    Note: The sequence of integers will be represented as a string.
*/

// Maintain a counter. Increment the counter if there's repeating characters,
// otherwise, reset the counter to 1.
// Each time, buuld the current string based on previous string
// time: O(n^2); space: O(n^2)
public class Solution {
    public String countAndSay(int n) {
        if (n==0)   return "";
        StringBuilder prev = new StringBuilder();
        prev.append(1);
        while (n>1){
            StringBuilder curr = new StringBuilder();
            int count = 1;
            for (int i=0; i<prev.length(); i++){
                if (i+1<prev.length() && prev.charAt(i)==prev.charAt(i+1))
                    count++;
                else{
                    curr.append(count);   
                    curr.append(prev.charAt(i));
                    count = 1;
                }
            }
            prev = curr;
            n--;
        }
        return prev.toString();
    }
}