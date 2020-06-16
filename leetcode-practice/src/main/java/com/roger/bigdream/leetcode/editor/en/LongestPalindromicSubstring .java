//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming


package com.roger.bigdream.leetcode.editor.en;

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if ("".equals(s) || s.length() == 1) return s;
            int start = 0;
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                int curr = Math.max(getLength(s, i, i), getLength(s, i, i + 1));
                if (curr > length) {
                    length = curr;
                    start = i - (length - 1) / 2;
                }
            }
            return s.substring(start, start + length);
        }

        private int getLength(String s, int left, int right) {
            while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1; //开区间，所以是right-left+1-2
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    private String myApproach(String s) {
        if ("".equals(s)) return "";

        // 特殊情况
        boolean singleChars = true;
        char firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (firstChar != s.charAt(i)) {
                singleChars = false;
                break;
            }
        }
        if (singleChars) {
            return s;
        }

        // 初始化
        String resultMode1 = "";
        String resultMode2 = "";
        StringBuilder temp = new StringBuilder();
        char[] cs = s.toCharArray();
        int maxLength = 0;
        // 回文子串模式一：中心对称，类似"aba"
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && i + j < s.length(); j++) {
                if (cs[i - j] == cs[i + j]) {
                    temp.setLength(0);
                    temp.append(cs, i - j, 2 * j + 1);
                    if (maxLength < temp.length()) {
                        resultMode1 = temp.toString();
                        maxLength = temp.length();
                    }
                } else {
                    temp.setLength(0);
                    break;
                }
            }
        }
        // 回文子串模式二：轴对称，类似"abba"
        maxLength = 0;
        temp.setLength(0);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && i + 1 + j < s.length(); j++) {
                if (cs[i - j] == cs[i + 1 + j]) {
                    temp.setLength(0);
                    temp.append(cs, i - j, 2 * j + 2);
                    if (maxLength < temp.length()) {
                        resultMode2 = temp.toString();
                        maxLength = temp.length();
                    }
                } else {
                    temp.setLength(0);
                    break;
                }
            }
        }
        return resultMode1.length() > resultMode2.length() ? resultMode1 : resultMode2;
    }
}