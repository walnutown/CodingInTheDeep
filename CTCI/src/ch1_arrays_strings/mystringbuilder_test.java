package ch1_arrays_strings;

public class mystringbuilder_test {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      MyStringBuilder msb = new MyStringBuilder("abc");
      System.out.println(msb);
      msb.append("def");
      msb.insert(2, "123");
      System.out.println(msb);
   }

}
