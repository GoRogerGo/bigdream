//Write a function to find the longest common prefix string amongst an array of
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String


package com.roger.bigdream.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
//        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
//        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "dog", "dog"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"leetcode", "leet", "lee", "ley", "leu", "let"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            return divideAndConquer(strs);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:2 ms, faster than 35.36% of Java online submissions.
     * Memory Usage:37.3 MB, less than 91.64% of Java online submissions.
     *
     * @param strs
     * @return
     */
    private String divideAndConquer(String[] strs) {
        if (strs.length == 0) return "";
        return partOf(strs, 0, strs.length - 1);
    }

    private String partOf(String[] strs, int left, int right) {
        if (left >= right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String leftStr = partOf(strs, left, mid);
            String rightStr = partOf(strs, mid + 1, right);
            return commonPrefix(leftStr, rightStr);
        }
    }

    private String commonPrefix(String leftStr, String rightStr) {
        int length = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < length; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, length);
    }

    /**
     * Runtime:0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage:37.7 MB, less than 53.71% of Java online submissions.
     *
     * @param strs
     * @return
     */
    private String horizontalScanning(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * Runtime:4 ms, faster than 23.48% of Java online submissions.
     * Memory Usage:39.2 MB, less than 19.63% of Java online submissions.
     * <p>
     * 调用了compare方法，当方法的返回值大于0的时候就将数组的前一个数和后一个数做交换。
     * compare a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     *
     * @param strs
     * @return
     */
    private String myApproach(String[] strs) {
        String prefix = "";
        if (strs.length == 0) return prefix;
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) return -1;
                else if (o1.length() > o2.length()) return 1;
                else return o1.compareTo(o2);
            }
        });

        for (Character c : strs[0].toCharArray()) {
            prefix += c;
            for (int i = 1; i < strs.length; i++) {
                if (!prefix.equals(strs[i].substring(0, prefix.length()))) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }
}