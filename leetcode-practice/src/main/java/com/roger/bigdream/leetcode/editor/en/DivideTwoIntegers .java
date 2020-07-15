//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Note: 
//
// 
// Both dividend and divisor will be 32-bit signed integers. 
// The divisor will never be 0. 
// Assume we are dealing with an environment which could only store integers wit
//hin the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pr
//oblem, assume that your function returns 231 − 1 when the division result overfl
//ows. 
// 
// Related Topics Math Binary Search 
// 👍 1190 👎 5242


package com.roger.bigdream.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
//        solution.divide(10, 3);
//        solution.divide(7, -3);
//        solution.divide(1, 1);
        solution.divide(-2147483648, -1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:3 ms, faster than 26.21% of Java online submissions.
         * Memory Usage:36.8 MB, less than 56.35% of Java online submissions.
         *
         * @param dividend
         * @param divisor
         * @return
         */
        public int divide(int dividend, int divisor) {
            long d1 = dividend;
            long d2 = divisor;
            if (dividend < 0) d1 = -d1;
            if (divisor < 0) d2 = -d2;
            long beiVal = d2;
            long bei = 1;
            List<Long> list1 = new ArrayList<>();
            List<Long> list2 = new ArrayList<>();
            while (beiVal <= d1) {
                list1.add(beiVal);
                beiVal += beiVal;
                list2.add(bei);
                bei += bei;
            }

            long res = 0;
            for (int i = list1.size() - 1; i >= 0; i--) {
                long val = list1.get(i);
                if (d1 >= val) {
                    res += list2.get(i);
                    d1 -= val;
                }
            }

            if (dividend < 0 && divisor > 0) res = -res;
            if (dividend > 0 && divisor < 0) res = -res;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = Integer.MAX_VALUE;

            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}