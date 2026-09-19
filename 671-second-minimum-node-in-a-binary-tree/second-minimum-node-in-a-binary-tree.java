/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long second = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        solve(root,root.val);
        if(second  == Long.MAX_VALUE){
            return -1;
        }
        return (int)second;
    }
    public void solve(TreeNode root , int min){
        if(root == null)return;

        if(root.val > min && root.val < second){
            second = root.val;
        }
        solve(root.left,min);
        solve(root.right,min);
    }
}