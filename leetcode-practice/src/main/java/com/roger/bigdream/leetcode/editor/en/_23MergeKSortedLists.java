package com.roger.bigdream.leetcode.editor.en;
//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 104 
// 0 <= lists[i].length <= 500 
// -104 <= lists[i][j] <= 104 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 104. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge Sor
//t 
// 👍 15636 👎 584

public class _23MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new _23MergeKSortedLists().new Solution();

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
         * 看了花花的视频，能瞄一眼写对。2023年03月04日22:53:20
         * 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:44.9 MB,击败了18.47% 的Java用户
         * 注意点：①什么叫做分治，好好体会下！②l,mid；mid+1,r，注意这个mid+1
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            if (lists.length == 1) return lists[0];
            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int l, int r) {
            if (l > r) return null;
            if (l == r) return lists[l];
            int mid = l + (r - l) / 2;
            ListNode left = mergeKLists(lists, l, mid);
            ListNode right = mergeKLists(lists, mid + 1, r);
            return mergeTwoLists(left, right);
        }

        /**
         * 下午10:28	info
         * 解答成功:
         * 执行耗时:105 ms,击败了19.49% 的Java用户
         * 内存消耗:45 MB,击败了18.02% 的Java用户
         * <p>
         * 一次写对，但性能不好。。。 2023年03月04日22:28:48
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists_myself(ListNode[] lists) {
            if (lists.length == 0) return null;
            else if (lists.length == 1) return lists[0];
            else {
                ListNode result = lists[0];
                for (int index = 1; index < lists.length; index++) {
                    result = mergeTwoLists(result, lists[index]);
                }
                return result;
            }
        }

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