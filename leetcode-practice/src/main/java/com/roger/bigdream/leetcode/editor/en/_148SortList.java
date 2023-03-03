package com.roger.bigdream.leetcode.editor.en;
//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
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
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge Sort
// 
// 👍 9295 👎 281

public class _148SortList {

    public static void main(String[] args) {
        Solution solution = new _148SortList().new Solution();
        ListNode result = solution.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
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
        /**
         * 第二次编写 2023年03月03日11:04:45
         * 解答成功: 执行耗时:12 ms,击败了64.65% 的Java用户 内存消耗:50.9 MB,击败了53.74% 的Java用
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            // 初始判断
            if (head == null || head.next == null) return head;
            // 通过快慢指针法找出中间节点
            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return mergeSort(left, right);
        }

        private ListNode mergeSort(ListNode left, ListNode right) {
            ListNode dummyHead = new ListNode(0);
            ListNode curNode = dummyHead;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    curNode.next = left;
                    left = left.next;
                } else {
                    curNode.next = right;
                    right = right.next;
                }
                curNode = curNode.next;
            }
            if (left != null) curNode.next = left;
            else curNode.next = right;
            return dummyHead.next;
        }

        private ListNode getMid(ListNode head) {
            ListNode midPrev = null;
            while (head != null && head.next != null) {
                midPrev = (midPrev == null) ? head : midPrev.next;
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }

        /**
         * 解答成功: 执行耗时:11 ms,击败了80.35% 的Java用户 内存消耗:50.2 MB,击败了75.66% 的Java用户
         * 心得：其实没那么难，需要①熟练掌握双指针法 ②有信心战胜递归
         *
         * @param head
         * @return
         */
        public ListNode sortList_first(ListNode head) {
            // 初始判断
            if (head == null || head.next == null) return head;
            // 通过快慢指针法找出中间节点
            ListNode mid = getMid_first(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return mergeSort_first(left, right);
        }

        private ListNode getMid_first(ListNode head) {
            ListNode midPrev = null;
            while (head != null && head.next != null) {
                midPrev = (midPrev == null) ? head : midPrev.next;
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }

        private ListNode mergeSort_first(ListNode left, ListNode right) {
            ListNode dummyHead = new ListNode(0);
            ListNode node = dummyHead;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
                node = node.next;
            }
            if (left != null) node.next = left;
            else node.next = right;
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}