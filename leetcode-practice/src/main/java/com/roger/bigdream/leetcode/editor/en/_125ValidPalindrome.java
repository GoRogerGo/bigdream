package com.roger.bigdream.leetcode.editor.en;
//A phrase is a palindrome if, after converting all uppercase letters into lower
//case letters and removing all non-alphanumeric characters, it reads the same for
//ward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric character
//s.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 105 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 
// 👍 6304 👎 6785

public class _125ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new _125ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("raceacar"));
        System.out.println(solution.isPalindrome(" "));
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int ASCLL_0 = 48;
        private static final int ASCLL_9 = 57;
        private static final int ASCLL_A = 65;
        private static final int ASCLL_Z = 90;
        private static final int ASCLL_a = 97;
        private static final int ASCLL_z = 122;

        /**
         * 解答成功: 执行耗时:2 ms,击败了99.83% 的Java用户 内存消耗:43 MB,击败了55.03% 的Java用户
         * 2023年03月21日20:00:20
         * 自己一次成功
         *
         * @param s
         * @return
         */
        public boolean isPalindrome(String s) {
            if (s.length() == 0 || s.length() == 1) return true;
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                if (lc == rc) {
                    l++;
                    r--;
                    continue;
                }
                if (!(lc >= ASCLL_0 && lc <= ASCLL_9 || lc >= ASCLL_a && lc <= ASCLL_z || lc >= ASCLL_A && lc <= ASCLL_Z)) {
                    l++;
                    continue;
                }
                if (!(rc >= ASCLL_0 && rc <= ASCLL_9 || rc >= ASCLL_a && rc <= ASCLL_z || rc >= ASCLL_A && rc <= ASCLL_Z)) {
                    r--;
                    continue;
                }
                if (lc >= ASCLL_A && lc <= ASCLL_Z) lc = (char) (lc + 32);
                if (rc >= ASCLL_A && rc <= ASCLL_Z) rc = (char) (rc + 32);
                if (lc != rc) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}