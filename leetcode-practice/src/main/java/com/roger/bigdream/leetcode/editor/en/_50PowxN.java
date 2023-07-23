package com.roger.bigdream.leetcode.editor.en;
//Implement pow(x, n), which calculates x raised to the power n (i.e., xn). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n is an integer. 
// Either x is not zero or n > 0. 
// -104 <= xn <= 104 
// 
// Related Topics Math Recursion 
// 👍 7733 👎 7848

public class _50PowxN {

    public static void main(String[] args) {
        Solution solution = new _50PowxN().new Solution();
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2, 3));
        System.out.println(solution.myPow(2, -2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 解答成功:
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:40.7 MB,击败了75.82% 的Java用户
         * 别人的做法，2023年07月23日10:56:58
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {

            if (n == 0)
                return 1.0;

            if (n % 2 == 1)
                return x * myPow(x, n - 1);

            if (n % 2 == 0)
                return myPow(x * x, n / 2);

            return 1 / myPow(x, -n);
        }


        /**
         * 我的超时答案
         * 2023年07月23日10:49:21
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow_TimeLimitExceed(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n > 0) {
                return myPow0_TimeLimitExceed(x, n);
            } else {
                return 1 / myPow0_TimeLimitExceed(x, Math.abs(n));
            }
        }

        private double myPow0_TimeLimitExceed(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            return x * myPow0_TimeLimitExceed(x, n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}