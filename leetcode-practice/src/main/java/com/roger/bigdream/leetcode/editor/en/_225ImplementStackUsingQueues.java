package com.roger.bigdream.leetcode.editor.en;
//Implement a last-in-first-out (LIFO) stack using only two queues. The implemen
//ted stack should support all the functions of a normal stack (push, top, pop, an
//d empty). 
//
// Implement the MyStack class: 
//
// 
// void push(int x) Pushes element x to the top of the stack. 
// int pop() Removes the element on the top of the stack and returns it. 
// int top() Returns the element on the top of the stack. 
// boolean empty() Returns true if the stack is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a queue, which means that only push 
//to back, peek/pop from front, size and is empty operations are valid. 
// Depending on your language, the queue may not be supported natively. You may 
//simulate a queue using a list or deque (double-ended queue) as long as you use o
//nly a queue's standard operations. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, top, and empty. 
// All the calls to pop and top are valid. 
// 
//
// 
// Follow-up: Can you implement the stack using only one queue? 
// Related Topics Stack Design Queue 
// 👍 4193 👎 982

public class _225ImplementStackUsingQueues {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:39.9 MB,击败了92.43% 的Java用户
     * 2023年04月14日17:22:46
     * 这题不难，但要注意top返回的是count-1位置的元素
     */
    class MyStack {

        private int count; //栈中元素个数
        private int n; //栈的长度
        private int[] array;

        public MyStack() {
            count = 0;
            n = 100;
            array = new int[n];
        }

        public void push(int x) {
            array[count] = x;
            count++;
        }

        public int pop() {
            int result = array[count - 1];
            count--;
            return result;
        }

        public int top() {
            return array[count - 1];
        }

        public boolean empty() {
            return count == 0;
        }
    }


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)


}