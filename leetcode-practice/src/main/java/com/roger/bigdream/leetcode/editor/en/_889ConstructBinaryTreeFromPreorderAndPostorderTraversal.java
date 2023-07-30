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

import java.util.Arrays;
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
            int N = preorder.length;
            if (N == 0) return null;
            TreeNode root = new TreeNode(preorder[0]);
            if (N == 1) return root;
            // 我们令左分支有L个节点。
            // 我们知道左分支的头节点为pre[1]，但它也出现在左分支的后序表示的最后。所以pre[1]=post[L-1]（因为结点的值具有唯一性），因此L=post.indexOf(pre[1])+1。
            int L = 0;
            for (int i = 0; i < N; ++i)
                if (postorder[i] == preorder[1])
                    L = i + 1;
            //前序遍历：(根结点) (前序遍历左分支) (前序遍历右分支)
            //后续遍历：(后序遍历左分支) (后序遍历右分支) (根结点)
            // 左分支由pre[1:L+1]和post[0:L]重新分支，而右分支将由pre[L+1:N]和post[L:N-1]重新分支。
            root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, L + 1),
                    Arrays.copyOfRange(postorder, 0, L));
            root.right = constructFromPrePost(Arrays.copyOfRange(preorder, L + 1, N),
                    Arrays.copyOfRange(postorder, L, N - 1));
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}