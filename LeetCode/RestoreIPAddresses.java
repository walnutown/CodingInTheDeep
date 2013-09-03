public class Solution {
    ArrayList<ArrayList<String>> resList;
    ArrayList<String> ipList;
    ArrayList<String> res;
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resList = new ArrayList<ArrayList<String>>();
        res = new ArrayList<String>();
        ipList = new ArrayList<String>();
        int len = s.length();
        if (len < 4){
            return ipList;
        }
        DFS(s, 0, 1);
        return ipList;
    }
    
    public void DFS(String s, int start, int depth){
        if (depth <= 4 && start >= s.length()){
            return;
        }
        if (depth == 4 && start < s.length()){
           if (isValid(s, start)){
                    resList.add(new ArrayList<String>(res));
                    printIP();
                }
           return;
        }
        
        for (int i = 1; i <= 3; i++){
            if (start + i <= s.length()){
                String curr = s.substring(start, start + i);
                res.add(curr);
                DFS(s, start+i, depth+1);
                res.remove(res.size()-1);
            }
        }
    }
    
    public boolean isValid(String s, int start){
        for (int i = 0; i < 3; i++){
            int curr = Integer.parseInt(res.get(i));
            if (curr > 255){
                return false;
            }
        }
        String last = s.substring(start, s.length());
        if (Integer.parseInt(last) > 255){
            return false;
        }
        
        return true; 
    }
    
    public void printIP(){
        for (int i = 0; i< resList.size(); i++){
            ArrayList<String> curr = resList.get(i);
            StringBuilder temp = new StringBuilder();
            for (int j =0; j < 4; j++){
                temp.append(curr.get(j));
                temp.append(".");
            }
            temp.deleteCharAt(temp.length()-1);
            ipList.add(temp.toString());
        }
    }
    
}

// works in both judge
public class Solution {
    ArrayList<String> ipList;
    ArrayList<String> res;
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ipList = new ArrayList<String>();
        res = new ArrayList<String>();
        int len = s.length();
        if (len < 4){
            return ipList;
        }
        
        DFS(s, 1);
        return ipList;
    }
    
    public void DFS(String s, int depth){
        if (depth == 4){
            if (isValid(s)){
                String resStr = "";
                for (int i = 0; i < res.size(); i++){
                    resStr += res.get(i) + ".";
                }
                resStr += s;
                ipList.add(resStr);
            }
            return;
        }
        // don't forget i <= s.length()
        for (int i = 1; i <= 3 && i <= s.length(); i++){
            String curr = s.substring(0, i);
            if (!isValid(curr)){
                return;   
            }   
            res.add(curr);
            DFS(s.substring(i), depth +1);
            res.remove(res.size()-1);
        }
    }
    
    public boolean isValid(String s){
        if (s.length() == 1 || s.length()>=1 && s.length()<=3 && !s.startsWith("0")){
            int num = Integer.parseInt(s);
            if (num <= 255){
                return true;
            }
        }
        return false;
    }
}