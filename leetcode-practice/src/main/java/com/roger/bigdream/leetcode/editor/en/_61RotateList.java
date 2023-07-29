package com.roger.bigdream.leetcode.editor.en;
//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics Linked List Two Pointers 
// 👍 8285 👎 1392

public class _61RotateList {

    public static void main(String[] args) {
        Solution solution = new _61RotateList().new Solution();
        System.out.println(solution.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(solution.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));

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
         * 2023年07月24日09:23:28
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42 MB,击败了8.91% 的Java用户
         *
         * <p>
         * 看了花花的伪代码，最后还是没有写对，有3处改动
         * reach to the tail node T and count how many nodes in the list
         * get P by moving n-k-1 steps from H
         * N = P.next
         * P.next = null
         * T.next = H
         * return N
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) return head;
            int count = 1;

            ListNode tail = head;
            while (tail.next != null) {
                count++;
                tail = tail.next;
            }
//            ListNode tail = node; 改动3：这行代码很不优雅，其实node就是tail

//            int kk = k % count; 改动1：直接赋值，而不是新定义变量；同时，如果k等于0，直接返回head
            k %= count;
            if (k == 0) return head;


            ListNode pivot = head;
            for (int i = 0; i < count - k - 1; i++) {
//                for (int i = 0; i < kk; i++) { 改动2：moving数不对，不是k，是count - k -1
                pivot = pivot.next;
            }
            ListNode newHead = pivot.next;
            pivot.next = null;
//            tail.next = head; 接改动3：这里用node
            tail.next = head;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}