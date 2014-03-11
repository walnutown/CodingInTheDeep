package zillow;

public class FirstUniqueCharInString {

   /*
    * Find the first unique characters in a string
    */
   static final char DEFAULT = '\u0000';
   public static void main(String[] args) {
      String s = "applegooglefacebook";
      System.out.println(findFirstUniqueChar(s));
      System.out.println(findFirstUniqueChar2(s));
   }
   // two pass
   // first traverse to get the count array
   // second traverse to get the first character with value 1 in count array
   public static char findFirstUniqueChar(String s){
      if (s==null || s.length()==0)
         return DEFAULT;
      int[] count = new int[256]; // size of the array depends on character set
      for (int i=0; i<s.length(); i++)
         count[s.charAt(i)]++;
      for (int i=0; i<s.length(); i++){
         if (count[s.charAt(i)]==1)
            return s.charAt(i);
      }
      return DEFAULT;
   } 
   
   // if the input string is very long compared to the length of character set (e.g. DNA sequence)
   // we can optimize the second traverse by using a wrapper class
   public static char findFirstUniqueChar2(String s){
      if (s==null || s.length()==0)
         return DEFAULT;
      Cha[] count = new Cha[256];
      for (int i=0; i<s.length(); i++){
         char key = s.charAt(i);
         if (count[key]==null)
            count[key] = new Cha(i);
         else
            count[key].count++;
      }
      Cha min = new Cha(Integer.MAX_VALUE);
      for (int i=0; i<count.length; i++){
         if (count[i]!=null && count[i].count==1 && count[i].index < min.index)
            min = count[i];
      }
      return s.charAt(min.index);
   }
   
   public static class Cha{
      int count;
      int index;
      public Cha(int index){
         this.index = index;
         count = 1;
      }
   }
}
