package com.roger.bigdream.leetcode.editor.en;

//Design a HashMap without using any built-in hash table libraries. 
//
// Implement the MyHashMap class: 
//
// 
// MyHashMap() initializes the object with an empty map. 
// void put(int key, int value) inserts a (key, value) pair into the HashMap. If
// the key already exists in the map, update the corresponding value. 
// int get(int key) returns the value to which the specified key is mapped, or -
//1 if this map contains no mapping for the key. 
// void remove(key) removes the key and its corresponding value if the map conta
//ins the mapping for the key. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//Output
//[null, null, null, 1, -1, null, 1, null, -1]
//
//Explanation
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // The map is now [[1,1]]
//myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2
//,2]]
//myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existi
//ng value)
//myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= key, value <= 106 
// At most 104 calls will be made to put, get, and remove. 
// 
// Related Topics Hash Table Design 
// 👍 1586 👎 175


import java.util.List;
import java.util.Random;

public class DesignHashmap {
    public static void main(String[] args) {
//		Solution solution = new DesignHashmap().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Runtime:28 ms, faster than 33.84% of Java online submissions.
     */
    class MyHashMap {
        ListNode[] arrays;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            arrays = new ListNode[1009];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = hash(key);
            ListNode head = arrays[index];
            if (head == null) {
                arrays[index] = new ListNode(key, value, null, null);
            } else {
                ListNode node = head;
                boolean found = false;
                while (node != null) {
                    if (node.key == key) {
                        node.value = value;
                        found = true;
                        break;
                    }
                    node = node.next;
                }
                if (!found) {
                    ListNode newNode = new ListNode(key, value, head, null);
                    arrays[index] = newNode;
                    head.prev = newNode;
                }
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int index = hash(key);
            ListNode node = arrays[index];
            while (node != null) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
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

        private int hash(int key) {
            return key % 1009;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode() {
        }

        public ListNode(int key, int value, ListNode next, ListNode prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}