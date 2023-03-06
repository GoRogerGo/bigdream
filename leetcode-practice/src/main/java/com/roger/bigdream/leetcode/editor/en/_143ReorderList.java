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
// Related Topics Linked List Two Pointers Stack Recursion 
// 👍 8276 👎 286

public class _143ReorderList {

    public static void main(String[] args) {
        Solution solution = new _143ReorderList().new Solution();
        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
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
         * 解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:45.9 MB,击败了19.79% 的Java用户
         * 注意点：①快慢指针的结束条件 ②慢指针的额外处理
         * 2023年03月06日22:57:56
         *
         * @param head
         */
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode h1 = head;
            ListNode h2 = reverseNode(slow.next);
            slow.next = null;
            while (h1 != null && h2 != null) {
                ListNode node1 = h1.next;
                ListNode node2 = h2.next;
                h1.next = h2;
                h2.next = node1;
                h1 = node1;
                h2 = node2;
            }
        }

        private ListNode reverseNode(ListNode head) {
            ListNode tail = null;
            ListNode next;
            while (head != null) {
                next = head.next;
                head.next = tail;
                tail = head;
                head = next;
            }
            return tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}