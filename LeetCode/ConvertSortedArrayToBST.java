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
    
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (num == null || num.length == 0){
           return null;
       }
       
       if (num.length == 1){
           return new TreeNode(num[0]);
       }
       
       int head = 0;
       int tail = num.length -1;
       
       return convert(head, tail, num);
       
        
    }
    
    public TreeNode convert(int head, int tail, int[] num){
        if (head == tail){
            return new TreeNode(num[head]);
        }
        int mid = (head + tail)/2;
        TreeNode tn = new TreeNode(num[mid]);
        if (head != mid  ){
            tn.left = convert(head, mid-1, num);
        }
        if (tail != mid  ){ 
            tn.right = convert(mid+1,tail, num);   
        }
        return tn;
    }
}


// Accepted 
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return builder(num, 0, num.length-1);
    }
    
    public TreeNode builder(int[] num, int start, int end){
        if (start > end)    return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = builder(num, start, mid-1);
        root.right = builder(num, mid+1, end);
        return root;
    }
}