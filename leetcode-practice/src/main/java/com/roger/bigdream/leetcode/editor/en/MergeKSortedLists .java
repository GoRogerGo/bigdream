//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap 
// 👍 4714 👎 288


package com.roger.bigdream.leetcode.editor.en;

import java.util.Arrays;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode[] lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))),
                new ListNode(2, new ListNode(6, null))
        };
        ListNode result = solution.mergeKLists(lists);
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            mergeKLists0(lists, lists.length);
            return lists[0];
        }

        /**
         * Runtime:3 ms, faster than 85.24% of Java online submissions.
         * Memory Usage:45 MB, less than 6.41% of Java online submissions.
         *
         * @param lists
         * @param length
         */
        private void mergeKLists0(ListNode[] lists, int length) {
            if (length == 1) return;
            int left = 0;
            int right = length - 1;
            while (left < right) {
                lists[left] = merge2Lists(lists[left], lists[right]);
                left++;
                right--;
            }
            mergeKLists0(lists, (length + 1) / 2);
        }


        private ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (null == l1 || null == l2) return null == l1 ? l2 : l1;
            if (l1.val <= l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            } else {
                l2.next = merge2Lists(l1, l2.next);
                return l2;
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