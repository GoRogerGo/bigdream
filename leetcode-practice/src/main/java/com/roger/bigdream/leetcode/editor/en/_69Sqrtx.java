package com.roger.bigdream.leetcode.editor.en;
//Given a non-negative integer x, return the square root of x rounded down to th
//e nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down to
// the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics Math Binary Search 
// 👍 6011 👎 3926

public class _69Sqrtx {

    public static void main(String[] args) {
        Solution solution = new _69Sqrtx().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:40.6 MB,击败了14.16% 的Java用户
         * 2023年03月13日17:40:11
         * 注意点：①循环条件是l <= r（小于等于），②判断条件是mid > x / mid ③有终止条件是mid-1
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            int l = 1;
            int r = x;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mid > x / mid) r = mid - 1;
                else l = mid + 1;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}