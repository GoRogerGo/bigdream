package com.roger.bigdream.leetcode.editor.en;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 24394 👎 4711

public class _2AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new _2AddTwoNumbers().new Solution();
        ListNode listNode1 = new ListNode(3, new ListNode(4, new ListNode(2)));
        ListNode listNode2 = new ListNode(4, new ListNode(6, new ListNode(5)));
        ListNode result = solution.addTwoNumbers(listNode1, listNode2);

        listNode1 = new ListNode(0);
        listNode2 = new ListNode(0);
        result = solution.addTwoNumbers(listNode1, listNode2);

        listNode1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        listNode2 = new ListNode(9);
        result = solution.addTwoNumbers(listNode1, listNode2);

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
         * 解答成功: 执行耗时:2 ms,击败了94.82% 的Java用户 内存消耗:42.2 MB,击败了85.23% 的Java用户
         * 写作注意点：①定义nextNode指向dummyHead ②forward > 0也是循环的条件
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            int forward = 0;
            ListNode nextNode = dummyHead;
            while (null != l1 || null != l2 || forward > 0) {
                int val = (null == l1 ? 0 : l1.val) + (null == l2 ? 0 : l2.val) + forward;
                forward = val < 10 ? 0 : 1;
                nextNode.next = new ListNode(val % 10);
                nextNode = nextNode.next;
                l1 = null == l1 ? null : l1.next;
                l2 = null == l2 ? null : l2.next;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}