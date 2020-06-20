//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*'. 
//
// 
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// . or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking


package com.roger.bigdream.leetcode.editor.en;

class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            return dynamicPlan(s, p);
        }

        /**
         * Runtime:2 ms, faster than 92.98% of Java online submissions.
         * Memory Usage:38.5 MB, less than 61.14% of Java online submissions.
         *
         * @param s
         * @param p
         * @return
         */
        private boolean dynamicPlan(String s, String p) {
            // 多一维的空间，方便处理
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            // dp[len][len]代表两个空串是否匹配了
            dp[s.length()][p.length()] = true;// 相当于递归的结束条件
            for (int i = s.length(); i >= 0; i--) {
                for (int j = p.length(); j >= 0; j--) {
                    if (i == s.length() && j == p.length()) continue;
                    boolean isFirstMatch = (i < s.length() && j < p.length())
                            && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || isFirstMatch && dp[i + 1][j];
                    } else {
                        dp[i][j] = isFirstMatch && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归法
     * Runtime:69 ms, faster than 13.21% of Java online submissions.
     * Memory Usage:39.4 MB, less than 49.68% of Java online submissions.
     *
     * @param s
     * @param p
     * @return
     */
    private boolean recursive(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 检测到p中第i个元素的下一个元素为"*"时，有两种情况
        // p的第i个元素在s中出现0次。此时，s不变，p剪去首部2个元素
        // p的第i个元素在s中出现1次或多次。此时，比较i元素和s的首元素是否相同，如果相同则剪去s的首元素，保持p不变继续递归。
        boolean isFirstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return recursive(s, p.substring(2)) || isFirstMatch && recursive(s.substring(1), p);
        } else {
            return isFirstMatch && recursive(s.substring(1), p.substring(1));
        }
    }
}