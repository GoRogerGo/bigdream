package com.roger.bigdream.leetcode.editor.en;

//Given the root of a binary search tree (BST) with duplicates, return all the m
//ode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the i
//mplicit stack space incurred due to recursion does not count). Related Topics Tr
//ee 
// 👍 1387 👎 422


import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();

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

        int count = 0, maxFreq = 0;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();

        public int[] findMode(TreeNode root) {

            inorder(root);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;

        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param root
         */
        private void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);

            if (pre == null || pre.val == root.val) {
                count++;
            } else {
                count = 1;
            }
            pre = root;

            if (count == maxFreq) {
                list.add(root.val);
            } else if (count > maxFreq) {
                list.clear();
                list.add(root.val);
                maxFreq = count;
            }

            inorder(root.right);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}