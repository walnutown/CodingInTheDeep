/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

// Add the characters according to the zigzag order
// Maintain StringBuilders for each row
// Maintain a flag to calculate the row that we want to insert the character
// Finally, we combine all the rows into a string
// time: O(n);
public class Solution {
    public String convert(String s, int nRows) {
        if (s==null || s.length()==0 || nRows<=0)   return "";
        if (nRows == 1) return s;       // should return here, otherwise error below
        ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i=0; i<nRows; i++) rows.add(new StringBuilder());
        int r = 0;
        boolean down = true;
        for (int i=0; i<s.length(); i++){
            rows.get(r).append(s.charAt(i));
            r = down ? r+1:r-1;
            if (r==nRows-1) down=false;
            if (r==0)   down=true;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows)  res.append(row);
        return res.toString();
    }
}

// Add the characters row by row
// time: O(n)
public class Solution {
    public String convert(String s, int nRows) {
        if (s==null || s.length()==0 || nRows==1)
            return s;
        int N = s.length(), sprint = 2*(nRows-1);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nRows; i++){
            int j=0;
            while (true){
                if (i>0 && i<nRows-1 && j-i>=0 && j-i<N )    sb.append(s.charAt(j-i));
                if (j+i<N)  sb.append(s.charAt(j+i));
                else break;
                j += sprint;
            }
        }
        return sb.toString();
    }
}