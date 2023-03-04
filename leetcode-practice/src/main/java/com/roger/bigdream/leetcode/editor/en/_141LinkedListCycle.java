package com.roger.bigdream.leetcode.editor.en;
//Given head, the head of a linked list, determine if the linked list has a cycl
//e in it. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Return true if there is a cycle in the linked list. Otherwise, return false. 
//
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to t
//he 1st node (0-indexed).
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to t
//he 0th node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: false
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
// 👍 11559 👎 981

public class _141LinkedListCycle {

    public static void main(String[] args) {
        Solution solution = new _141LinkedListCycle().new Solution();

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
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:43.9 MB,击败了23.86% 的Java用户
         * 感受：其实一开始没读懂意思，看到花花的代码才明白。hasCycle的经典做法是快慢指针法，相信自己下次能够一次写对。
         *
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                if (fast.next == null) return false;
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}