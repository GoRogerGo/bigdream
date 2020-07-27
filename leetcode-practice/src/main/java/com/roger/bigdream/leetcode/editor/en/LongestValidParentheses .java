//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics String Dynamic Programming 
// 👍 3500 👎 136


package com.roger.bigdream.leetcode.editor.en;

import java.util.Stack;

class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses(")()())()()()()"));
        System.out.println(solution.longestValidParentheses(")()())()()()())"));
        System.out.println(solution.longestValidParentheses("()(())"));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses("(()()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 记忆搜索法
         * 1.建立一个数组dp[i]，表示以s[i]结尾的有效括号子串的长度。
         * 2.从头开始遍历，如果当前字符是右括号，则从当前位置前一个位置开始寻找没有被匹配过的左括号，
         * 得到dp数组后，遍历求出连续有效括号子串的最大长度。
         * <p>
         * Runtime:1 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:39.2 MB, less than 69.69% of Java online submissions.
         *
         * @param s
         * @return
         */
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                if (s.charAt(i) != ')') {
                    continue;
                }
                int j = i - 1;
                while (j >= 0) {
                    if (s.charAt(j) == '(') {
                        dp[i] = i - j + 1;
                        break;
                    }
                    if (dp[j] == 0) {
                        break;
                    }
                    j -= dp[j];
                }
            }
            int sum = 0;
            for (int i = dp.length - 1; i >= 0; ) {
                if (dp[i] > 0) {
                    sum += dp[i];
                    i -= dp[i];
                } else {
                    i--;
                    sum = 0;
                }
                res = Math.max(res, sum);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 向stack中注入下标
     * Runtime:2 ms, faster than 79.22% of Java online submissions.
     * Memory Usage:39.1 MB, less than 72.78% of Java online submissions.
     *
     * @param s
     * @return
     */
    public int stackIndex(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，直接将对应的下标push到栈中
                stack.push(i);
            } else {
                // 弹出栈顶的下标
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 用当前下标减去栈顶元素的下标，和maxLength比较大小
                    int count = i - stack.peek();
                    maxLength = Math.max(maxLength, count);
                }
            }
        }
        return maxLength;
    }

    int length, maxLength;
    Stack<Character> stack = new Stack<>();

    public int myWrongApproach(String s) {
        length = 0;
        maxLength = 0;
        longestValidParentheses0(s);
        return maxLength * 2;
    }

    private void longestValidParentheses0(String s) {
        if ("".equals(s)) return;
        if (s.startsWith("()")) {
            length++;
            longestValidParentheses0(s.substring(2));
            maxLength = Math.max(length, maxLength);
            return;
        }
        if (s.startsWith(")")) {
            if (!stack.isEmpty()) {
                stack.pop();
                length++;
            }
            maxLength = Math.max(length, maxLength);
            length = 0;
            stack.empty();
            longestValidParentheses0(s.substring(1));
            return;
        }
        if (s.startsWith("(")) {
            stack.push(s.charAt(0));
            longestValidParentheses0(s.substring(1));
            maxLength = Math.max(length, maxLength);
            return;
        }
    }
}