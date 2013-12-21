package ch1_arrays_strings;

public class ch1_5 {

   /**
    * Implement a method to perform basic string compression using the counts
    * of repeated characters. For example, the string "aabcccccaaa" would become
    * a2b1c5a3. if the "compressed" string would not become smaller than the original
    * string, return the original string
    */
   public static void main(String[] args) {
      String str = "aabcccccaaa";
      System.out.println(compressString(str));
      System.out.println(compressString("abcde"));
   }
   
   public static String compressString(String str){
      if (str == null || str.length() <= 1)
         return str;
      StringBuilder sb = new StringBuilder();
      int count = 1;
      sb.append(str.charAt(0));
      for (int i = 1; i < str.length(); i++){
         if (str.charAt(i) == str.charAt(i-1))
            count++;
         else{
            sb.append(count);
            sb.append(str.charAt(i));
            count = 1;
         }
      }
      sb.append(count);
      return sb.length() < str.length() ? sb.toString() : str;
   }
}
