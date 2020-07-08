//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists. 
//
// Example: 
//
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List 
// 👍 4245 👎 592


package com.roger.bigdream.leetcode.editor.en;

class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode result = solution.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4, null))), new ListNode(1, new ListNode(3, new ListNode(4, null))));
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

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (null == l1 && null == l2) return null;
            ListNode remainder = mergeTwoLists0(l1, l2);
            tail.next = remainder;
            return dummyHead.next;
        }

        /**
         * Runtime:2 ms, faster than 27.38% of Java online submissions.
         * Memory Usage:40.2 MB, less than 12.79% of Java online submissions.
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
            if (null != l1 && null == l2) {
                return l1;
            }
            if (null == l1 && null != l2) {
                return l2;
            }
            if (l1.val <= l2.val) {
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                return mergeTwoLists0(l1.next, l2);
            } else {
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                return mergeTwoLists0(l1, l2.next);
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

    /**
     * Runtime:1 ms, faster than 27.38% of Java online submissions.
     * Memory Usage:40.1 MB, less than 14.67% of Java online submissions.
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode iteratorWay(ListNode l1, ListNode l2) {
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

    /**
     * Runtime:1 ms, faster than 27.38% of Java online submissions.
     * Memory Usage:40.1 MB, less than 15.62% of Java online submissions.
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode recursiveWay(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) return null == l1 ? l2 : l1;
        if (l1.val <= l2.val) {
            l1.next = recursiveWay(l1.next, l2);
            return l1;
        } else {
            l2.next = recursiveWay(l1, l2.next);
            return l2;
        }
    }
}