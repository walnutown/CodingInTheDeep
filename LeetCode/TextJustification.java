// Accepted
public static ArrayList<String> fullJustify(String[] words, int L) {
    ArrayList<String> res = new ArrayList<String>();
    if (words==null || words.length==0) return res;
    StringBuilder line = new StringBuilder();
    int i=0;
    while (i < words.length){
        if (line.length()==0){
            line.append(words[i++]);
        }
        else if (line.length()+1+words[i].length() <= L){
            line.append(" ");
            line.append(words[i++]);
        }else{
            adjustSpace(line, L);
            res.add(line.toString());
            line = new StringBuilder();
        }
    }
    while (line.length()<L)   line.append(" ");
    res.add(line.toString());
    return res;
}
public static void adjustSpace(StringBuilder line, int L){
    ArrayList<Integer> spaces = new ArrayList<Integer>();
    for (int i=0; i<line.length(); i++){
        if (line.charAt(i)==' ')    spaces.add(i);
    }
    if (spaces.size()==0) spaces.add(line.length());
    int extras = L - line.length();
    for (int i=0; i<spaces.size(); i++){            
       int k =  spaces.get(i)+i*(extras/spaces.size());   // notice here that the original space index has changed
       for (int j=0; j<extras/spaces.size(); j++)  line.insert(k, " ");
    }
    for (int i=0, j=extras%spaces.size(); i<spaces.size() && j>0; i++, j--){ 
       int k = spaces.get(i) + i;
       line.insert(k, " ");
    }
}

