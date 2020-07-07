//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack 
// 👍 5024 👎 217


package com.roger.bigdream.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("(("));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private HashMap<Character, Character> mappings = new HashMap<Character, Character>();

        // Initialize hash map with mappings. This simply makes the code easier to read.
        public Solution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {
            // Initialize a stack to be used in the algorithm.
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // If the current character is a closing bracket.
                if (this.mappings.containsKey(c)) {

                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                    char topElement = stack.empty() ? '#' : stack.pop();

                    // If the mapping for this bracket doesn't match the stack's top element, return false.
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    stack.push(c);
                }
            }

            // If the stack still contains elements, then it is an invalid expression.
            return stack.isEmpty();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:3 ms, faster than 22.86% of Java online submissions.
     * Memory Usage:39.2 MB, less than 12.57% of Java online submissions.
     *
     * @param s
     * @return
     */
    Map<Character, Character> positiveSet = new HashMap<>();
    Map<Character, Character> negativeSet = new HashMap<>();

    {
        positiveSet.put('(', ')');
        positiveSet.put('{', '}');
        positiveSet.put('[', ']');
        negativeSet.put(')', '(');
        negativeSet.put('}', '{');
        negativeSet.put(']', '[');
    }

    private boolean myApproach(String s) {
        if (null == s || "".equals(s)) return true;
        if (negativeSet.containsKey(s.charAt(0))) return false;
        if (s.length() % 2 == 1) return false;

        Stack<Character> temp = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (positiveSet.containsKey(c)) {
                temp.push(c);
            } else {
                if (negativeSet.get(c) != temp.pop()) {
                    return false;
                }
            }
        }
        if (temp.isEmpty()) return true;
        return false;
    }
}