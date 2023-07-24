package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary tree, determine if it is a valid binary search tree
// (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 15243 👎 1243

public class _98ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _98ValidateBinarySearchTree().new Solution();

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
         * 内存消耗:44.2 MB,击败了37.12% 的Java用户
         * <p>
         * 2023年07月24日16:32:20
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            return validate(root, null, null);
        }

        private boolean validate(TreeNode root, TreeNode left, TreeNode right) {
            if (root == null) return true;
            if (null != left && root.val <= left.val || null != right && root.val >= right.val)
                return false;
            // 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
            // 右子树节点的下限是根节点，上限不动；左子树节点的上限是根节点，下限不动；
            return validate(root.right, root, right) && validate(root.left, left, root);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}