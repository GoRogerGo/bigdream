package com.roger.bigdream.leetcode.editor.en;
//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contains a sin
//gle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [7,2,4,3], l2 = [5,6,4]
//Output: [7,8,0,7]
// 
//
// Example 2: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [8,0,7]
// 
//
// Example 3: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
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
//
// 
// Follow up: Could you solve it without reversing the input lists? 
// Related Topics Linked List Math Stack 
// 👍 4293 👎 245

import java.util.Stack;

public class _445AddTwoNumbersIi {

    public static void main(String[] args) {
        Solution solution = new _445AddTwoNumbersIi().new Solution();
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode result = solution.addTwoNumbers(listNode1, listNode2);

        listNode1 = new ListNode(0);
        listNode2 = new ListNode(0);
//        result = solution.addTwoNumbers(listNode1, listNode2);

        listNode1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(listNode1, listNode2);
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
         * 解答成功: 执行耗时:2 ms,击败了97.54% 的Java用户 内存消耗:43 MB,击败了97.71% 的Java用
         * <p>
         * 2023年08月16日10:02:33
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ll1 = revertNode(l1);
            ListNode ll2 = revertNode(l2);
            ListNode tail = null;
            int carry = 0;
            while (ll1 != null || ll2 != null || carry > 0) {
                int sum = (ll1 != null ? ll1.val : 0) + (ll2 != null ? ll2.val : 0) + carry;
                ListNode newNode = new ListNode(sum % 10);
                carry = sum > 9 ? 1 : 0;
                newNode.next = tail;
                tail = newNode;
                ll1 = ll1 == null ? null : ll1.next;
                ll2 = ll2 == null ? null : ll2.next;
            }
            return tail;
        }

        private ListNode revertNode(ListNode node) {
            ListNode prev = null, curr = node;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        /**
         * 第二次编写 2023年03月03日14:43:10
         * 解答成功: 执行耗时:7 ms,击败了14.24% 的Java用户 内存消耗:42.9 MB,击败了19.77% 的Java用户
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers_useStack(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            Stack stack1 = parseFromListNode(l1);
            Stack stack2 = parseFromListNode(l2);
            int carry = 0;
            ListNode tail = null;
            while (!stack1.empty() || !stack2.empty() || carry > 0) {
                int val = ((stack1.empty()) ? 0 : (int) stack1.pop()) + ((stack2.empty()) ? 0 : (int) stack2.pop()) + carry;
                carry = val > 9 ? 1 : 0;
                ListNode newNode = new ListNode(val % 10);
                newNode.next = tail;
                tail = newNode;
            }
            return tail;
        }

        /**
         * 解答成功: 执行耗时:6 ms,击败了24.14% 的Java用户 内存消耗:42.5 MB,击败了51.35% 的Java用户
         * from huahua
         * 注意点：①相较于自己的写法，不需要再来一个stack做转换了，使用head一层层"脱"
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers_first(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            Stack stack1 = parseFromListNode(l1);
            Stack stack2 = parseFromListNode(l2);
            int carry = 0;
            ListNode head = null;
            while (!stack1.empty() || !stack2.empty() || carry > 0) {
                int val = (!stack1.empty() ? (int) stack1.pop() : 0) + (!stack2.empty() ? (int) stack2.pop() : 0) + carry;
                carry = val < 10 ? 0 : 1;
                ListNode node = new ListNode(val % 10);
                node.next = head;
                head = node;
            }
            return head;
        }

        /**
         * 解答成功:
         * 执行耗时:7 ms,击败了13.98% 的Java用户
         * 内存消耗:42.4 MB,击败了51.35% 的Java用户
         * <p>
         * 写作注意点：①使用stack，尤其是第二个stack来获取结果
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers_byMyself(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            Stack stack1 = parseFromListNode(l1);
            Stack stack2 = parseFromListNode(l2);
            Stack sumStack = new Stack();
            int carry = 0;
            ListNode dummyHead = new ListNode(0);
            ListNode listNode = dummyHead;
            while (!stack1.empty() || !stack2.empty() || carry > 0) {
                int val = (!stack1.empty() ? (int) stack1.pop() : 0) + (!stack2.empty() ? (int) stack2.pop() : 0) + carry;
                carry = val < 10 ? 0 : 1;
                sumStack.push(val % 10);
            }
            while (!sumStack.empty()) {
                listNode.next = new ListNode((int) sumStack.pop());
                listNode = listNode.next;
            }
            return dummyHead.next;
        }

        private Stack parseFromListNode(ListNode listNode) {
            Stack stack = new Stack();
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}