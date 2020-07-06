//Given a linked list, remove the n-th node from the end of list and return its
//head. 
//
// Example: 
//
// 
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->
//5.
// 
//
// Note: 
//
// Given n will always be valid. 
//
// Follow up: 
//
// Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 3290 👎 228


package com.roger.bigdream.leetcode.editor.en;

class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        solution.removeNthFromEnd(l1, 2);
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
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:37.7 MB, less than 61.56% of Java online submissions.
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            // Advances first pointer so that the gap between first and second is n nodes apart
            for (int i = 1; i <= n + 1; i++) {
                first = first.next;
            }
            // Move first to the end, maintaining the gap
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
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

    /**
     * Runtime:1 ms, faster than 22.72% of Java online submissions.
     * Memory Usage:40.1 MB, less than 5.01% of Java online submissions.
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode myApproach(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);

        ListNode loopListNode = dummyHead;
        int length = 0;
        while (null != loopListNode.next) {
            length++;
            loopListNode = loopListNode.next;
        }

        int count = length - n;
        ListNode tail = dummyHead;
        while (count > 0) {
            tail = tail.next;
            count--;
        }
        tail.next = tail.next.next;

        return dummyHead.next;
    }
}