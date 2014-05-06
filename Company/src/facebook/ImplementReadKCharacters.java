package facebook;

public class ImplementReadKCharacters {
   
   /**
    * Given a function, read2014(), implement a method to read k characters 
    */
   // Similar to ImplementReadLine
   
   public String read2014(){
      return null;
   }
   
   static StringBuilder buffer;
   public String read(int k){
      if (buffer.length()==0){
         buffer.append(read2014());
         if (buffer.length()==0)
            return "";
      }
      StringBuilder res = new StringBuilder();
      if (k<buffer.length()){
         res.append(buffer.substring(0, k));
         buffer.delete(0, k);
         return res.toString();
      }else{
         res.append(buffer);
         int len = buffer.length();
         buffer.delete(0, len);
         return res.toString() + read(k-len);
      }
   }
}
