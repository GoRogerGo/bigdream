package com.roger.bigdream.leetcode.editor.en;
//Given an array of integers preorder, which represents the preorder traversal o
//f a BST (i.e., binary search tree), construct the tree and return its root. 
//
// It is guaranteed that there is always possible to find a binary search tree w
//ith the given requirements for the given test cases. 
//
// A binary search tree is a binary tree where for every node, any descendant of
// Node.left has a value strictly less than Node.val, and any descendant of Node.r
//ight has a value strictly greater than Node.val. 
//
// A preorder traversal of a binary tree displays the value of the node first, t
//hen traverses Node.left, then traverses Node.right. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
// 
//
// Example 2: 
//
// 
//Input: preorder = [1,3]
//Output: [1,null,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 1000 
// All the values of preorder are unique. 
// 
// Related Topics Array Stack Tree Binary Search Tree Monotonic Stack Binary Tre
//e 
// 👍 5501 👎 70

public class _1008ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _1008ConstructBinarySearchTreeFromPreorderTraversal().new Solution();

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
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder.length == 0) return null;
            return bstFromPreorder0(preorder, 0, preorder.length - 1);
        }

        /**
         * 解答成功:
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:40.9 MB,击败了33.16% 的Java用户
         * <p>
         * 2023年07月25日08:26:45
         *
         * @param preorder
         * @param l
         * @param r
         * @return
         */
        private TreeNode bstFromPreorder0(int[] preorder, int l, int r) {
            if (l > r) return null;
            int val = preorder[l];
            int index;//global index in order to find  wheere the actual break happened
            for (index = l; index <= r; index++) {
                if (preorder[index] > preorder[l])//finding the starting index of right subtree
                    break;
            }
            TreeNode node = new TreeNode(val);
            node.left = bstFromPreorder0(preorder, l + 1, index - 1);
            node.right = bstFromPreorder0(preorder, index, r);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}