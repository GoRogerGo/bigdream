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
// Given a roman numeral, convert it to an integer. Input is guaranteed to be wi
//thin the range from 1 to 3999. 
//
// Example 1: 
//
// 
//Input: "III"
//Output: 3 
//
// Example 2: 
//
// 
//Input: "IV"
//Output: 4 
//
// Example 3: 
//
// 
//Input: "IX"
//Output: 9 
//
// Example 4: 
//
// 
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
// Related Topics Math String


package com.roger.bigdream.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        solution.romanToInt("III");
        solution.romanToInt("IV");
        solution.romanToInt("IX");
        solution.romanToInt("LVIII");
        solution.romanToInt("MCMXCIV");
        solution.romanToInt("DCXXI");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:5 ms, faster than 64.88% of Java online submissions.
         * Memory Usage:40 MB, less than 41.87% of Java online submissions.
         *
         * @param s
         * @return
         */
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result += map.get(s.charAt(i));
                if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                    result -= 2 * map.get(s.charAt(i - 1));
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:7 ms, faster than 26.69% of Java online submissions.
     * Memory Usage:40 MB, less than 47.91% of Java online submissions.
     *
     * @param s
     * @return
     */
    private int myApproach(String s) {
        int result = 0;
        if ("".equals(s)) return result;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2));
                i++;
                continue;
            }
            if (map.containsKey(s.substring(i, i + 1))) {
                result += map.get(s.substring(i, i + 1));
                continue;
            }
        }

        if (result == 0) throw new RuntimeException("输入异常");
        return result;
    }
}