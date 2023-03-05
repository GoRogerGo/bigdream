package com.roger.bigdream.leetcode.editor.en;
//Given the head of a linked list, return the node where the cycle begins. If th
//ere is no cycle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a param
//eter. 
//
// Do not modify the linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Hash Table Linked List Two Pointers 
// 👍 10347 👎 760

public class _142LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new _142LinkedListCycleIi().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:43.3 MB,击败了26.98% 的Java用户
         * 感受：和141题一样，按照大致理解的意思写了答案，但不正确。看到网友提交的代码才大概明白题意。自己下次可以尝试一次写对。
         * 2023年03月05日20:19:13
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                if (fast.next == null) return null;
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) break;
            }
            if (fast == null || fast.next == null) return null;
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}