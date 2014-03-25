package twitter;

public class CountBinaryTreesConstructedFromPreorderSequence {
   /*
    * Given a preorder sequence from a Binary Tree, how many unique trees can be created from this?
    * (They want a recurrence relation and start with the easy cases):
    * T(0) = 1
    * T(1) = 1
    * T(2) = 2
    * What is T(N) ?
    */

   // [1,2,3,4,5,6,7,8,9]
   // Take the pre-order sequence above as an example. The first element is used as root, then, we
   // cut the remaining array into 2 halves. One half is used to build left-subtree, another is used
   // to build the right-subtree. For an array of n elements, T(n) = T(1)*T(n-2) + T(2)*T(n-3) + ...
   // + T(n-2)*T(1) = Sum(T(i)*T(n-1-i)), i is in [1...n-2]
}
