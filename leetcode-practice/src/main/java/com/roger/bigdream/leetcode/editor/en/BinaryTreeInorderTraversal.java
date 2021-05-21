package com.roger.bigdream.leetcode.editor.en;

//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
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
//Output: [2,1]
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
//Follow up: Recursive solution is trivial, could you do it iteratively? Related
// Topics Hash Table Stack Tree 
// 👍 4755 👎 218


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

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
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            // 中序：左->本身->右
            inorderTraversal(root, list);
            return list;
        }

        private void inorderTraversal(TreeNode root, List<Integer> list) {
            if (null == root) return;
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
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