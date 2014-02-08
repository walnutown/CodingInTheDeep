Notes of Algorithm and Data Structure
===============
##Binary Tree -- Total: 24
basic algorithms: **DFS**(inorder/preorder/postorder in recursive/iterative version), **BFS**
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
  


##Array -- Total:
basic algorithms: **binary search**, **in place swap**
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

#### 2. find special number in the array
* Median
  * MedianOfTwoSortedArray (Leetcode)
* Kth order statistic: sort, O(nlgn); heap, O(nlgk); quickSelect, O(n)
  * FindKthLargestInArray (Company/amazon)
* Missing number
  * FirstMissingPositive (Leetcode)
  * FindMissingInteger (Company/amazon)


#### 3. find special subarray
* Subarray of max sum
  * MaximumSubarray (Leetcode)
  * 
  
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
  



