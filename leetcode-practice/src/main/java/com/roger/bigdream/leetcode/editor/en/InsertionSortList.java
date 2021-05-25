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
// Related Topics Linked List Sort 
// 👍 1080 👎 690


public class InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();

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
         * Runtime:2 ms, faster than 97.94% of Java online submissions.
         *
         * @param head
         * @return
         */
        public ListNode insertionSortList(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            ListNode pre = dummyHead; //存插入的位置的前一个节点
            ListNode node = head; //遍历输入的链表
            while (node != null) {
                ListNode cur = node;
                node = node.next;
                if (cur.val < pre.val) pre = dummyHead; //当前元素的大小小于上一次插入位置的元素大小，则将重置为dummyHead。
                while (pre.next != null && cur.val > pre.next.val) {
                    pre = pre.next;
                }
                // cur插入pre的后面
                cur.next = pre.next;
                pre.next = cur;
            }

            return dummyHead.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
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
}