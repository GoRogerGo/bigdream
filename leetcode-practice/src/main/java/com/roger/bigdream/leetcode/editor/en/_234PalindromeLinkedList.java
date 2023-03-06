package com.roger.bigdream.leetcode.editor.en;
//Given the head of a singly linked list, return true if it is a palindrome or f
//alse otherwise. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 13298 👎 737

public class _234PalindromeLinkedList {

    public static void main(String[] args) {
        Solution solution = new _234PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println(solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(solution.isPalindrome(new ListNode(1, new ListNode(2))));
        System.out.println(solution.isPalindrome(new ListNode(1, new ListNode(1))));
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
         * 解答成功: 执行耗时:4 ms,击败了84.52% 的Java用户 内存消耗:59.1 MB,击败了42.36% 的Java用户
         * 2023年03月06日09:38:02
         * 注意点：①反转链表还是不熟悉 ②回文类的用快慢指针法，如果快指针不是null，slow要next再去比较。
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) slow = slow.next;
            slow = reverseList(slow);
            while (slow != null) {
                if (slow.val != head.val) return false;
                slow = slow.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}