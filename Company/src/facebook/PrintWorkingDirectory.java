package facebook;

import java.util.Stack;

import org.junit.Test;

public class PrintWorkingDirectory {
   /*
    * Given a current absolute path, e.g., "/usr/bin/mail", and a relative one, e.g,
    * "../../../etc/xyz/../abc" return the absolute path created from the combination of the first
    * two paths. In the example strings, the answer should be "/etc/abc".
    */

   public String pwd(String absolutePath, String relativePath) {
      String path = absolutePath + "/" + relativePath;
      String[] s = path.split("/");
      Stack<String> st = new Stack<String>();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length; i++) {
         if (s[i].isEmpty() || s[i].equals("."))
            continue;
         else if (s[i].equals("..")){
            if (st.isEmpty())
               throw new NullPointerException("Invalid Path");
            else
               st.pop();
         }else
            st.push(s[i]);
      }
      while (!st.isEmpty())
         sb.insert(0, "/" + st.pop());
      return sb.toString();
   }
   
   @Test
   public void test(){
      String a = "/usr/bin/mail", b = "../../../etc/xyz/../abc";
      System.out.println(pwd(a,b));
   }

}
