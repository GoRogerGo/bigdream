//Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
// Related Topics Two Pointers String


package com.roger.bigdream.leetcode.editor.en;

class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        solution.strStr("mississippi", "issipi");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) return 0;
            if ("".equals(haystack)) return -1;
            int limit = haystack.length() - needle.length();
            if (limit < 0) return -1;
            for (int i = 0; i < limit + 1; i++) {
                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private int myApproach(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;
        if (haystack.length() < needle.length()) return -1;

        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();


        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean same = true;
            for (int j = 0; j < needle.length() && i + j < haystack.length(); j++) {
                if (s1[i + j] != s2[j]) {
                    same = false;
                    break;
                }
            }
            if (same) return i;
        }
        return -1;
    }
}