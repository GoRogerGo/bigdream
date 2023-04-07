package com.roger.bigdream.leetcode.editor.en;
//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 32958 👎 1439

import java.util.Arrays;

public class _3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new _3LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:3 ms,击败了95.93% 的Java用户 内存消耗:43 MB,击败了29.85% 的Java用户
         * 2023年04月07日17:24:13
         * 直接看的花花的答案，挺精妙的
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int[] last = new int[128];
            Arrays.fill(last, -1);
            int ans = 0, start = 0;
            for (int i = 0; i < s.length(); i++) {
                if (last[s.charAt(i)] != -1) {
                    start = Math.max(start, last[s.charAt(i)] + 1);
                }
                last[s.charAt(i)] = i;
                ans = Math.max(ans, i - start + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}