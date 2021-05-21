package com.roger.bigdream.leetcode.editor.en;

//Given the root of a binary tree, return the preorder traversal of its nodes' v
//alues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree 
// 👍 2316 👎 90


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();

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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            // 前序：本身->左->右
            preorderTraversal(root, list);
            return list;
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param root
         * @param list
         */
        void preorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
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