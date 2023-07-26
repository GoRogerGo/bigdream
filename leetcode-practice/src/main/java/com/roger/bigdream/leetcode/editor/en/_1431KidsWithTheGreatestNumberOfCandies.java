package com.roger.bigdream.leetcode.editor.en;
//There are n kids with candies. You are given an integer array candies, where e
//ach candies[i] represents the number of candies the ith kid has, and an integer 
//extraCandies, denoting the number of extra candies that you have. 
//
// Return a boolean array result of length n, where result[i] is true if, after 
//giving the ith kid all the extraCandies, they will have the greatest number of c
//andies among all the kids, or false otherwise. 
//
// Note that multiple kids can have the greatest number of candies. 
//
// 
// Example 1: 
//
// 
//Input: candies = [2,3,5,1,3], extraCandies = 3
//Output: [true,true,true,false,true] 
//Explanation: If you give all extraCandies to:
//- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kid
//s.
//- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kid
//s.
//- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kid
//s.
//- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the
// kids.
//- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kid
//s.
// 
//
// Example 2: 
//
// 
//Input: candies = [4,2,1,1,2], extraCandies = 1
//Output: [true,false,false,false,false] 
//Explanation: There is only 1 extra candy.
//Kid 1 will always have the greatest number of candies, even if a different kid
// is given the extra candy.
// 
//
// Example 3: 
//
// 
//Input: candies = [12,1,12], extraCandies = 10
//Output: [true,false,true]
// 
//
// 
// Constraints: 
//
// 
// n == candies.length 
// 2 <= n <= 100 
// 1 <= candies[i] <= 100 
// 1 <= extraCandies <= 50 
// 
// Related Topics Array 
// 👍 3619 👎 434

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1431KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        Solution solution = new _1431KidsWithTheGreatestNumberOfCandies().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功:
         * 执行耗时:2 ms,击败了16.03% 的Java用户
         * 内存消耗:41.6 MB,击败了52.97% 的Java用户
         * 2023年07月26日21:11:02
         * 一遍过
         *
         * @param candies
         * @param extraCandies
         * @return
         */
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = Arrays.stream(candies).max().getAsInt();
            List<Boolean> res = new ArrayList<>();
            for (int candy : candies) {
                res.add(candy + extraCandies >= max);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}