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

import java.util.*;

public class _3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new _3LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 我们就可以使用「滑动窗口」来解决这个问题了：
         * 我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的rk
         * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
         * 在枚举结束后，我们找到的最长的子串的长度即为答案。
         * <p>
         * 官网答案
         * 2023年07月30日16:26:58
         * 解答成功: 执行耗时:7 ms,击败了73.46% 的Java用户 内存消耗:44.2 MB,击败了22.41% 的Java用户
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            Set<Character> charSet = new HashSet<>();
            int n = s.length();
            int rk = -1, ans = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    charSet.remove(s.charAt(i - 1)); //这里是charAt[i-1]，不是charAt[i]
                }
                while (rk + 1 < n && !charSet.contains(s.charAt(rk + 1))) { //这里是rk + 1 < n，不是rk < n；是charAt[rk + 1]，不是charAt[rk]
                    charSet.add(s.charAt(rk + 1));
                    ++rk;
                }
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }

        /**
         * 解答成功: 执行耗时:3 ms,击败了95.93% 的Java用户 内存消耗:43 MB,击败了29.85% 的Java用户
         * 2023年04月07日17:24:13
         * 直接看的花花的答案，挺精妙的
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring_huahua(String s) {
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