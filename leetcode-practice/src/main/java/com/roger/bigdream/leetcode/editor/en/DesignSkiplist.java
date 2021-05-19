package com.roger.bigdream.leetcode.editor.en;

//Design a Skiplist without using any built-in libraries. 
//
// A Skiplist is a data structure that takes O(log(n)) time to add, erase and se
//arch. Comparing with treap and red-black tree which has the same function and pe
//rformance, the code length of Skiplist can be comparatively short and the idea b
//ehind Skiplists are just simple linked lists. 
//
// For example: we have a Skiplist containing [30,40,50,60,70,90] and we want to
// add 80 and 45 into it. The Skiplist works this way: 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// You can see there are many layers in the Skiplist. Each layer is a sorted lin
//ked list. With the help of the top layers, add , erase and search can be faster 
//than O(n). It can be proven that the average time complexity for each operation 
//is O(log(n)) and space complexity is O(n). 
//
// To be specific, your design should include these functions: 
//
// 
// bool search(int target) : Return whether the target exists in the Skiplist or
// not. 
// void add(int num): Insert a value into the SkipList. 
// bool erase(int num): Remove a value in the Skiplist. If num does not exist in
// the Skiplist, do nothing and return false. If there exists multiple num values,
// removing any one of them is fine. 
// 
//
// See more about Skiplist : https://en.wikipedia.org/wiki/Skip_list 
//
// Note that duplicates may exist in the Skiplist, your code needs to handle thi
//s situation. 
//
// 
//
// Example: 
//
// 
//Skiplist skiplist = new Skiplist();
//
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // return false.
//skiplist.add(4);
//skiplist.search(1);   // return true.
//skiplist.erase(0);    // return false, 0 is not in skiplist.
//skiplist.erase(1);    // return true.
//skiplist.search(1);   // return false, 1 has already been erased. 
//
// 
// Constraints: 
//
// 
// 0 <= num, target <= 20000 
// At most 50000 calls will be made to search, add, and erase. 
// Related Topics Design 
// 👍 250 👎 30


import java.util.Random;
import java.util.Stack;

public class DesignSkiplist {
    public static void main(String[] args) {
//		Solution solution = new DesignSkiplist().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Runtime:1049 ms, faster than 5.21% of Java online submissions.
     * Memory Usage:45.4 MB, less than 64.45% of Java online submissions.
     */
    class Skiplist {
        SkipListNode head;

        public Skiplist() {
            head = new SkipListNode();
        }

        public boolean search(int target) {
            SkipListNode node = head;
            while (node != null) {
                // Move to the right in the current level
                while (node.next != null && node.next.val < target) {
                    node = node.next;
                }
                if (node.next != null && node.next.val == target) {
                    return true;
                }
                // Move to the the next level
                node = node.down;
            }
            return false;
        }

        public void add(int num) {
            Stack<SkipListNode> stack = new Stack<>();
            SkipListNode node = head;
            while (node != null) {
                while (node.next != null && node.next.val < num) {
                    node = node.next;
                }
                stack.push(node);
                node = node.down;
            }

            boolean insert = true;
            SkipListNode down = null;
            while (insert && !stack.empty()) {
                SkipListNode skipListNode = stack.pop();
                skipListNode.next = new SkipListNode(num, skipListNode.next, down);
                down = skipListNode.next;
                insert = (new Random(2).nextInt() == 0);
            }

            if (insert) {
                head = new SkipListNode(-1, null, head);
            }
        }

        public boolean erase(int num) {
            SkipListNode node = head;
            boolean found = false;
            while (node != null) {
                while (node.next != null && node.next.val < num) {
                    node = node.next;
                }
                if (node.next != null && node.next.val == num) {
                    node.next = node.next.next;
                    found = true;
                }
                node = node.down; //每一层都要删除
            }
            return found;
        }
    }

    class SkipListNode {
        int val;
        SkipListNode next;
        SkipListNode down;

        SkipListNode() {
            val = -1;
        }

        SkipListNode(int val) {
            this.val = val;
        }

        SkipListNode(int val, SkipListNode next, SkipListNode down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }
    /**
     * Your Skiplist object will be instantiated and called as such:
     * Skiplist obj = new Skiplist();
     * boolean param_1 = obj.search(target);
     * obj.add(num);
     * boolean param_3 = obj.erase(num);
     */
//leetcode submit region end(Prohibit modification and deletion)
}