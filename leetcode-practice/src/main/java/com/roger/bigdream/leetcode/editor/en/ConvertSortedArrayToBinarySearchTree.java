package com.roger.bigdream.leetcode.editor.en;

//Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// A height-balanced binary tree is a binary tree in which the depth of the two 
//subtrees of every node never differs by more than one. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in a strictly increasing order. 
// 
// Related Topics Tree Depth-first Search 
// 👍 3943 👎 282


public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            return buildBST(nums, 0, nums.length - 1);
        }

/*        private TreeNode buildBST(int[] nums, int l, int r) {
            if (l > r) return null;
            int m = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[m]);
            root.left = buildBST(nums, l, m - 1);
            root.right = buildBST(nums, m + 1, r);
            return root;
        }*/

        private TreeNode buildBST(int[] nums, int l, int r) {
            if (l > r) return null;
            int mid = l + (r - l) / 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = buildBST(nums, l, mid - 1);
            treeNode.right = buildBST(nums, mid + 1, r);
            return treeNode;
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