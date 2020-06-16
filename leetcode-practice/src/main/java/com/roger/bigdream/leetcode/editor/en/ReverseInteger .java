//Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math


package com.roger.bigdream.leetcode.editor.en;

class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
            }
            return rev;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    private int myApproach(int x) {
        int result = 0;
        int tmp = Math.abs(x);
        StringBuilder builder = new StringBuilder();
        while (tmp / 10 > 0) {
            builder.append(tmp % 10);
            tmp = tmp / 10;
        }
        builder.append(tmp);
        // 倒转数字
        if (Long.valueOf(builder.toString()) >= Integer.MAX_VALUE || Long.valueOf(builder.toString()) <= Integer.MIN_VALUE) {
            return 0;
        }
        result = x > 0 ? Integer.valueOf(builder.toString()) : -Integer.valueOf(builder.toString());
        return result;
    }
}