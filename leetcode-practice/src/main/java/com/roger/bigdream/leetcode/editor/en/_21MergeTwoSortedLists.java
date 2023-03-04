package com.roger.bigdream.leetcode.editor.en;
//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists in a one sorted list. The list should be made by splicing
// together the nodes of the first two lists. 
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
//
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 
// 👍 17306 👎 1594

public class _21MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new _21MergeTwoSortedLists().new Solution();
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        solution.mergeTwoLists(node1, node2);
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
         * 下午10:01	info
         * 解答成功:
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:42.5 MB,击败了20.19% 的Java用户
         * <p>
         * 一次写对，easy 2023年03月04日22:03:40
         *
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            ListNode dummyHead = new ListNode(0);
            ListNode node = dummyHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    node.next = list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    list2 = list2.next;
                }
                node = node.next;
            }
            if (list1 != null) node.next = list1;
            if (list2 != null) node.next = list2;
            return dummyHead.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}