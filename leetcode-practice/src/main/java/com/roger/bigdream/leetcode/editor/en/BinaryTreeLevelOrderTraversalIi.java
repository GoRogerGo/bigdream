package com.roger.bigdream.leetcode.editor.en;

//Given the root of a binary tree, return the bottom-up level order traversal of
// its nodes' values. (i.e., from left to right, level by level from leaf to root)
//. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[15,7],[9,20],[3]]
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
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Breadth-first Search 
// 👍 2178 👎 246


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();

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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            goodSolution(root, list);
            return list;
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param root
         * @param list
         */
        private void goodSolution(TreeNode root, List<List<Integer>> list) {
            if (root != null) {
                List<TreeNode> nodes = new ArrayList<>();
                nodes.add(root);
                helper(nodes, list);
            }
        }

        private void helper(List<TreeNode> nodes, List<List<Integer>> list) {
            if (nodes.size() == 0) return;
            List<Integer> subList = new ArrayList<>();
            List<TreeNode> newNodes = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode node = nodes.get(i);
                subList.add(node.val);
                if (node.left != null) newNodes.add(node.left);
                if (node.right != null) newNodes.add(node.right);
            }
            list.add(0, subList);
            helper(newNodes, list);
        }

        /**
         * Runtime:3 ms, faster than 7.37% of Java online submissions.
         *
         * @param root
         * @param list
         */
        private void badSolution(TreeNode root, List<List<Integer>> list) {
            if (root != null) {
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    list.add(0, new ArrayList<>());
                    int length = queue.size();
                    for (int i = 0; i < length; i++) {
                        TreeNode node = queue.pop();
                        list.get(0).add(node.val);
                        if (node.left != null) {
                            queue.add(node.left);
                        }
                        if (node.right != null) {
                            queue.add(node.right);
                        }
                    }
                }
            }
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