package com.roger.bigdream.leetcode.editor.en;
//Given the head of a singly linked list where elements are sorted in ascending 
//order, convert it to a height-balanced binary search tree. 
//
// 
// Example 1: 
//
// 
//Input: head = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the 
//shown height balanced BST.
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in head is in the range [0, 2 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics Linked List Divide and Conquer Tree Binary Search Tree Binary 
//Tree 
// 👍 6990 👎 151

public class _109ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _109ConvertSortedListToBinarySearchTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
         * 内存消耗:44.7 MB,击败了25.13% 的Java用户
         *
         * 2023年07月24日17:05:40
         *
         * @param head
         * @return
         */
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);

            ListNode fast = head, slow = head, pre = null;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
            }
            pre.next = null;

            TreeNode treeNode = new TreeNode(slow.val);
            treeNode.left = sortedListToBST(head);
            treeNode.right = sortedListToBST(slow.next);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}