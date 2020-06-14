//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


package com.roger.bigdream.leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
//        solution.lengthOfLongestSubstring("abcabcbb");
        solution.lengthOfLongestSubstring("tmmzuxt");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if ("".equals(s)) return 0;
            // key:出现的元素 value:该元素最后出现的位置
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int count = 0;
            for (int i = 0, j = 0; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)) + 1, i);
                }
                if (j - i > count) count = j - i;
                map.put(s.charAt(j), j);
            }
            return count + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * Brute Force
     * 986 / 987 test cases passed.
     *
     * @param s
     * @return
     */
    private int myApproach(String s) {
        if (s.length() == 1) return 1;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (unique(s, i, j) && j - i > count) {
                    count = j - i;
                }
            }
        }
        return count;
    }

    private boolean unique(String s, int i, int j) {
        Set<Character> set = new HashSet<Character>();
        for (int k = i; k < j; k++) {
            if (set.contains(s.charAt(k))) {
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }

    /**
     * Runtime:43 ms, faster than 16.69% of Java online submissions.
     * Memory Usage:47.3 MB, less than 5.02% of Java online submissions.
     *
     * @param s
     * @return
     */
    private int myApproach1(String s) {
        int count = 0;
        StringBuilder storeage = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 字符未出现过，则将该字符放入变量storeage中
            if (storeage.indexOf(String.valueOf(c)) < 0) {
                storeage.append(c);
                if (count < storeage.length()) {
                    System.out.println(storeage.toString());
                    count = storeage.length();
                }
            } else {
                // 字符出现过，则删除区间[0，最近出现的相同字符]，并加上当前字符
                storeage.delete(0, storeage.lastIndexOf(String.valueOf(c)) + 1);
                storeage.append(c);
            }
        }
        return count;
    }

}