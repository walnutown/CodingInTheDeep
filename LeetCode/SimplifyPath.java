/*
	Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"

	Corner Cases:
	Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".
*/

// Use a stack to store the final parth partition
// time: O(n); space: O(n)
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