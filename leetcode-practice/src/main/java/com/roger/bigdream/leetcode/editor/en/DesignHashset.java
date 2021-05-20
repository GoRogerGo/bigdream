package com.roger.bigdream.leetcode.editor.en;

//Design a HashSet without using any built-in hash table libraries. 
//
// Implement MyHashSet class: 
//
// 
// void add(key) Inserts the value key into the HashSet. 
// bool contains(key) Returns whether the value key exists in the HashSet or not
//. 
// void remove(key) Removes the value key in the HashSet. If key does not exist 
//in the HashSet, do nothing. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove
//", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
//
//Explanation
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed) 
//
// 
// Constraints: 
//
// 
// 0 <= key <= 106 
// At most 104 calls will be made to add, remove, and contains. 
// 
// Related Topics Hash Table Design 
// 👍 726 👎 108


public class DesignHashset {
    public static void main(String[] args) {
//		Solution solution = new DesignHashset().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Runtime:13 ms, faster than 67.09% of Java online submissions.
     */
    class MyHashSet {
        ListNode[] arrays;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            arrays = new ListNode[1009];
        }

        public void add(int key) {
            int index = hash(key);
            ListNode head = arrays[index];
            if (head == null) {
                arrays[index] = new ListNode(key, null, null);
            } else {
                ListNode node = head;
                boolean found = false;
                while (node != null) {
                    if (node.key == key) {
                        found = true;
                        break;
                    }
                    node = node.next;
                }
                if (!found) {
                    ListNode newNode = new ListNode(key, head, null);
                    arrays[index] = newNode;
                    head.prev = newNode;
                }
            }
        }

        public void remove(int key) {
            int index = hash(key);
            ListNode node = arrays[index];
            while (node != null) {
                if (node.key == key) {
                    if (node.prev == null && node.next == null) {
                        //头结点删除且没有后继元素
                        arrays[index] = null;
                    } else if (node.prev != null && node.next == null) {
                        //尾结点删除
                        node.prev.next = null;
                    } else if (node.prev == null && node.next != null) {
                        //头结点删除且有后继元素
                        arrays[index] = node.next;
                        node.next.prev = null;
                    } else {
                        //中间结点删除
                        ListNode preNode = node.prev;
                        node.next.prev = node.prev;
                        preNode.next = node.next;
                    }
                    return;
                }
                node = node.next;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int index = hash(key);
            ListNode node = arrays[index];
            while (node != null) {
                if (node.key == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        private int hash(int key) {
            return key % 1009;
        }
    }

    class ListNode {
        int key;
        ListNode next;
        ListNode prev;

        public ListNode() {
        }

        public ListNode(int key, ListNode next, ListNode prev) {
            this.key = key;
            this.next = next;
            this.prev = prev;
        }
    }
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}