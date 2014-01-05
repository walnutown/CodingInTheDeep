// notice the case "/..."
// Accepted, with stack, from Sophie
public class Solution {
    public String simplifyPath(String path) {
        if (path==null || path.length()==0)	return "";
		String[] splits = path.split("/");
		Stack<String> st = new Stack<String>();
		for (String split : splits){
			if (split.equals("..")){
				if (!st.isEmpty())	st.pop();
			}
			else if (!split.equals(".") && split.length()>0)	st.push(split); // split.length()>0 is for the case "/aa//b"
		}
		if (st.isEmpty())	return "/";
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty())	sb.insert(0, "/" + st.pop());
		return sb.toString();
    }
}

// Accepted, without stack, just use pointer to the previous valid string
public class Solution {
    public String simplifyPath(String path) {
        if (path==null || path.length()==0)	return "";
		String[] splits = path.split("/");
		int last=0;
		for (String split : splits){
			if (split.equals("..")){
				if (last>0)	last--;
			}
			else if (!split.equals(".") && split.length()>0)	splits[last++]=split; // split.length()>0 is for the case "/aa//b"
		}
		if (last==0)	return "/";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<last; i++)	sb.append("/" + splits[i]);
		return sb.toString();
    }
}