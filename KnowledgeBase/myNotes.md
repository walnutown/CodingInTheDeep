Notes of Algorithm and Data Structure
===============
##Binary Tree -- Total: 24
basics: **DFS**(inorder/preorder/postorder in recursive/iterative version), **BFS**
#### 1. tree traversal
* DFS (inorder, preorder, postorder in recursion) is easy, skipped
* DFS (inorder, preorder, postorder in iteration, save stack space; in Morris, sapce O(1))
  * BinaryTreeInOrderTraversal (Leetcode)
  * BinaryTreePreOrderTraversal (Leetcode)
  * BinaryTreePostOrderTraversal (Leetcode)
* BFS
  * BinaryTreeLevelOrderTraversal (Leetcode)
  * BinaryTreeLevelOrderTraversal2 (Leetcode)
  * BinaryTreeZigZagLevelOrderTraversal (Leetcode)

#### 2. special binary trees
* Binary Search Tree
  * ValidateBinarySearchTree (Leetcode)
  * RecoverBinarySearchTree (Leetcode)
  * CreateBSTWithMinimalHeight (CTCI) -- ConvertSortedArrayToBST (Leetcode)
  * FindInorderSuccessorOfBST (Leetcode)
* Balanced binary tree
  * BalancedBinaryTree (Leetcode)
* Sum binary tree
  * IsSumTree (Company/amazon)
* Mirror binary tree
  * IsMirrorTree (Leetcode)
  * CreateMirrorTree (Company/amazon)
* Symmetric Tree
  * SymmetricTree (Leetcode)
* Flatern Binary Tree
  * FlaternBinaryTreeToLInkedList (Leetcode)

#### 3. binary tree serialization and deserialization
*  Sol1:
    * use '#' to represent null node
    * preorder traversal to get the serialized array from tree
    * preorder traversal to de-serialize the array
*  Sol2:
    * use "#" to denote null node
    * use BFS level order traversal, each level has 2^(d-1) nodes
*  Sol3:
    * serialization: use two arrays, inorder and preorder traversal arrays of the tree
    * need the prerequisite: no duplicate vals in tree
*  Examples:
    * DeserializePreorderArrayOfBST (Company/amazon)
    * ConstructBTFromInorderAndPreorderTraversal (Leetcode)
    * ConstructBTFromInorderAndPostorderTraversal (Leetcode)
    


#### 4. find a specific path in the tree
* Root to leaf path
  * SumRootToLeafNumbers (Leetcode)
* Path between two nodes
  * DistanceOfTwoNodesInBST (Company/amazon)
  * FindPathsOfTargetSum (CTCI)
* Path of maximum value in the tree
  * BinaryTreeMaximumPathSum (Leetcode)
* Longest path between two leaves
  * DiameterOfBinaryTree (Company/amazon)
  


##Array -- Total: 23
basics: **binary search**, **in place swap**, **traverse from both sides**
#### 1. Array manipulation
* Merge two arrays
  * MergeSortedArray (Leetcode)
* Intersection of two arrays
  * IntersectionOfTwoSortedArray (Company/amazon)
* Interleave array
  * InterleavingArray (Company/microsoft)
  * InterleavingArray2 (Company/microsoft)
* Insertion
  * SearchInsertPosition (Leetcode)
* Deletion
  * RemoveElement (Leetcode)
* Interval
  * MergeIntervals (Leetcode)
  * InsertInterval (Leetcode)

#### 2. find special element
* Median
  * MedianOfTwoSortedArray (Leetcode)
* Kth order statistic: sort, O(nlgn); heap, O(nlgk); quickSelect, O(n)
  * FindKthLargestInArray (Company/amazon)
* Missing number
  * FirstMissingPositive (Leetcode)
  * FindMissingInteger (Company/amazon)


#### 3. find special subarray
* MaximumSubarray (Leetcode)
* LongestConsecutiveSubsequence (Leetcode)
  
#### 4. Duplicates
* Remove duplicates
  * RemoveDuplicatesFromSortedArray (Leetcode)
  * RemoveDuplicatesFromSortedArray2 (Leetcode)
* Find the one without duplicates
  * SingleNumber (Leetcode)
  
#### 5. Rotated Array
* binary search in roatated array
  * SearchInRotatedArray (Leetcode)
  * SearchInRotatedArray2 (Leetcode)
  
#### 6. Sum
* 2Sum (Leetcode)
* 3Sum (Leetcode)
* 3SumCloset (Leetcode)
* 4Sum (Leetcode)

#### 7. Stock
* BestTimeToBuyAndSellStock (Leetcode)
* BestTimeToBuyAndSellStock2 (Leetcode)
* BestTimeToBuyAndSellStock3 (Leetcode)

#### 8. Matrix
two ways to mark visited cells: **matrix**; **encode coordinates**
* SetMatrixZero (Leetcode)

##String -- Total: 21
basics: **sliding window**; **DP**; **toCharArray()** to make the code more elegant, O(n) in Java to call System.arraycopy()
#### 1. Substring
* LongestSubstringWithoutRepeatingCharacters (Leetcode)
* MinimumWindowSubstring (Leetcode)
* SubstringWithConcatenationOfAllWords (Leetcode)
* DistinctSubsequence (Leetcode)
* LongestCommonPrefix (Leetcode)
* ImplementStrStr (Leetcode)

#### 2. String representation of Integer
* MultiplyStrings (Leetcode)
* StringToInteger (Leetcode)

#### 3. String manipulation
* ScrambleString (Leetcode)
* InterleavingString (Leetcode)
 
#### 4. Character/word occurances
* CountAndSay (Leetcode)
* CompressString (CTCI)
* UniqueCharInString (CTCI)
* LengthOfLastWord (Leetcode)
* WordSearch (Leetcode)
* WordLadder (Leetcode)
* WordLadder2 (Leetcode)
* 

#### 5. Palindrome
* ValidPalindrome (Leetcode)
* PalindromePartitioning (Leetcode)
* PalindromePartitioning2 (Leetcode)
* LongestPalindromicSubstring (Leetcode)

## Math -- Total: 8
* Digit Operation
  * PalindromeNumber (Leetcode)
* Permutation:
  * Permutations (Leetcode)
  * Permutations2 (Leetcode)
  * PermutationSequence (Leetcode)
  * NextPermutation (Leetcode)
* Combination:
  * Combinations (Leetcode)
* Subset:
  * Subsets (Leetcode)
  * Subsets2 (Leetcode)
