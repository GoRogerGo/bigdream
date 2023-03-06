package com.roger.bigdream.leetcode.editor.en;
//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 14952 👎 618

public class _19RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new _19RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 4);
        solution.removeNthFromEnd(new ListNode(1), 1);
        solution.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
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
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:40.7 MB,击败了30.40% 的Java用户
         * 感想：这道题有两种做法，two-pass和快慢指针。自己能想到的是two-pass，但第一遍程序有兼容不了的场景。看了花花的快慢指针法，百思不得其解，它是怎么work的：不是从链表尾部数吗，它怎么不需要遍历两次的呢？
         * 感想迭代：通过case的debug，明白了这样做的精髓了，它是将fast推到n的位置，再用prev跟随着fast走到底，那么prev的位移就是n！精妙！
         * 2023年03月06日08:48:28
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (null == head) return null;
            ListNode dummyHead = new ListNode(0, head);
            ListNode fast = head;
            while (n-- > 0) fast = fast.next;
            ListNode prev = dummyHead;
            while (fast != null) {
                fast = fast.next;
                prev = prev.next;
            }
            prev.next = prev.next.next;
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}