package com.roger.bigdream.leetcode.editor.en;
//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 24376 👎 1425

public class _5LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new _5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:18 ms,击败了95.00% 的Java用户 内存消耗:42.7 MB,击败了54.41% 的Java用户
         * 2023年03月23日10:34:11
         * 花花的答案，一直疑惑是无法用双指针的，因为不知道该左边加一还是右边减一
         * 注意点：①start = i - (cur - 1) / 2; ②return r - l - 1; ③是l--和r++ ④cur是两个长度取大的值
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int len = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int cur = Math.max(getLength(s, i, i), getLength(s, i, i + 1));
                if (cur > len) {
                    len = cur;
                    start = i - (cur - 1) / 2;
                }
            }
            return s.substring(start, start + len);
        }

        private int getLength(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}