package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary search tree (BST) with duplicates, return all the m
//ode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the i
//mplicit stack space incurred due to recursion does not count). Related Topics Tr
//ee Depth-First Search Binary Search Tree Binary Tree 
// 👍 2962 👎 669

import java.util.ArrayList;
import java.util.List;

public class _501FindModeInBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _501FindModeInBinarySearchTree().new Solution();

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
    /**
     * 解答成功:
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.9 MB,击败了78.09% 的Java用户
     * <p>
     * 看以前的代码结果的，可以参考视频
     * https://leetcode.cn/problems/find-mode-in-binary-search-tree/solution/java-duo-jie-fa-qing-xi-yi-dong-by-ventu-6mae/
     * <p>
     * 2023年07月24日17:32:04
     */
    class Solution {

        int count = 0, maxFreq = 0;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            inOrder(root);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);

            if (pre == null || pre.val == root.val) {
                count++;
            } else {
                count = 1;
            }
            pre = root;

            if (count == maxFreq) {
                list.add(root.val);
            } else if (count > maxFreq) {
                list.clear();
                maxFreq = count;
                list.add(root.val);
            }

            inOrder(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}