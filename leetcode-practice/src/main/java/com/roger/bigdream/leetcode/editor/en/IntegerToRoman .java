//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, two is written as II in Roman numeral, just two one's added toge
//ther. Twelve is written as, XII, which is simply X + II. The number twenty seven
// is written as XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. Input is guaranteed to be wi
//thin the range from 1 to 3999. 
//
// Example 1: 
//
// 
//Input: 3
//Output: "III" 
//
// Example 2: 
//
// 
//Input: 4
//Output: "IV" 
//
// Example 3: 
//
// 
//Input: 9
//Output: "IX" 
//
// Example 4: 
//
// 
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics Math String


package com.roger.bigdream.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        solution.intToRoman(3);
        solution.intToRoman(4);
        solution.intToRoman(9);
        solution.intToRoman(58);
        solution.intToRoman(1994);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * myApproach is better!
         */
        /**
         * Runtime:14 ms, faster than 20.76% of Java online submissions.
         * Memory Usage:39.7 MB, less than 38.93% of Java online submissions.
         *
         * @param num
         * @return
         */
        public String intToRoman(int num) {
            String[] I = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            String[] X = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] C = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] M = new String[]{"", "M", "MM", "MMM"};
            String result = M[num / 1000] + C[num / 100 % 10] + X[num / 10 % 10] + I[num % 10];
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:7 ms, faster than 41.44% of Java online submissions.
     * Memory Usage:39.5 MB, less than 46.23% of Java online submissions.
     *
     * @param num
     * @return
     */
    private String myApproach(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] rule = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String result = "";
        for (int i = 0; i < rule.length; i++) {
            if (num < rule[i]) {
                continue;
            }
            while (num >= rule[i]) {
                num -= rule[i];
                result += map.get(rule[i]);
            }
        }
        return result;
    }
}