package com.roger.bigdream.leetcode.editor.en;
//Given the head of a singly linked list, reverse the list, and return the rever
//sed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
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
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both? 
// Related Topics Linked List Recursion 
// 👍 16715 👎 290

public class _206ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new _206ReverseLinkedList().new Solution();
        ListNode result = solution.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
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
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:41.9 MB,击败了78.75% 的Java用户
         * recursively
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode tail = null;
            return reverseList0(head, tail);
        }

        private ListNode reverseList0(ListNode head, ListNode tail) {
            if (head == null) return tail;
            ListNode curNode = new ListNode(head.val);
            curNode.next = tail;
            tail = curNode;
            return reverseList0(head.next, tail);
        }

        /**
         * iteratively
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.2 MB,击败了44.37% 的Java用户
         * 注意点：①写得不熟练。。。
         *
         * @param head
         * @return
         */
        public ListNode reverseList_iteratively(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode tail = null;
            while (head != null) {
                ListNode curNode = new ListNode(head.val);
                curNode.next = tail;
                tail = curNode;
                head = head.next;
            }
            return tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}