package com.roger.bigdream.leetcode.editor.en;

//You are given the head of a singly linked-list. The list can be represented as
//: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 104]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List 
// 👍 3127 👎 146


public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
//        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * Runtime:1 ms, faster than 99.80% of Java online submissions.
         *
         * @param head
         */
        public void reorderList(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode first = slow.next;
            ListNode reverseHead = null;
            while (first != null) {
                ListNode second = first.next;
                first.next = reverseHead;
                reverseHead = first;
                first = second;
            }
            slow.next = null;

            ListNode node = head;
            while (reverseHead != null) {
                ListNode front = node.next;
                ListNode end = reverseHead.next;
                node.next = reverseHead;
                reverseHead.next = front;
                node = front;
                reverseHead = end;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}