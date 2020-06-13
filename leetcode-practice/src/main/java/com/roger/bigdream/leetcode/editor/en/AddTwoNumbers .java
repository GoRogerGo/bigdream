//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math


package com.roger.bigdream.leetcode.editor.en;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1, null)))))))))))))))))))))))))))))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
//        ListNode l1 = new ListNode(0, null);
//        ListNode l2 = new ListNode(1, null);
        System.out.println(solution.addTwoNumbers(l1, l2));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tail = new ListNode(0);
            ListNode dummyHead = tail;
            int sum, carry = 0;
            while (null != l1 || null != l2 || carry != 0) {
                sum = (null == l1 ? 0 : l1.val) + (null == l2 ? 0 : l2.val) + carry;
                carry = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
                if (null != l1) l1 = l1.next;
                if (null != l2) l2 = l2.next;
            }
            return dummyHead.next;
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
     * 1560 / 1563 test cases passed.
     * long溢出
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode myApproach(ListNode l1, ListNode l2) {
        // decode l1
        long val1 = getListNodeVal(l1);
        // decode l2
        long val2 = getListNodeVal(l2);
        // encode result
        return computeNode(val1 + val2);
    }

    private ListNode computeNode(Long target) {
        if (target < 10) {
            return new ListNode(target.intValue(), null);
        }

        char[] array = String.valueOf(target).toCharArray();// [8,0,7]
        ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(array[array.length - 1])), new ListNode());
        ListNode curNode = listNode.next;
        for (int i = array.length - 2; i >= 0; i--) {
            curNode.val = Integer.parseInt(String.valueOf(array[i]));
            curNode.next = i == 0 ? null : new ListNode();
            if (null != curNode.next) {
                curNode = curNode.next;
            }
        }
        return listNode;
    }

    private Long getListNodeVal(ListNode node) {
        if (null == node) return 0L;
        long val = 0;
        int depth = 0;
        while (null != node) {
            val += node.val * Math.pow(10, depth);
            node = node.next;
            depth++;
        }
        return val;
    }

}