package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
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
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? Related
// Topics Stack Tree Depth-First Search Binary Tree 
// 👍 6208 👎 178

import java.util.ArrayList;
import java.util.List;

public class _145BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _145BinaryTreePostorderTraversal().new Solution();

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
         * 内存消耗:40.8 MB,击败了73.55% 的Java用户
         * <p>
         * 2023年07月24日14:54:41
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorderTraversal0(root, result);
            return result;
        }

        private void postorderTraversal0(TreeNode root, List<Integer> result) {
            if (root == null) return;
            postorderTraversal0(root.left, result);
            postorderTraversal0(root.right, result);
            result.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}