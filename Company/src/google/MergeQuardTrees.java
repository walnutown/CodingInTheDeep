package google;

import java.util.ArrayList;

public class MergeQuardTrees {
   /*
    * A quad tree is used to represent a black/white image. If you are provided with two such image
    * representations, write a function to create a third tree that represents the merged image.
    * (Black overrides white; mixed overrides white/black)
    */

   // http://en.wikipedia.org/wiki/Quadtree

   class QTreeNode {
      int val;  // 0 for white, 1 for black, 2 for grey
      ArrayList<QTreeNode> children;

      public QTreeNode(int val) {
         this.val = val;
         children = new ArrayList<QTreeNode>();
      }
      
      public QTreeNode clone(){
         QTreeNode ret = new QTreeNode(this.val);
         if (this.children.size()>0){
            for (QTreeNode child : children)
               ret.children.add(child.clone());
         }
         return ret;
      }
   }

   public QTreeNode merge(QTreeNode q1, QTreeNode q2) {
      if (q1 == null && q2 == null)
         return null;
      if (q1 == null || q2 == null)
         return q1==null? q2.clone(): q1.clone();
      if (q1.val==2 || q2.val==2){  // one grey will result in grey
         QTreeNode ret = new QTreeNode(2);
         for (int i=0; i<4; i++)
            ret.children.add(merge(q1.children.get(i), q2.children.get(i)));
         return ret;
      }
      // only left black or white
      if (q1.val==0 && q2.val==0)   // both white, remain white
         return new QTreeNode(0);
      if (q1.val==1 && q2.val==1)
         return new QTreeNode(1);   // both black, remain black
      return q1.val==1? q1.clone() : q2.clone();    // one black, one white, black overwrites the white 
   }
}
