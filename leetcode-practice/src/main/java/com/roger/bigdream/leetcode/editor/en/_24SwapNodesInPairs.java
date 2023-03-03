package com.roger.bigdream.leetcode.editor.en;
//Given a linked list, swap every two adjacent nodes and return its head. You mu
//st solve the problem without modifying the values in the list's nodes (i.e., onl
//y nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Recursion 
// 👍 9130 👎 354

public class _24SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new _24SwapNodesInPairs().new Solution();
        solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
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
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:40.6 MB,击败了20.10% 的Java用
         * 第二次编写 还是不熟悉 2023年03月03日17:48:19
         * 注意点：①head借助dummyHead前移一位 ②第一个元素和第二个元素交换不熟练
         *
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummyHead = new ListNode(0, head);
            head = dummyHead;
            while (head.next != null && head.next.next != null) {
                ListNode first = head.next;
                ListNode second = head.next.next;
                first.next = second.next;
                second.next = first;
                head.next = second;
                head = first;
            }
            return dummyHead.next;
        }

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:40 MB,击败了61.22% 的Java用户
         * from huahua
         * 没思路，不会写
         *
         * @param head
         * @return
         */
        public ListNode swapPairs_first(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummyHead = new ListNode(0, head);
            head = dummyHead;
            while (head.next != null && head.next.next != null) {
                ListNode n1 = head.next;
                ListNode n2 = head.next.next;
                n1.next = n2.next;
                n2.next = n1;
                head.next = n2;
                head = n1;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}