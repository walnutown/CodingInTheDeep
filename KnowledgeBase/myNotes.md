Notes of Algorithm and Data Structure
===============
##Binary Tree -- Total: 24
basics: **DFS**(inorder/preorder/postorder in recursive/iterative version), **BFS**
#### 1. tree traversal
* DFS (inorder, preorder, postorder in recursion) is easy, skipped
* DFS (inorder, preorder, postorder in iteration, save stack space; in **Morris**, sapce O(1))
  * BinaryTreeInOrderTraversal (Leetcode)
  * BinaryTreePreOrderTraversal (Leetcode)
  * BinaryTreePostOrderTraversal (Leetcode)
* BFS -- curr/next level node count
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
* Depth
  * MinimumDepthOfBinaryTree (Leetcode)
  * MaximumDepthOfBinaryTree (Leetcode)


##Array -- Total: 50
basics: **binary search (iterative version)**, **in place swap**, **traverse from both sides**
#### 1. Array manipulation
* Merge
  * MergeSortedArray (Leetcode)
* Intersection of two arrays
  * IntersectionOfTwoSortedArray (Company/amazon)
* Restruct
  * InterleavingArray (Company/microsoft)
  * InterleavingArray2 (Company/microsoft)
* Search
  * SearchInsertPosition (Leetcode)
  * BinarySearchClosest (CTCI)
  * SearchForaRange (Leetcode)
  * Search2DMatrix (Leetcode)
  * SearchInRotatedArray (Leetcode)
  * SearchInRotatedArray2 (Leetcode)
  * SearchInArrayWithEmptyStrings (CTCI)
* Delete
  * RemoveElement (Leetcode)
* Interval
  * MergeIntervals (Leetcode)
  * InsertInterval (Leetcode)
* Sort
  * SortColors (Leetcode)
  * RacerRater (Company/rocketfuel)
  * RankNumberInStream (CTCI)
  * InsertionSort (CTCI)
  * MergeSort (CTCI)
  * QuickSort (CTCI)
  * RadixSort (CTCI)

#### 2. find special element
* Median
  * MedianOfTwoSortedArray (Leetcode)
* Kth **order statistic**: sort, O(nlgn); heap, O(nlgk); quickSelect, O(n)
  * FindKthLargestInArray (Company/amazon)
* Missing number
  * FirstMissingPositive (Leetcode)
  * FindOneMissingInteger (Company/amazon)
  * FindTwoMissingIntegers (Company/amazon)
  * FindMissingIntegerUsingBitManipulation (CTCI)


#### 3. find special subarray/subsequence
* MaximumSubarray (Leetcode)
* LongestConsecutiveSubsequence (Leetcode)
* LongestIncreasingSubsequence (CTCI)
* LongestIncreasingSubsequence2 (CTCI)
* LongestIncreasingSubsequence3 (CTCI)
* GasStation (Leetcode)

#### 4. Duplicates
* Remove duplicates
  * RemoveDuplicatesFromSortedArray (Leetcode)
  * RemoveDuplicatesFromSortedArray2 (Leetcode)
* Find the one without duplicates
  * SingleNumber (Leetcode)

#### 5. Others
* Candy (Leetcode)
  
#### 6. Sum
* 2Sum (Leetcode)
* 3Sum (Leetcode)
* 3SumCloset (Leetcode)
* 4Sum (Leetcode)

#### 7. Stock
* BestTimeToBuyAndSellStock (Leetcode)
* BestTimeToBuyAndSellStock2 (Leetcode)
* BestTimeToBuyAndSellStock3 (Leetcode)

#### 8. Matrix / Board Game
two ways to mark visited cells: **matrix**; **encode coordinates**
* SetMatrixZero (Leetcode)
* SurroundedRegion (Leetcode)
* NQueens (Leetcode)
* NQueens2 (Leetcode)
* UniquePaths (Leetcode)
* UniquePaths2 (Leetcode)
* MinValueOnMinSumPath (Company/amazon)
* ValidSudoku (Leetcode)
* SudokuSolver (Leetcode)
* Lazer (Company/rocketfuel)

##String -- Total: 21
basics: **sliding window**; **DP**; **toCharArray()** to make the code more elegant, O(n) in Java to call System.arraycopy()
#### 1. Substring
* LongestSubstringWithoutRepeatingCharacters (Leetcode)
* MinimumWindowSubstring (Leetcode)
* SubstringWithConcatenationOfAllWords (Leetcode)
* DistinctSubsequence (Leetcode)
* LongestCommonPrefix (Leetcode)
* ImplementStrStr (Leetcode)

#### 2. Parse String
* MultiplyStrings (Leetcode)
* StringToInteger (Leetcode)
* RomanToInteger (Leetcode)
* IntegerToRoman (Leetcode)
* ValidNumber (Leetcode)

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
* FillBoardWithWords (Company/groupon)
* FindWordsInBoard (Company/amazon)

#### 5. Palindrome
* ValidPalindrome (Leetcode)
* PalindromePartitioning (Leetcode)
* PalindromePartitioning2 (Leetcode)
* LongestPalindromicSubstring (Leetcode)

#### 6. Anagram 
two ways to check anagrams: **sort chars in word**; **freq count**
* Anagrams (Leetcode)


## Math -- Total: 12
* Digit Operation
  * PalindromeNumber (Leetcode)
  * PlusOne (Leetcode)
  * ReverseInteger (Leetcode)
* Permutation:
  * Permutations (Leetcode)
  * Permutations2 (Leetcode)
  * PermutationSequence (Leetcode)
  * NextPermutation (Leetcode)
* Combination:
  * Combinations (Leetcode)
  * CombinationSum (Leetcode)
  * CombinationSum2 (Leetcode)
  * MinimumCoinChange (Company/amazon)
* Subset:
  * Subsets (Leetcode)
  * Subsets2 (Leetcode)
* Arithmetic
  * Pow(x,n) (Leetcode)
  * Sqrt(x) (Leetcode)
  * EvaluateReversedPolishNotation (Leetcode)
  * DivideTwoIntegers (Leetcode)
  


## LinkedList -- Total: 14
basics: **draw the list on paper** is the most helpful way to solve list problem; take care of **infinite loop**; 'start', 'end', 'mid', 'dum' to mark pivot node in list, 'p'/'q', 'prev'/'curr'/'next' for runner pointer.
* Cycle
  * LinkedListCycle (Leetcode)
  * LinkedListCycle2 (Leetcode)
* Delete
  * RemoveNthNodeFromEndOfList (Leetcode)
  * RemoveDuplicatesInList (CTCI)
  * RemoveNodeInList (CTCI)
* Merge
  * MergeTwoSortedList (Leetcode)
  * MergeKSortedList (Leetcode)
* Copy
  * CopyListWithRandomPointer (Leetcode)
* Restruct
  * ReorderList (Leetcode)
  * InsertionSortList (Leetcode)
  * ReverseLinkedList2 (Leetcode)
  * PartitionList (CTCI)
* Arithmetic
  * AddListNumber (CTCI) -- forward order
  * AddTwoNumbers (Leetcode) -- reverse order
* Others
  * LinkedListPalindrome (CTCI)

## Bit Manipulation -- Total: 2
* XOR
  * SingleNumber (Leetcode)
* Bit Count
  * SingleNumber2 (Leetcode)
* Reset bits
  * InsertBitRange (CTCI)
  * NumberSequence (CTCI)
  * BitConversion (CTCI)
  * SwapBits (CTCI)
  * DrawHorizontalLine (CTCI)

* ToBinaryString
  * DoubleToBinaryString (CTCI)
