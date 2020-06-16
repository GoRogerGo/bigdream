//Implement atoi which converts a string to an integer.
//
// The function first discards as many whitespace characters as necessary until 
//the first non-whitespace character is found. Then, starting from this character,
// takes an optional initial plus or minus sign followed by as many numerical digi
//ts as possible, and interprets them as a numerical value. 
//
// The string can contain additional characters after those that form the integr
//al number, which are ignored and have no effect on the behavior of this function
//. 
//
// If the first sequence of non-whitespace characters in str is not a valid inte
//gral number, or if no such sequence exists because either str is empty or it con
//tains only whitespace characters, no conversion is performed. 
//
// If no valid conversion could be performed, a zero value is returned. 
//
// Note: 
//
// 
// Only the space character ' ' is considered as whitespace character. 
// Assume we are dealing with an environment which could only store integers wit
//hin the 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is 
//out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is
// returned. 
// 
//
// Example 1: 
//
// 
//Input: "42"
//Output: 42
// 
//
// Example 2: 
//
// 
//Input: "   -42"
//Output: -42
//Explanation: The first non-whitespace character is '-', which is the minus sig
//n.
//             Then take as many numerical digits as possible, which gets 42.
// 
//
// Example 3: 
//
// 
//Input: "4193 with words"
//Output: 4193
//Explanation: Conversion stops at digit '3' as the next character is not a nume
//rical digit.
// 
//
// Example 4: 
//
// 
//Input: "words and 987"
//Output: 0
//Explanation: The first non-whitespace character is 'w', which is not a numeric
//al 
//             digit or a +/- sign. Therefore no valid conversion could be perfo
//rmed. 
//
// Example 5: 
//
// 
//Input: "-91283472332"
//Output: -2147483648
//Explanation: The number "-91283472332" is out of the range of a 32-bit signed 
//integer.
//             Thefore INT_MIN (−231) is returned. 
// Related Topics Math String


package com.roger.bigdream.leetcode.editor.en;

class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        solution.myAtoi("42");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            if ("".equals(str)) return 0;

            int index = 0;
            int sign = 1;
            if (str.charAt(0) == '-') {
                sign = -1;
                index = 1;
            } else if (str.charAt(0) == '+') {
                sign = 1;
                index = 1;
            } else if (!Character.isDigit(str.charAt(0))) {
                return 0;
            }

            long num = 0;
            for (int i = index; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    break;
                }
                num = num * 10 + str.charAt(i) - '0';
                if (num > Integer.MAX_VALUE) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            return (int) num * sign;
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)
    private int myApproach(String str) {
        if (null == str || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        char fisrtChar = str.charAt(0);
        if (!(fisrtChar == 43 || fisrtChar == 45 || fisrtChar >= 48
                && fisrtChar <= 57)) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fisrtChar);
        for (char c : str.substring(1).toCharArray()) {
            if (c >= 48 && c <= 57) {
                stringBuilder.append(c);
            } else {
                break;
            }
        }
        str = stringBuilder.toString();
        if ("+".equals(str) || "-".equals(str)) {
            return 0;
        }
        if (Double.valueOf(str) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (Double.valueOf(str) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return Integer.valueOf(str);
    }
}