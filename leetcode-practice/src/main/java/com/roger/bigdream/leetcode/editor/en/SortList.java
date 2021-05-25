package com.roger.bigdream.leetcode.editor.en;

//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
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
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics Linked List Sort 
// 👍 4278 👎 178


public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        solution.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
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
         * Runtime:6 ms, faster than 81.33% of Java online submissions.
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode second = slow.next;
            slow.next = null;

            return mergeSortList(sortList(head), sortList(second));
        }

        public ListNode mergeSortList(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (null != l1 && null != l2) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            if (null != l1) tail.next = l1;
            if (null != l2) tail.next = l2;
            return dummyHead.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
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