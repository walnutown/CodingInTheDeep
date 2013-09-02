/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = inorder.length;
        int len2 = postorder.length;
        if (len1 != len2){
            return null;
        }
        if (len1 == 0){
            return null;
        }
        
        return build(inorder, 0, len1-1, postorder, 0, len2-1);
    }
    
    public TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        if (iStart > iEnd || pStart > pEnd){
            return null;
        }
        int val = postorder[pEnd];
        TreeNode curr = new TreeNode(val);
        int currIndex = iEnd;
        while (inorder[currIndex] != val){
            currIndex--;
        }
        curr.left = build(inorder, iStart, currIndex-1, postorder, pStart, pStart+currIndex-iStart-1);
        curr.right = build(inorder, currIndex+1, iEnd, postorder, pStart+currIndex-iStart, pEnd-1);
        return curr;
    }
}