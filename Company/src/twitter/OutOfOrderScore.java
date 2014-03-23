package twitter;

public class OutOfOrderScore {
   /*
    * Given an array of values, find the total "score", where the score of each element is defined
    * as the number of elements with a smaller value that occur before it in the array.
    * e.g.
    * values: 4 1 3 2 5
    * scores: 0 0 1 1 4
    * total score: 6
    */
   // This is similar to the CTCI-CountInversionsInArray. The total score is the number of
   // inversions in the array, an inversion is described as i<j && A[i]<A[j]. Traverse from the end
   // of the array, 5 has (4,5), (1,5), (3,5), (2,5) 4 inversions.
}
