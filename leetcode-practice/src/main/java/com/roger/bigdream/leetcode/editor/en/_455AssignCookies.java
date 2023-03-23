package com.roger.bigdream.leetcode.editor.en;
//Assume you are an awesome parent and want to give your children some cookies. 
//But, you should give each child at most one cookie. 
//
// Each child i has a greed factor g[i], which is the minimum size of a cookie t
//hat the child will be content with; and each cookie j has a size s[j]. If s[j] >
//= g[i], we can assign the cookie j to the child i, and the child i will be conte
//nt. Your goal is to maximize the number of your content children and output the 
//maximum number. 
//
// 
// Example 1: 
//
// 
//Input: g = [1,2,3], s = [1,1]
//Output: 1
//Explanation: You have 3 children and 2 cookies. The greed factors of 3 childre
//n are 1, 2, 3. 
//And even though you have 2 cookies, since their size is both 1, you could only
// make the child whose greed factor is 1 content.
//You need to output 1.
// 
//
// Example 2: 
//
// 
//Input: g = [1,2], s = [1,2,3]
//Output: 2
//Explanation: You have 2 children and 3 cookies. The greed factors of 2 childre
//n are 1, 2. 
//You have 3 cookies and their sizes are big enough to gratify all of the childr
//en, 
//You need to output 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= g.length <= 3 * 104 
// 0 <= s.length <= 3 * 104 
// 1 <= g[i], s[j] <= 231 - 1 
// 
// Related Topics Array Two Pointers Greedy Sorting 
// 👍 2143 👎 210

import java.util.Arrays;

public class _455AssignCookies {

    public static void main(String[] args) {
        Solution solution = new _455AssignCookies().new Solution();
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:8 ms,击败了87.57% 的Java用户 内存消耗:44.1 MB,击败了14.67% 的Java用
         * 2023年03月23日11:05:21
         * 自己的答案，一次过
         *
         * @param g
         * @param s
         * @return
         */
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int res = 0;
            int glen = g.length;
            int slen = s.length;
            while (glen > 0 && slen > 0) {
                if (s[slen - 1] >= g[glen - 1]) {
                    res++;
                    slen--;
                    glen--;
                } else {
                    glen--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}