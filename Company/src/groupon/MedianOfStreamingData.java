package groupon;

import lib.TreeNode;

public class MedianOfStreamingData {

   /**
    * Given a data stream, find the median of the data using online algorithm
    * 
    * Note:
    * There're no duplicates in the stream
    */
 
   /*
    * Use a binary search tree to store the data, and a variable to store the median node
    * Every time, when a new data is inputed, insert the data into the BST, and then adjust the
    * median node according to the new node's value
    * <1> insert O(lgn)
    * <2> adjust O(lgn) -- find previous node or next node
    * <3> get median -- O(1)
    */
   // this method is difficult implement
   // see the CTCI - heard -- GetMedianOfStreamingData
   
}
