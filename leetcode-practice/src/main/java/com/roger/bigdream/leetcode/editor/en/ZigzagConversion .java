//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 
// Related Topics String


package com.roger.bigdream.leetcode.editor.en;

class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;

            StringBuilder[] stringBuilders = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                stringBuilders[i] = new StringBuilder();
            }

            int i = 0;
            boolean goDown = false;
            for (char c : s.toCharArray()) {
                stringBuilders[i].append(c);
                if (i == 0 || i == numRows - 1) goDown = !goDown;
                i += goDown ? 1 : -1;
            }

            String result = "";
            for (StringBuilder stringBuilder : stringBuilders) {
                result += stringBuilder.toString();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private String myApproach(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        // 定义数据结构
        char[][] css = new char[numRows][s.length()];
        // 字符串转换 [i][j]表示第i行第j列，k表示向矩阵中填数的个数
        int i = 0, j = 0, k = 0;
        while (k < s.length()) {
            // 向下走，未到尽头：列不变，行++
            while (i < numRows && k < s.length()) {
                // 如果当前位置已设有字符，则自动向下走一位
                if (css[i][j] != '\u0000') {
                    i++;
                }
                css[i][j] = s.charAt(k);
                i++;
                k++;
            }
            // 向下走到尽头，将行号设为numRows - 1
            i = numRows - 1;
            // 向右上走，未到尽头：列++，行--
            while (i > 0 && k < s.length()) {
                i--;
                j++;
                css[i][j] = s.charAt(k);
                k++;
            }
        }
        // 生成变形后的字符串
        for (char[] cs : css) {
            for (char c : cs) {
                if (c != '\u0000') {
                    builder.append(c);
                }
            }

        }
        return builder.toString();
    }
}