package com.roger.bigdream.leetcode.editor.en;
//Given an integer x, return true if x is a palindrome, and false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string? Rela
//ted Topics Math 
// 👍 9076 👎 2452

public class _9PalindromeNumber {

    public static void main(String[] args) {
        Solution solution = new _9PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:9 ms,击败了97.69% 的Java用户 内存消耗:41.9 MB,击败了48.26% 的Java用户
         *
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0 || (x != 0 && x % 10 == 0)) return false;
            int rev = 0;
            while (x > rev) {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            return (x == rev || x == rev / 10);
        }

        /**
         * 解答成功: 执行耗时:11 ms,击败了30.27% 的Java用户 内存消耗:41.8 MB,击败了56.66% 的Java用户
         * 2023年03月21日20:26:27
         * 自己的答案，和前列的答案差距2ms，认为是ok的吧
         *
         * @param x
         * @return
         */
        public boolean isPalindrome_myself(int x) {
            if (x >= 0 && x < 10) return true;
            if (x < 0) return false;

            int length = 0;
            int m = x;
            while (m > 0) {
                length++;
                m = m / 10;
            }

            int[] a = new int[length];
            parsex(a, 0, x);

            int l = 0;
            int r = a.length - 1;
            while (l < r) {
                if (a[l] != a[r]) return false;
                l++;
                r--;
            }
            return true;
        }

        private void parsex(int[] a, int i, int x) {
            if (x < 1) return;
            int mod = x % 10;
            a[i++] = mod;
            parsex(a, i, (x - mod) / 10);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}