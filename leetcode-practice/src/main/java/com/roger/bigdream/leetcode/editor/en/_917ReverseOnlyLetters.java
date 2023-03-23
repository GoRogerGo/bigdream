package com.roger.bigdream.leetcode.editor.en;
//Given a string s, reverse the string according to the following rules: 
//
// 
// All the characters that are not English letters remain in the same position. 
//
// All the English letters (lowercase or uppercase) should be reversed. 
// 
//
// Return s after reversing it. 
//
// 
// Example 1: 
// Input: s = "ab-cd"
//Output: "dc-ba"
// Example 2: 
// Input: s = "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
// Example 3: 
// Input: s = "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of characters with ASCII values in the range [33, 122]. 
// s does not contain '\"' or '\\'. 
// 
// Related Topics Two Pointers String 
// 👍 1808 👎 62

public class _917ReverseOnlyLetters {

    public static void main(String[] args) {
        Solution solution = new _917ReverseOnlyLetters().new Solution();
        System.out.println(solution.reverseOnlyLetters("ab-cd"));
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int ASCLL_A = 65;
        private static final int ASCLL_Z = 90;
        private static final int ASCLL_a = 97;
        private static final int ASCLL_z = 122;

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:40.9 MB,击败了27.75% 的Java用户
         * 自己的答案，一次成功
         * 2023年03月23日11:22:51
         *
         * @param s
         * @return
         */
        public String reverseOnlyLetters(String s) {
            if (s.length() == 0 || s.length() == 1) return s;
            int l = 0;
            int r = s.length() - 1;
            char[] temp = new char[s.length()];
            while (l <= r) {
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                if (!(lc >= ASCLL_A && lc <= ASCLL_Z || lc >= ASCLL_a && lc <= ASCLL_z)) {
                    temp[l] = lc;
                    l++;
                    continue;
                }
                if (!(rc >= ASCLL_A && rc <= ASCLL_Z || rc >= ASCLL_a && rc <= ASCLL_z)) {
                    temp[r] = rc;
                    r--;
                    continue;
                }
                temp[l] = rc;
                l++;
                temp[r] = lc;
                r--;
            }
            return String.valueOf(temp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}