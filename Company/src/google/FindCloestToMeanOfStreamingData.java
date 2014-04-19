package google;

public class FindCloestToMeanOfStreamingData {
   /*
    * Find the closest number to the mean value of a streaming data. 
    * Streaming data here means that there's always new number added to the array
    */
   
   // Basic idea is to maintain a binary search tree, and hold the mean value
   // Every time, when a new number is added, we insert it into the binary search tree,
   // which takes O(lgn), then update the mean value using formula: 
   // newMean = (oldMean*size + newValue)/(size+1), and binarySearchClosest(newMean),  
   // which also takes O(lgn)
}
