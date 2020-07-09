//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking 
// 👍 5158 👎 267


package com.roger.bigdream.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:8 ms, faster than 10.92% of Java online submissions.
         * Memory Usage:40.1 MB, less than 23.11% of Java online submissions.
         *
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; c++) {
                    for (String left : generateParenthesis(c)) {
                        for (String right : generateParenthesis(n - 1 - c)) {
                            ans.add("(" + left + ")" + right);
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:1 ms, faster than 86.46% of Java online submissions.
     * Memory Usage:39.3 MB, less than 86.56% of Java online submissions.
     *
     * @param n
     * @return
     */
    public List<String> backtracking(int n) {
        List<String> result = new ArrayList<>();
        backtracking0(result, "", 0, 0, n);
        return result;
    }

    private void backtracking0(List<String> result, String s, int open, int close, int max) {
        if (s.length() == 2 * max) {
            result.add(s);
        }
        if (open < max) {
            backtracking0(result, s + "(", open + 1, close, max);
        }
        if (open > close) {
            backtracking0(result, s + ")", open, close + 1, max);
        }
    }
}