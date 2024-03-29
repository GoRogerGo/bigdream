package com.roger.bigdream.leetcode.editor.en;
//Design your implementation of the circular queue. The circular queue is a line
//ar data structure in which the operations are performed based on FIFO (First In 
//First Out) principle, and the last position is connected back to the first posit
//ion to make a circle. It is also called "Ring Buffer". 
//
// One of the benefits of the circular queue is that we can make use of the spac
//es in front of the queue. In a normal queue, once the queue becomes full, we can
//not insert the next element even if there is a space in front of the queue. But 
//using the circular queue, we can use the space to store new values. 
//
// Implement the MyCircularQueue class: 
//
// 
// MyCircularQueue(k) Initializes the object with the size of the queue to be k.
// 
// int Front() Gets the front item from the queue. If the queue is empty, return
// -1. 
// int Rear() Gets the last item from the queue. If the queue is empty, return -
//1. 
// boolean enQueue(int value) Inserts an element into the circular queue. Return
// true if the operation is successful. 
// boolean deQueue() Deletes an element from the circular queue. Return true if 
//the operation is successful. 
// boolean isEmpty() Checks whether the circular queue is empty or not. 
// boolean isFull() Checks whether the circular queue is full or not. 
// 
//
// You must solve the problem without using the built-in queue data structure in
// your programming language. 
//
// 
// Example 1: 
//
// 
//Input
//["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFul
//l", "deQueue", "enQueue", "Rear"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//Output
//[null, true, true, true, false, 3, true, true, true, 4]
//
//Explanation
//MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//myCircularQueue.enQueue(1); // return True
//myCircularQueue.enQueue(2); // return True
//myCircularQueue.enQueue(3); // return True
//myCircularQueue.enQueue(4); // return False
//myCircularQueue.Rear();     // return 3
//myCircularQueue.isFull();   // return True
//myCircularQueue.deQueue();  // return True
//myCircularQueue.enQueue(4); // return True
//myCircularQueue.Rear();     // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, an
//d isFull. 
// 
// Related Topics Array Linked List Design Queue 
// 👍 3233 👎 250

public class _622DesignCircularQueue {

    public void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {

        private int[] elements;
        private int capacity = 0;
        private int front = 0;
        private int rear = 0;

        /**
         * 解答成功: 执行耗时:4 ms,击败了100.00% 的Java用户 内存消耗:44.4 MB,击败了54.14% 的Java用户
         * 2023年07月30日12:13:46
         * 有多个易错的地方，牢记吧
         *
         * @param k
         */
        public MyCircularQueue(int k) {
            capacity = k + 1;
            elements = new int[k + 1];
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            elements[rear] = value;
            rear = (rear + 1) % capacity; //这行易错
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity; //这行易错
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return elements[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return elements[(rear - 1 + capacity) % capacity]; //这行易错
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        } //这行易错
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)


}