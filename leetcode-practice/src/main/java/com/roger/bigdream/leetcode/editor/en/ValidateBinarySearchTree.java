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
// Related Topics Tree Depth-first Search Recursion 
// 👍 6137 👎 696


import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();

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
        public boolean isValidBST(TreeNode root) {
//            return validate(root, null, null);
            return inOrder(root);
        }

        /**
         * Runtime:1 ms, faster than 26.23% of Java online submissions.
         *
         * @param root
         * @return
         */
        private boolean inOrder(TreeNode root) {
            if (root == null) return true;
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param root
         * @param left
         * @param right
         * @return
         */
        private boolean validate(TreeNode root, TreeNode left, TreeNode right) {
            if (root == null) return true;
            if (left != null && root.val <= left.val || right != null && root.val >= right.val) return false;
            // 右子树节点的下限是根节点，上限不动；左子树节点的上限是根节点，下限不动；
            return validate(root.right, root, right) && validate(root.left, left, root);
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