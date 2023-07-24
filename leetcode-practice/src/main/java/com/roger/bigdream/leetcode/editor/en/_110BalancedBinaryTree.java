package com.roger.bigdream.leetcode.editor.en;
//Given a binary tree, determine if it is height-balanced. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 9458 👎 536

public class _110BalancedBinaryTree{

    public static void main(String[] args) {
        Solution solution = new _110BalancedBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}