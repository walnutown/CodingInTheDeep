package ch18_hard;

public class ch18_6_FIndKSmallestElementsInArray {

   /**
    * Describe an algorithm to find the smallest one million numbers in one billion numbers. Assume
    * that the computer memory can hold all one billion numbers.
    */
   /*
    * <1> sort, O(nlgn)
    * <2> maxHeap O(nlgm)
    * Traverse through the list, for each element, we insert it into the heap and delete the largest
    * element from the heap.
    * <3> quick select, average: O(n); worst: O(n^2)
    */
   // Similar to Company/amazon/FindTheKthSmallestInArray

}
