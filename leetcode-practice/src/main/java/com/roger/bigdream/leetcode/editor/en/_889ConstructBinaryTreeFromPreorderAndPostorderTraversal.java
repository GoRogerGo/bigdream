package com.roger.bigdream.leetcode.editor.en;
//Given two integer arrays, preorder and postorder where preorder is the preorde
//r traversal of a binary tree of distinct values and postorder is the postorder t
//raversal of the same tree, reconstruct and return the binary tree. 
//
// If there exist multiple answers, you can return any of them. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [1], postorder = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// All the values of preorder are unique. 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// All the values of postorder are unique. 
// It is guaranteed that preorder and postorder are the preorder traversal and p
//ostorder traversal of the same binary tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 
// 👍 2566 👎 102

import java.util.HashMap;
import java.util.Map;

public class _889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _889ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();

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
        int postpreindex = 0;

        /**
         * 2023年07月24日15:57:11
         * 完全看别人的
         * 解答成功:
         * 执行耗时:1 ms,击败了92.11% 的Java用户
         * 内存消耗:43.1 MB,击败了75.99% 的Java用户
         *
         * @param preorder
         * @param postorder
         * @return
         */
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return helper(preorder, postorder, map, 0, postorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int[] postorder, Map<Integer, Integer> map, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[postpreindex++]);

            if (start == end) {
                return root;
            }

            int index = map.get(preorder[postpreindex]);

            root.left = helper(preorder, postorder, map, start, index);
            root.right = helper(preorder, postorder, map, index + 1, end - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}