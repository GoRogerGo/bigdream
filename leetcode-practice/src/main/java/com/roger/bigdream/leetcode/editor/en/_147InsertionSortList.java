package com.roger.bigdream.leetcode.editor.en;
//Given the head of a singly linked list, sort the list using insertion sort, an
//d return the sorted list's head. 
//
// The steps of the insertion sort algorithm: 
//
// 
// Insertion sort iterates, consuming one input element each repetition and grow
//ing a sorted output list. 
// At each iteration, insertion sort removes one element from the input data, fi
//nds the location it belongs within the sorted list and inserts it there. 
// It repeats until no input elements remain. 
// 
//
// The following is a graphical example of the insertion sort algorithm. The par
//tially sorted list (black) initially contains only the first element in the list
//. One element (red) is removed from the input data and inserted in-place into th
//e sorted list with each iteration. 
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
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5000]. 
// -5000 <= Node.val <= 5000 
// 
// Related Topics Linked List Sorting 
// 👍 2550 👎 831

public class _147InsertionSortList {

    public static void main(String[] args) {
        Solution solution = new _147InsertionSortList().new Solution();
        solution.insertionSortList(new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1)))));
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
         * 解答成功: 执行耗时:20 ms,击败了52.88% 的Java用户 内存消耗:42.8 MB,击败了20.63% 的Java用
         * 第一次写，没怎么领悟，抄花花的答案的，需要看看别人的视频听听讲解 2023年03月04日00:03:18
         *
         * @param head
         * @return
         */
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummyHead = new ListNode(0);
            while (head != null) {
                ListNode iter = dummyHead;
                // 找到head元素小于的元素iter.next，
                while (iter.next != null && head.val > iter.next.val) {
                    iter = iter.next;
                }
                // 暂存head的下一个元素
                ListNode next = head.next;
                // 将head插入iter后、iter.next前，iter是实际的结果
                head.next = iter.next;
                iter.next = head;
                // head移动，进一步外循环
                head = next;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}