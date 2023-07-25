package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary search tree, return a balanced binary search tree w
//ith the same node values. If there is more than one answer, return any of them. 
//
//
// A binary search tree is balanced if the depth of the two subtrees of every no
//de never differs by more than 1. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,null,3,null,4,null,null]
//Output: [2,1,3,null,null,null,4]
//Explanation: This is not the only correct answer, [3,1,4,null,2] is also corre
//ct.
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [2,1,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// 1 <= Node.val <= 105 
// 
// Related Topics Divide and Conquer Greedy Tree Depth-First Search Binary Search Tree Binary Tree
// 👍 2742 👎 67

import java.util.ArrayList;
import java.util.List;

public class _1382BalanceABinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _1382BalanceABinarySearchTree().new Solution();

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
         * 执行耗时:8 ms,击败了12.78% 的Java用户
         * 内存消耗:44.7 MB,击败了97.40% 的Java用户
         * <p>
         * 2023年07月24日18:13:20
         *
         * @param root
         * @return
         */
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            //中序遍历，即排序
            inOrder(root, list);
            //转到数组中，为递归构造BST做准备
            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            //将有序数组元素转成平衡二叉搜索树
            return buildBST(array, 0, array.length - 1);
        }

        private TreeNode buildBST(int[] array, int left, int right) {
            if (left > right) return null;
            int mid = left + (right - left) / 2;
            TreeNode treeNode = new TreeNode(array[mid]);
            treeNode.left = buildBST(array, left, mid - 1);
            treeNode.right = buildBST(array, mid + 1, right);
            return treeNode;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}