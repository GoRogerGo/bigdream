//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string. 
//
// Example 1: 
//
// 
//Input: num1 = "2", num2 = "3"
//Output: "6" 
//
// Example 2: 
//
// 
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
// Note: 
//
// 
// The length of both num1 and num2 is < 110. 
// Both num1 and num2 contain only digits 0-9. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f. 
// You must not use any built-in BigInteger library or convert the inputs to int
//eger directly. 
// 
// Related Topics Math String 
// 👍 1823 👎 823


package com.roger.bigdream.leetcode.editor.en;

class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("92", "94"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:7 ms, faster than 47.95% of Java online submissions.
         * Memory Usage:39.9 MB, less than 34.49% of Java online submissions.
         *
         * @param num1
         * @param num2
         * @return
         */
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int m = num1.length(), n = num2.length();
            int[] res = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int a = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int b = num2.charAt(j) - '0';
                    res[i + j + 1] += a * b;
                    res[i + j] += res[i + j + 1] / 10;
                    res[i + j + 1] %= 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (res[i] == 0) {
                i++;
            }
            for (; i < res.length; i++) {
                sb.append(res[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}