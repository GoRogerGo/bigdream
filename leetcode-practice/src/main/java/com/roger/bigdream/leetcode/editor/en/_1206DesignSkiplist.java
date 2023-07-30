package com.roger.bigdream.leetcode.editor.en;
//Design a Skiplist without using any built-in libraries. 
//
// A skiplist is a data structure that takes O(log(n)) time to add, erase and se
//arch. Comparing with treap and red-black tree which has the same function and pe
//rformance, the code length of Skiplist can be comparatively short and the idea b
//ehind Skiplists is just simple linked lists. 
//
// For example, we have a Skiplist containing [30,40,50,60,70,90] and we want to
// add 80 and 45 into it. The Skiplist works this way: 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// You can see there are many layers in the Skiplist. Each layer is a sorted lin
//ked list. With the help of the top layers, add, erase and search can be faster t
//han O(n). It can be proven that the average time complexity for each operation i
//s O(log(n)) and space complexity is O(n). 
//
// See more about Skiplist: https://en.wikipedia.org/wiki/Skip_list 
//
// Implement the Skiplist class: 
//
// 
// Skiplist() Initializes the object of the skiplist. 
// bool search(int target) Returns true if the integer target exists in the Skip
//list or false otherwise. 
// void add(int num) Inserts the value num into the SkipList. 
// bool erase(int num) Removes the value num from the Skiplist and returns true.
// If num does not exist in the Skiplist, do nothing and return false. If there ex
//ist multiple num values, removing any one of them is fine. 
// 
//
// Note that duplicates may exist in the Skiplist, your code needs to handle thi
//s situation. 
//
// 
// Example 1: 
//
// 
//Input
//["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase",
// "search"]
//[[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
//Output
//[null, null, null, null, false, null, true, false, true, false]
//
//Explanation
//Skiplist skiplist = new Skiplist();
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0); // return False
//skiplist.add(4);
//skiplist.search(1); // return True
//skiplist.erase(0);  // return False, 0 is not in skiplist.
//skiplist.erase(1);  // return True
//skiplist.search(1); // return False, 1 has already been erased. 
//
// 
// Constraints: 
//
// 
// 0 <= num, target <= 2 * 104 
// At most 5 * 104 calls will be made to search, add, and erase. 
// 
// Related Topics Linked List Design 
// 👍 594 👎 68

import java.util.Random;
import java.util.Stack;

public class _1206DesignSkiplist {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Skiplist {

        public Node head;

        public Skiplist() {
            head = new Node(-1);
        }

        /**
         * 解答成功: 执行耗时:445 ms,击败了18.25% 的Java用户 内存消耗:51.6 MB,击败了46.72% 的Java用户
         * 2023年07月24日09:10:40
         * 第二次了，学习了算法知识，看了花花的讲解，其实没那么难
         *
         * @param target
         * @return
         */
        public boolean search(int target) {
            Node node = head;
            while (node != null) {
                while (node.next != null && node.next.val < target) {
                    node = node.next;
                }
                if (node.next != null && node.next.val == target) return true;
                node = node.down;
            }
            return false;
        }

        public void add(int num) {
            // 将每一层小于num的最大元素存储下来，后续在这些元素后插入新结点
            Stack<Node> nodes = new Stack<>();
            Node node = head;
            while (node != null) {
                while (node.next != null && node.next.val < num) {
                    node = node.next;
                }
                nodes.push(node);
                node = node.down;
            }

            boolean insert = true;
            Node down = null;
            while (!nodes.empty() && insert) {
                Node prev = nodes.pop(); // 从下往上
                prev.next = new Node(num, prev.next, down);
                down = prev.next; // 画龙点睛之笔，对于上一层来说，down指向了新插入的结点！
                insert = (new Random(2).nextInt() == 0);
            }

            // 新增一层
            if (insert) {
                head = new Node(-1, null, head);
            }
        }

        public boolean erase(int num) {
            boolean flag = false;
            Node node = head;
            while (node != null) {
                while (node.next != null && node.next.val < num) {
                    node = node.next;
                }
                if (node.next != null && node.next.val == num) {
                    flag = true;
                    node.next = node.next.next; //实际的删除代码
                }
                node = node.down;
            }
            return flag;
        }
    }

    class Node {
        public int val;
        public Node next;
        public Node down;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.down = null;
        }

        public Node(int val, Node next, Node down) {
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