package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary tree, return the zigzag level order traversal of it
//s nodes' values. (i.e., from left to right, then right to left for the next leve
//l and alternate between). 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Breadth-First Search Binary Tree 
// 👍 9669 👎 250

import java.util.*;

public class _103BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new _103BinaryTreeZigzagLevelOrderTraversal().new Solution();

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
         * 执行耗时:1 ms,击败了89.04% 的Java用户
         * 内存消耗:41.7 MB,击败了22.51% 的Java用户
         * <p>
         * 2023年07月25日15:30:35
         *
         * @param root
         * @return
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new LinkedList<>(); //用的LinkedList
            if (root == null) return ret;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isOrderLeft = true;
            while (!queue.isEmpty()) {
                Deque<Integer> res = new LinkedList<>(); //用的LinkedList，接口是Deque
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeNode node = queue.poll();
                    if (isOrderLeft) {
                        res.offerLast(node.val); //黑科技了
                    } else {
                        res.offerFirst(node.val); //黑科技了
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ret.add(new LinkedList<>(res)); //注意写法
                isOrderLeft = !isOrderLeft; //灵魂之笔
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}