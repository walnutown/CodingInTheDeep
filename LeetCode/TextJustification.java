/*
    Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left justified and no extra space is inserted between words.

    For example,
    words: ["This", "is", "an", "example", "of", "text", "justification."]
    L: 16.

    Return the formatted lines as:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Note: Each word is guaranteed not to exceed L in length.

*/

// Twitter Onsite
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
        if (line.charAt(i)==' ')    spaces.add(i);  // get the index of each space
    }
    // add extra spaces to the line
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

