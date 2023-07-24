package com.roger.bigdream.leetcode.editor.en;
//You are given the root of a binary search tree (BST), where the values of exac
//tly two nodes of the tree were swapped by mistake. Recover the tree without chan
//ging its structure. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
//es the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
//nd 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//Follow up: A solution using O(n) space is pretty straight-forward. Could you d
//evise a constant O(1) space solution? Related Topics Tree Depth-First Search Bin
//ary Search Tree Binary Tree 
// 👍 7249 👎 236

public class _99RecoverBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _99RecoverBinarySearchTree().new Solution();

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
        private TreeNode prev = null, first = null, sec = null;

        /**
         * 解答成功:
         * 执行耗时:2 ms,击败了100.00% 的Java用户
         * 内存消耗:43.4 MB,击败了65.70% 的Java用户
         * <p>
         * 2023年07月24日17:20:31
         * <p>
         * 不会，看别人的
         *
         * @param root
         */
        public void recoverTree(TreeNode root) {
            helper(root);
            swapNode(first, sec);
            return;
        }

        private void swapNode(TreeNode first, TreeNode sec) {
            int tmp = first.val;
            first.val = sec.val;
            sec.val = tmp;
        }

        private void helper(TreeNode root) {
            if (root == null) return;

            helper(root.left);

            if (prev != null && prev.val > root.val) {
                if (first == null)
                    first = prev;
                sec = root;
            }
            prev = root;

            helper(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}