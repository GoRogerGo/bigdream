package com.roger.bigdream.leetcode.editor.en;

//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// Follow up: 
//Could you do get and put in O(1) time complexity? 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// At most 3 * 104 calls will be made to get and put. 
// 
// Related Topics Design 
// 👍 8409 👎 343


import java.util.HashMap;

public class LruCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        int capacity;
        ListNode tail = new ListNode(0, 0);
        ListNode head = new ListNode(0, 0);

        HashMap<Integer, ListNode> hashMap = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                ListNode node = hashMap.get(key);
                moveNodeToTop(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                ListNode node = hashMap.get(key);
                node.value = value;
                moveNodeToTop(node);
            } else {
                if (hashMap.size() == capacity) deleteLastNode();
                ListNode newNode = new ListNode(key, value);
                ListNode temp = head.next;

                head.next = newNode;
                newNode.prev = head;
                newNode.next = temp;
                temp.prev = newNode;
                hashMap.put(key, newNode);
            }
        }

        private void deleteLastNode() {
            ListNode node = tail.prev;
            tail.prev = node.prev;
            node.prev.next = tail;
            hashMap.remove(node.key);
        }

        private void moveNodeToTop(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            ListNode temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
        }
    }

    class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode prev;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode(int key, int value, ListNode prev, ListNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
//leetcode submit region end(Prohibit modification and deletion)

}