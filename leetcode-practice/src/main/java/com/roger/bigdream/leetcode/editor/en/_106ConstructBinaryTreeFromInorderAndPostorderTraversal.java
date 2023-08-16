package com.roger.bigdream.leetcode.editor.en;
//Given two integer arrays inorder and postorder where inorder is the inorder tr
//aversal of a binary tree and postorder is the postorder traversal of the same tr
//ee, construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 
// 👍 7433 👎 114

public class _106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        /**
         * 解答成功: 执行耗时:3 ms,击败了35.48% 的Java用户 内存消耗:42.7 MB,击败了98.54% 的Java用户
         * 2023年08月16日19:56:42
         * 直接抄答案的
         *
         * @param inorder
         * @param inStart
         * @param inEnd
         * @param postorder
         * @param postStart
         * @param postEnd
         * @return
         */
        private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            // Base case
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }

            // Find the root node from the last element of postorder traversal
            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);

            // Find the index of the root node in inorder traversal
            int rootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }

            // Recursively build the left and right subtrees
            int leftSize = rootIndex - inStart;
            int rightSize = inEnd - rootIndex;
            root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
            root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}