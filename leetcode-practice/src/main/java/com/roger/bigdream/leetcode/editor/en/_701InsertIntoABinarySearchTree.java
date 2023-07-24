package com.roger.bigdream.leetcode.editor.en;
//You are given the root node of a binary search tree (BST) and a value to inser
//t into the tree. Return the root node of the BST after the insertion. It is guar
//anteed that the new value does not exist in the original BST. 
//
// Notice that there may exist multiple valid ways for the insertion, as long as
// the tree remains a BST after insertion. You can return any of them. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3], val = 5
//Output: [4,2,7,1,3,5]
//Explanation: Another accepted tree is:
//
// 
//
// Example 2: 
//
// 
//Input: root = [40,20,60,10,30,50,70], val = 25
//Output: [40,20,60,10,30,50,70,null,null,25]
// 
//
// Example 3: 
//
// 
//Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//Output: [4,2,7,1,3,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree will be in the range [0, 104]. 
// -108 <= Node.val <= 108 
// All the values Node.val are unique. 
// -108 <= val <= 108 
// It's guaranteed that val does not exist in the original BST. 
// 
// Related Topics Tree Binary Search Tree Binary Tree 
// 👍 5171 👎 163

public class _701InsertIntoABinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _701InsertIntoABinarySearchTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 解答成功:
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:44.2 MB,击败了48.33% 的Java用户
         * <p>
         * 2023年07月24日18:33:37
         * 一次过
         *
         * @param root
         * @param val
         * @return
         */
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val, null, null);
            }
            TreeNode p = root;
            while (p != null) {
                if (p.val > val) {
                    // 去左子树
                    if (p.left == null) {
                        p.left = new TreeNode(val, null, null);
                        break;
                    }
                    p = p.left;
                } else {
                    // 去右子树
                    if (p.right == null) {
                        p.right = new TreeNode(val, null, null);
                        break;
                    }
                    p = p.right;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}