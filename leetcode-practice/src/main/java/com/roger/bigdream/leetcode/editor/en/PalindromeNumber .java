//Determine whether an integer is a palindrome. An integer is a palindrome when
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics Math


package com.roger.bigdream.leetcode.editor.en;

class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        solution.isPalindrome(121);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
                return false;
            }
            if (x < 10) return true;

            int reverse = 0;
            int y = x;
            while (true) {
                reverse = reverse * 10 + y % 10;
                y = y / 10;
                if (y < 1) {
                    break;
                }
            }
            return reverse == x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}