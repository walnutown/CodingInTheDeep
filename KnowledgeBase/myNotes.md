Notes of Algorithm and Data Structure
===============
##Binary Tree
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
* Balanced binary tree
  * BalancedBinaryTree (Leetcode)
* Sum binary tree
  * IsSumTree (Company/amazon)
* Mirror binary tree
  * IsMirrorTree (Leetcode) 

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
* Path of maximum value in the tree
  * BinaryTreeMaximumPathSum (Leetcode)
  
##Total: 13
