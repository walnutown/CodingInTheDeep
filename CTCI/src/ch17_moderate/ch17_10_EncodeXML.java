package ch17_moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ch17_10_EncodeXML {

   /**
    * Since XML is very verbose, you are given a way of encoding it where each tag gets mapped to a
    * pre-defined integer value. The language grammar is as follows:
    * Element --> Tag Attributes END children END
    * Attribute --> Tag Value
    * END --> 0
    * Tag --> some predefined mapping to int
    * Value --> string value END
    * For example, the following XML might be converted into the compressed string below (assuming a
    * mapping of family->1, person->2, firstName->3, lastName->4, state->5).
    * <family lastNmae='McDowell' state="CA">
    *   <person firstName="Gayle">Some Message</person>
    * </family>
    * Becomes:
    * 1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0
    * Write code to print encoded version of an XML element (passed in Element and Attribute
    * objects).
    */
   public static void main(String[] args) {
      ArrayList<Attribute> att_child = new ArrayList<Attribute>();
      att_child.add(new Attribute("firstName","Gayle"));
      Element child = new Element("person", att_child, "Some Message");
      
      ArrayList<Attribute> att_root = new ArrayList<Attribute>();
      att_root.add(new Attribute("lastName", "McDowell"));
      att_root.add(new Attribute("state", "CA"));
      Element root = new Element("family", att_root, null);
      root.addChild(child);
      
      Map<String, String> map = new HashMap<String, String>();
      map.put("family", "1");
      map.put("person", "2");
      map.put("firstName", "3");
      map.put("lastName", "4");
      map.put("state", "5");
      System.out.println(encodeXML(root, map));

   }

   // recursion
   public static String encodeXML(Element root, Map<String, String> map) {
      StringBuilder res = new StringBuilder();
      encode(root, map, res);
      return res.toString();
   }
   
   public static void encode(Element e, Map<String, String> map, StringBuilder res){
      encodeString(map.get(e.tag), res);
      for (Attribute a : e.attributes){
         encodeString(map.get(a.tag),res);
         encodeString(a.value,res);
      }
      encodeString("0", res);
      if (e.value == null){
         for (Element child : e.children)
            encode(child, map, res);
      }else
         encodeString(e.value, res);
      encodeString("0", res);
   }
   // cna effectively avoid missing whitespace
   public static void encodeString(String str, StringBuilder sb){
      sb.append(str);
      sb.append(" ");
   }

   public static class Element {
      String tag;
      String value;
      ArrayList<Element> children;
      ArrayList<Attribute> attributes;

      public Element(String tag, ArrayList<Attribute> attributes, String value) {
         this.tag = tag;
         this.attributes = attributes;
         this.value = value;
         children = new ArrayList<Element>();
      }
      
      public void addChild(Element child){
         children.add(child);
      }

   }

   public static class Attribute {
      String tag;
      String value;

      public Attribute(String tag, String value) {
         this.tag = tag;
         this.value = value;
      }
   }

}
