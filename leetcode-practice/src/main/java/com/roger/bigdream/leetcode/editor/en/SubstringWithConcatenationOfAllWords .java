//You are given a string, s, and a list of words, words, that are all of the sam
//e length. Find all starting indices of substring(s) in s that is a concatenation
// of each word in words exactly once and without any intervening characters. 
//
// 
//
// Example 1: 
//
// 
//Input:
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" re
//spectively.
//The output order does not matter, returning [9,0] is fine too.
// 
//
// Example 2: 
//
// 
//Input:
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//Output: []
// 
// Related Topics Hash Table Two Pointers String 
// 👍 860 👎 1241


package com.roger.bigdream.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 按全排列的思路做一遍
         *
         * Wrong Answer:
         * input:"foobarfoobar"
         * ["foo","bar"]
         * Output:[0,3]
         * Expected:[0,3,6]
         *
         * @param s
         * @param words
         * @return
         */
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();

            List<String> ansSpace = new ArrayList<>();
            List<String> ans = new ArrayList<>(words.length);
            for (int i = 0; i < words.length; i++) {
                ans.add("");
            }
            List<Boolean> used = new ArrayList<>(words.length);
            for (int i = 0; i < words.length; i++) {
                used.add(false);
            }

            dfs(0, ansSpace, words, ans, used);

            for (String ans0 : ansSpace) {
                if (s.indexOf(ans0) >= 0) {
                    res.add(s.indexOf(ans0));
                }
            }
            return res;
        }

        private void dfs(int curPos, List<String> ansSpace, String[] words, List<String> ans, List<Boolean> used) {
            if (curPos == words.length) {
                String an = "";
                for (String a : ans) {
                    an += a;
                }
                if (!ansSpace.contains(an)) {
                    ansSpace.add(an);
                }
                return;
            }
            for (int i = 0; i < words.length; i++) {
                if (!used.get(i)) {
                    used.set(i, true);
                    ans.set(curPos, words[i]);
                    dfs(curPos + 1, ansSpace, words, ans, used);
                    used.set(i, false);
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:234 ms, faster than 26.70% of Java online submissions.
     * Memory Usage:39.9 MB, less than 78.32% of Java online submissions.
     *
     * @param s
     * @param words
     * @return
     */
    private List<Integer> myApproach(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if ("".equals(s) || words.length == 0) return res;

        int length = s.length();
        int unitSize = words[0].length();
        int searchLength = length - words.length * unitSize + 1;

        Map<String, Integer> map = new HashMap<>();
        initMap(words, map);

        for (int i = 0; i < searchLength; i++) {
            // s包含的字符串必须是words里的
            for (int j = 0; j < words.length; j++) {
                int index = i + j * unitSize;
                String s0 = s.substring(index, index + unitSize);
                Integer hitCount = map.get(s0);
                if (null == hitCount) break;
                map.put(s0, hitCount - 1);
            }
            if (hitAllWords(map)) {
                res.add(i);
            }
            map = new HashMap<>();
            initMap(words, map);
        }
        return res;
    }

    private boolean hitAllWords(Map<String, Integer> map) {
        return map.values().stream().allMatch(entry -> entry.compareTo(0) == 0);
    }

    private void initMap(String[] words, Map<String, Integer> map) {
        for (String word : words) {
            Integer count = map.get(word);
            if (null == count) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }
    }
}