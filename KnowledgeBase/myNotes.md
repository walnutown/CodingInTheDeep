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
* IsSubTree (CTCI)

#### 2. special binary trees
* Binary Search Tree
  * ValidateBinarySearchTree (Leetcode)
  * RecoverBinarySearchTree (Leetcode)
  * CreateBSTWithMinimalHeight (CTCI) -- ConvertSortedArrayToBST (Leetcode)
  * FindInorderSuccessorOfBST (Leetcode)
  * UniqueBinartSearchTree (Leetcode)
  * UniqueBinarySearchTree2 (Leetcode)
* Balanced binary tree
  * BalancedBinaryTree (Leetcode)
* Sum binary tree
  * IsSumTree (Company/amazon)
* Mirror binary tree
  * IsMirrorTree (Leetcode)
  * CreateMirrorTree (Company/amazon)
* Symmetric Tree
  * SymmetricTree (Leetcode)


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
    * Binary Tree to Linked List -- basically recursion, use global variable to connect the current node and previous node
      * FlaternBinaryTreeToLInkedList (Leetcode)
      * ConvertBinaryTreeToDoublyLinkedList (CTCI)


#### 4. find a specific path/node in the tree
* Notice two kinds of path sum:
  * the numebr of nodes on the path
  * the sum of valus of eahc node on the path

* Root to leaf path
  * SumRootToLeafNumbers (Leetcode)
* Path between two nodes
  * DistanceOfTwoNodesInBST (Company/amazon)
  * FindPathsOfTargetSum (CTCI)
  * FindPathsOfTargetSum2 (CTCI)
* Path of maximum value in the tree
  * BinaryTreeMaximumPathSum (Leetcode)
* Longest path between two leaves
  * DiameterOfBinaryTree (Company/amazon)
* Depth
  * MinimumDepthOfBinaryTree (Leetcode)
  * MaximumDepthOfBinaryTree (Leetcode)
* LCA
  *FindLowestCommonAncestor (CTCI)


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
  * SearchMatrix (CTCI)
  * SearchInRotatedArray (Leetcode)
  * SearchInRotatedArray2 (Leetcode)
  * SearchInArrayWithEmptyStrings (CTCI)
* Delete
  * RemoveElement (Leetcode)
* Interval
  * MergeIntervals (Leetcode)
  * InsertInterval (Leetcode)
* Partition
  * SortColors (Leetcode)
* Sort
  * RacerRater (Company/rocketfuel)
  * RankNumberInStream (CTCI)
  * InsertionSort (CTCI)
  * MergeSort (CTCI)
  * QuickSort (CTCI)
  * RadixSort (CTCI)
  * GetKthMagicNumber (CTCI)
  * ExternalSort (CTCI)
* Shuffle
  * ShuffleCards (CTCI)
* Inversion
  * CountInversionsInArray (CTCI)

#### 2. find special element
* Median
  * MedianOfTwoSortedArray (Leetcode)
  * GetMedianOfStreamingArray (CTCI)
* Kth **order statistic**: sort, O(nlgn); heap, O(nlgk); quickSelect, O(n)
  * FindKthLargestInArray (Company/amazon)
* Missing number
  * FirstMissingPositive (Leetcode)
  * FindOneMissingInteger (Company/amazon)
  * FindTwoMissingIntegers (Company/amazon)
  * FindMissingIntegerUsingBitManipulation (CTCI)
* MagicIndex (CTCI)


#### 3. find special subarray/subsequence
* MaximumSubarray (Leetcode)
* LongestConsecutiveSubsequence (Leetcode)
* LongestIncreasingSubsequence (CTCI)
* LongestIncreasingSubsequence2 (CTCI)
* LongestIncreasingSubsequence3 (CTCI)
* GasStation (Leetcode)
* ShortestUnsortedSubsequence (CTCI)

#### 4. Duplicates
* Remove duplicates
  * RemoveDuplicatesFromSortedArray (Leetcode)
  * RemoveDuplicatesFromSortedArray2 (Leetcode)
* Find the one without duplicates
  * SingleNumber (Leetcode)

#### 5. Others
* Candy (Leetcode)
* GetRandomSetFromArray (CTCI)
* FibonacciValue (Company/redfin)
* ClimbingStairs (Leetcode)
  
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
* SpiralMatrix (Leetcode)
* SpiralMatrix2 (Leetcode)

##String -- Total: 21
basics: **sliding window**; **DP**; **toCharArray()** to make the code more elegant, O(n) in Java to call System.arraycopy()
#### 1. Substring
* LongestSubstringWithoutRepeatingCharacters (Leetcode)
* MinimumWindowSubstring (Leetcode)
* SubstringWithConcatenationOfAllWords (Leetcode)
* DistinctSubsequence (Leetcode)
* LongestCommonPrefix (Leetcode)
* RotationString (CTCI)

#### 2. Parse/Encode String
* MultiplyStrings (Leetcode)
* StringToInteger (Leetcode)
* RomanToInteger (Leetcode)
* IntegerToRoman (Leetcode)
* ValidNumber (Leetcode)
* DescribeInteger (CTCI)
* EncodeXML (CTCI)
* WordBreak (Leetcode)
* WordBreak2 (Leetcode)
* FindMinWordBreak (CTCI)
* DescribeString (CTCI)

#### 3. String manipulation
* ScrambleString (Leetcode)
* InterleavingString (Leetcode)
* FizzBuz (Company/slideshare)
 
