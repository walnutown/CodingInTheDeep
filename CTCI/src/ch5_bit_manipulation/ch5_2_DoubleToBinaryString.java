package ch5_bit_manipulation;

public class ch5_2_DoubleToBinaryString {

   /**
    * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
    * print the binary representation. If the number cannot be represented accurately
    * in binary with at most 32 characters, print "ERROR"
    */
   public static void main(String[] args) {
      double d = 0.5;
      System.out.println(doubleToBinaryString(d));
   }
   // left shift 1 bit each time, and check
   public static String doubleToBinaryString(double d){
      if (d>=1 || d<=0)
         return "ERROR";
      StringBuilder sb = new StringBuilder();
      sb.append(".");
      while (d>0){
         if (sb.length()>=32)
            return "ERROR";
         double r = d*2;
         if (r>=1){
            sb.append("1");
            d = r-1;
         }else{
            sb.append("0");
            d = r;
         }
      }
      return sb.toString();
   }

}
