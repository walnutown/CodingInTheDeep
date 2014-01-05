// Accepted, each row has a stirngbuilder, and finally combine all rows
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

// from AnnieKim, one stringbuilder
public class Solution {
    public String convert(String s, int nRows) {
        if (nRows==1)   return s;
        StringBuilder sb = new StringBuilder();
        int inc = (nRows-1)*2, m=s.length();
        for (int i=0; i<nRows; i++){
            int j=0;
            while (true){
                if (i>0 && i<nRows-1 && j-i>=0 && j-i<m) sb.append(s.charAt(j-i));
                if (j+i < m)    sb.append(s.charAt(j+i));
                if (j+i >= m)   break;
                j += inc;
            }
        }
        return sb.toString();
    }
}