#### 4. Character/word occurances
* WordCount (CTCI)
* CountAndSay (Leetcode)
* CompressString (CTCI)
* UniqueCharInString (CTCI)
* LengthOfLastWord (Leetcode)
* WordSearch (Leetcode)
* WordLadder (Leetcode)
* WordLadder2 (Leetcode)
* FillBoardWithWords (Company/groupon)
* FindWordsInBoard (Company/amazon)
* MasterMind (CTCI)
* FindDistanceOfWordsInFile (CTCI)

#### 5. Palindrome
* ValidPalindrome (Leetcode)
* PalindromePartitioning (Leetcode)
* PalindromePartitioning2 (Leetcode)
* LongestPalindromicSubstring (Leetcode)

#### 6. Anagram 
two ways to check anagrams: **sort chars in word**; **freq count**
* Anagrams (Leetcode)
* AnagramOfPalindrome (Company/twitter)

#### 7. Parentheses
* GenerateParentheses (Leetcode)
* ValidParentheses (Leetcode)

#### 8. String Search
* ImplementStrStr() (Leetcode)
* LongestWord (CTCI)
* LocateSubStrings (CTCI)

## Math -- Total: 12
* Digit Operation
  * PalindromeNumber (Leetcode)
  * PlusOne (Leetcode)
  * ReverseInteger (Leetcode)
  * CountTwo (CTCI)
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
  * InfixNotationEvaluation (Company/twitter)
  * DivideTwoIntegers (Leetcode)
  * MultiplyTwoIntegers (CTCI)
  * SwapInPlace (CTCI)
  * FindMaxOfTwoNumbers (CTCI)
* Big Integer / Factorial:
  * TrailingZerosInFactorial (CTCI)
  * FactorialSum (Company/slideshare)
* Probability
  * RandomNumber (Company/amazon)
  * AntCollision (CTCI)
  * BasketballShot (CTCI)
* Geometry
  * LineIntersection (CTCI)
  * MaxPointsOnALine (Leetcode)
  * PythagoreanTriple (Company/amazon)
* Prime Number
  * IsPrimeNumber (CTCI)
  * PrimeNumberGenerator (Company/microsoft)
  * NextPrimeNumber (Company/microsoft)
* Equilibrium
  * EquilibriumIndexOfArray (Company/slideshare)
  * EquilibriumIndexOfMatrix (Company/twitter)
* Array
  * EvenParisInArray (Company/twitter)
  * ShortestAdditionChain (Company/twitter)

## LinkedList -- Total: 14
basics: **draw the list on paper** is the most helpful way to solve list problem; take care of **infinite loop**; 'start', 'end', 'mid', 'dum' to mark pivot node in list, 'p'/'q', 'prev'/'curr'/'next' for runner pointer.
* Cycle
  * LinkedListCycle (Leetcode)
  * LinkedListCycle2 (Leetcode)
* Delete
  * RemoveNthNodeFromEndOfList (Leetcode)
  * RemoveDuplicatesFromSortedList (Leetcode)
  * RemoveDuplicatesFromSortedList2 (Leetcode)
  * RemoveDuplicatesFromUnsortedList (CTCI)
  * RemoveNodeInList (CTCI)
* Merge
  * MergeTwoSortedList (Leetcode)
  * MergeKSortedList (Leetcode)
* Copy
  * CopyListWithRandomPointer (Leetcode)
* Restruct
  * ReorderList (Leetcode)
  * InsertionSortList (Leetcode)
  * ReverseLinkedList (CTCI)
  * ReverseLinkedList2 (Leetcode)
  * PartitionList (CTCI)
* Arithmetic
  * AddListNumber (CTCI) -- forward order
  * AddTwoNumbers (Leetcode) -- reverse order
* Others
  * LinkedListPalindrome (CTCI)
  * FindMedianOfSortedList (CTCI)

## Bit Manipulation -- Total: 8
* XOR
  * SingleNumber (Leetcode)
* Bit Count
  * SingleNumber2 (Leetcode)
  * MaxBinaryGap (Company/twitter)
* Reset bits
  * InsertBitRange (CTCI)
  * NumberSequence (CTCI)
  * BitConversion (CTCI)
  * SwapBits (CTCI)
  * DrawHorizontalLine (CTCI)
* ToBinaryString
  * DoubleToBinaryString (CTCI)

## Stack&Queue -- Total: 5
* ImplementThreeStacksInOneArray (CTCI)
* ImplementStackWithMinValue (CTCI)
* ImplementQueueUsingTwoStacks (CTCI)
* SortStack (CTCI)
* AnimalQueue (CTCI)


## Recursion -- Total: 1
* Cores
  * pass and return (think of the Chinese name 递归), so actually, each level will be visited twice.
  * Need a goal state to end recursion, otherwise may be trapped in infinite loop
* May throw StackOverFlowException if the recursion tree is deep. (stack and heap collides)
* return: how to return multiple arguments?
  * use gloable variable
  * use wrapper class
* debug: how to debug in recursion code? (due to recursive calls, it's difficult to track variable values using breakpoint. Breakpoint works well in sequence logic)
  * a good way is to print out states in each level.
  * try to use the case with a recursive tree of small depth
* TowerOfHanoi (CTCI)

## Dynamic Programming
* PaintHouse (Company/LinkedIn)
