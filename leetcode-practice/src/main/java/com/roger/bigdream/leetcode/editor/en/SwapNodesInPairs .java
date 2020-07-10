//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics Linked List 
// 👍 2252 👎 169


package com.roger.bigdream.leetcode.editor.en;

class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode result = solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
        System.out.println(result);
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
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:37.3 MB, less than 37.09% of Java online submissions.
         *
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if (null != head) {
                swapPair(head);
            }
            return dummyHead.next;
        }

        private void swapPair(ListNode head) {
            if (null == head.next) {
                tail.next = head;
                return;
            }
            ListNode nextPair = head.next.next;

            tail.next = head.next;
            tail.next.next = new ListNode(head.val);
            if (null != nextPair) {
                tail = tail.next.next;
                swapPair(nextPair);
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