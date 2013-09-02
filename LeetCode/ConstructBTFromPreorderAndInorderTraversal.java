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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = preorder.length;
        int len2 = inorder.length;
        if (len1 != len2){
            return null;
        }
        if (len1 == 0){
            return null;
        }
        
        map = new HashMap<Integer, Integer>();
        initMap(inorder);
        return build(preorder, 0 ,len1-1, inorder, 0, len2-1);
        
    }
    
    public TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if (iStart > iEnd){
            return null;
        }
        
        int val = preorder[pStart];
        TreeNode curr = new TreeNode(val);
        int currIndex = 0; 
        while (inorder[currIndex] != val){
            currIndex++;
        }
        //int currIndex = map.get(val);  // if use map here, runtime error, not know why... - -||
        int newpEnd = currIndex - iStart + pStart; // get the end of preorder array -- index < currIndex is left subtree
        curr.left = build(preorder, pStart+1, newpEnd, inorder, iStart, currIndex-1);
        curr.right = build(preorder, newpEnd+1, pEnd, inorder, currIndex+1, iEnd);
        return curr;
    }
    // init inorder array into map(val, index)
    public void initMap(int[] inorder){
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
    }
}