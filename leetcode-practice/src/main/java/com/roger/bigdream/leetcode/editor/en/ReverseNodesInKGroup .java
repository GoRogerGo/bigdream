//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics Linked List 
// 👍 2210 👎 358


package com.roger.bigdream.leetcode.editor.en;

import java.util.Stack;

class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode _2Res = solution.reverseKGroup(listNode2, 2);

        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode _3Res = solution.reverseKGroup(listNode3, 3);

        ListNode listNode1 = new ListNode(1, new ListNode(2));
        ListNode _1Res = solution.reverseKGroup(listNode1, 2);
        System.out.println(_1Res);
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

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyHead = new ListNode(0, head);
            ListNode pre = dummyHead, start = head, end = head, next = head;
            while (null != next) {
                // 根据k找到end，注意链表是否结束
                for (int i = 1; i < k && null != end; i++) {
                    end = end.next;
                }
                // 如果链表的尾部被k整除，跳出while循环
                if (null == end) break;
                // 对翻转区进行翻转
                next = end.next;
                end.next = null;
                end = start;
                start = reverse(start);
                end.next = next;
                pre.next = start;
                // 重新指定pre，start，end
                pre = end;
                start = next;
                end = start;
            }

            return dummyHead.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null, curr = head, next = null;
            while (null != curr) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
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
     * Memory Limit Exceeded
     */
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;

    private ListNode myApproach(ListNode head, int k) {
        if (k == 1) return head;
        if (null != head) {
            reverseKGroupWithExtraSpace(head, k);
        }
        return dummyHead.next;
    }

    private void reverseKGroupWithExtraSpace(ListNode head, int k) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while (null != head) {
            stack.push(head.val);
            head = head.next;
            count++;
            if (count == k) {
                buildSwapKNodes(stack);
                break;
            }
            if (null == head && count < k) {
                Stack<Integer> stackAsc = new Stack<>();
                while (!stack.isEmpty()) {
                    stackAsc.push(stack.pop());
                }
                buildSwapKNodes(stackAsc);
                return;
            }
        }
        reverseKGroupWithExtraSpace(head, k);
    }

    private void buildSwapKNodes(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        tail.next = new ListNode(stack.pop());
        tail = tail.next;
        buildSwapKNodes(stack);
    }
}