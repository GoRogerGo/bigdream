package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related Topics
// Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 13944 👎 318

public class _101SymmetricTree {

    public static void main(String[] args) {
        Solution solution = new _101SymmetricTree().new Solution();

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
         * 内存消耗:40.8 MB,击败了46.01% 的Java用户
         * <p>
         * 2023年07月25日14:57:55
         *
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            if (null == root) return true;
            return isSymmetric0(root.left, root.right);
        }

        private boolean isSymmetric0(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return isSymmetric0(left.left, right.right) && isSymmetric0(left.right, right.left);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}