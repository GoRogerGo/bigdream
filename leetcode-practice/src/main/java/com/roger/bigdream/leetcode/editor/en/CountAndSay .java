//The count-and-say sequence is the sequence of integers with the first five ter
//ms as following: 
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 is read off as "one 1" or 11. 
//11 is read off as "two 1s" or 21. 
//21 is read off as "one 2, then one 1" or 1211. 
//
// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-s
//ay sequence. You can do so recursively, in other words from the previous member 
//read off the digits, counting the number of digits in groups of the same digit. 
//
//
// Note: Each term of the sequence of integers will be represented as a string. 
//
//
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: 4
//Output: "1211"
//Explanation: For n = 3 the term was "21" in which we have two groups "2" and "
//1", "2" can be read as "12" which means frequency = 1 and value = 2, the same wa
//y "1" is read as "11", so the answer is the concatenation of "12" and "11" which
// is "1211".
// 
// Related Topics String 
// 👍 1358 👎 9894


package com.roger.bigdream.leetcode.editor.en;

class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        System.out.println(solution.countAndSay(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            if (n == 0) return "";
            if (n == 1) return "1";
            String[] dp = new String[n];
            dp[0] = "1";
            dp[1] = "11";

            for (int i = 2; i < n; i++) {
                String prev = dp[i - 1];
                char[] chars = prev.toCharArray();
                StringBuilder sb = new StringBuilder();
                int count = 1;
                char curr = chars[0];

                for (int j = 1; j < prev.length(); j++) {
                    if (prev.charAt(j) != curr) {
                        sb.append(count);
                        sb.append(curr);
                        curr = prev.charAt(j);
                        count = 1;
                    } else {
                        count++;
                    }
                }
                sb.append(count);
                sb.append(curr);
                dp[i] = sb.toString();
            }

            return dp[n - 1];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private String myApproach(int n) {
        String[] solve = new String[30];
        fill(solve, 0, n);
        return solve[n - 1];
    }

    /**
     * Runtime:32 ms, faster than 7.52% of Java online submissions.
     * Memory Usage:51.7 MB, less than 5.03% of Java online submissions.
     *
     * @param solve
     * @param i
     * @param n
     */
    private void fill(String[] solve, int i, int n) {
        if (i == n) return;

        String cur = i == 0 ? "1" : "";
        if (i > 0) {
            String pre = solve[i - 1];
            int count = 1;
            for (int k = 0; k < pre.length(); k++) {
                if (k + 1 < pre.length() && pre.charAt(k) == pre.charAt(k + 1)) {
                    count++;
                    continue;
                }
                cur += count;
                cur += pre.charAt(k);
                count = 1;
            }
        }
        solve[i] = cur;
        fill(solve, i + 1, n);
    }
}