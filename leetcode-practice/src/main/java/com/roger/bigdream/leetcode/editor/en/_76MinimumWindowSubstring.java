package com.roger.bigdream.leetcode.editor.en;
//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is i
//ncluded in the window. If there is no such substring, return the empty string ""
//. 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
//om string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
// Related Topics Hash Table String Sliding Window 
// 👍 14626 👎 621

public class _76MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new _76MinimumWindowSubstring().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:3 ms,击败了97.98% 的Java用户 内存消耗:42.8 MB,击败了72.53% 的Java用户
         * 2023年04月07日17:50:12
         * 直接看的花花的答案，挺精妙的，但我看着也很吃力
         *
         * @param s
         * @param t
         * @return
         */
        public String minWindow(String s, String t) {
            int n = s.length();
            int m = t.length();
            int[] freq = new int[128];
            for (char c : t.toCharArray()) ++freq[c];
            int start = 0;
            int l = Integer.MAX_VALUE;
            for (int i = 0, j = 0, left = m; j < n; ++j) {
                if (--freq[s.charAt(j)] >= 0) --left;
                while (left == 0) {
                    if (j - i + 1 < l) {
                        l = j - i + 1;
                        start = i;
                    }
                    if (++freq[s.charAt(i++)] == 1) ++left;
                }
            }
            return l == Integer.MAX_VALUE ? "" : s.substring(start, start + l);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}