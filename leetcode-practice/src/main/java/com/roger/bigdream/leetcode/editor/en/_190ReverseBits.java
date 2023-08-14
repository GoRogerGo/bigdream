package com.roger.bigdream.leetcode.editor.en;
//Reverse bits of a given 32 bits unsigned integer. 
//
// Note: 
//
// 
// Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type. The
//y should not affect your implementation, as the integer's internal binary repres
//entation is the same, whether it is signed or unsigned. 
// In Java, the compiler represents the signed integers using 2's complement not
//ation. Therefore, in Example 2 above, the input represents the signed integer -3
// and the output represents the signed integer -1073741825. 
// 
//
// 
// Example 1: 
//
// 
//Input: n = 00000010100101000001111010011100
//Output:    964176192 (00111001011110000010100101000000)
//Explanation: The input binary string 00000010100101000001111010011100 represen
//ts the unsigned integer 43261596, so return 964176192 which its binary represent
//ation is 00111001011110000010100101000000.
// 
//
// Example 2: 
//
// 
//Input: n = 11111111111111111111111111111101
//Output:   3221225471 (10111111111111111111111111111111)
//Explanation: The input binary string 11111111111111111111111111111101 represen
//ts the unsigned integer 4294967293, so return 3221225471 which its binary repres
//entation is 10111111111111111111111111111111.
// 
//
// 
// Constraints: 
//
// 
// The input must be a binary string of length 32 
// 
//
// 
// Follow up: If this function is called many times, how would you optimize it? 
//
// Related Topics Divide and Conquer Bit Manipulation 
// 👍 4615 👎 1208

public class _190ReverseBits {

    public static void main(String[] args) {
        Solution solution = new _190ReverseBits().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value

        /**
         * 将n视作一个长为32的二进制串，从低位往高位枚举n的每一位，将其倒序添加到翻转结果rev中。
         * 代码实现中，每枚举一位就将n右移一位，这样当前n的最低位就是我们要枚举的比特位。当n为0时即可结束循环。
         *
         * @param n
         * @return
         */
        public int reverseBits(int n) {
            int rev = 0;
            for (int i = 0; i < 32 && n != 0; ++i) {
                rev |= (n & 1) << (31 - i);
                n >>>= 1;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}