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
// The functions get and put must each run in O(1) average time complexity. 
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
// 0 <= key <= 104 
// 0 <= value <= 105 
// At most 2 * 105 calls will be made to get and put. 
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 
// 👍 18730 👎 832

import java.util.Hashtable;

public class _146LruCache {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        /**
         * 估计是用了hashtable，无法编译通过
         * 2023年07月24日12:52:42
         * 直接看的别人的代码，下次再写一遍
         */
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private Hashtable<Integer, DLinkedNode>
                cache = new Hashtable<Integer, DLinkedNode>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        /**
         * Always add the new node right after head;
         */
        private void addNode(DLinkedNode node) {

            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        /**
         * Remove an existing node from the linked list.
         */
        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.prev;
            DLinkedNode post = node.next;

            pre.next = post;
            post.prev = pre;
        }

        /**
         * Move certain node in between to the head.
         */
        private void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        // pop the current tail.
        private DLinkedNode popTail() {
            DLinkedNode res = tail.prev;
            this.removeNode(res);
            return res;
        }

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.prev = null;

            tail = new DLinkedNode();
            tail.next = null;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {

            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1; // should raise exception here.
            }

            // move the accessed node to the head;
            this.moveToHead(node);

            return node.value;
        }


        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                this.cache.put(key, newNode);// 添加进哈希表
                this.addNode(newNode);// 添加至双向链表的头部
                ++count;

                if (count > capacity) {
                    DLinkedNode tail = this.popTail();// 如果超出容量，删除双向链表的尾部节点
                    this.cache.remove(tail.key);// 删除哈希表中对应的项
                    --count;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                this.moveToHead(node);
            }
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