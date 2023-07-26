package com.roger.bigdream.leetcode.editor.en;
//Alice has n candies, where the ith candy is of type candyType[i]. Alice notice
//d that she started to gain weight, so she visited a doctor. 
//
// The doctor advised Alice to only eat n / 2 of the candies she has (n is alway
//s even). Alice likes her candies very much, and she wants to eat the maximum num
//ber of different types of candies while still following the doctor's advice. 
//
// Given the integer array candyType of length n, return the maximum number of d
//ifferent types of candies she can eat if she only eats n / 2 of them. 
//
// 
// Example 1: 
//
// 
//Input: candyType = [1,1,2,2,3,3]
//Output: 3
//Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 type
//s, she can eat one of each type.
// 
//
// Example 2: 
//
// 
//Input: candyType = [1,1,2,3]
//Output: 2
//Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2
//], [1,3], or [2,3], she still can only eat 2 different types.
// 
//
// Example 3: 
//
// 
//Input: candyType = [6,6,6,6]
//Output: 1
//Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 c
//andies, she only has 1 type.
// 
//
// 
// Constraints: 
//
// 
// n == candyType.length 
// 2 <= n <= 104 
// n is even. 
// -105 <= candyType[i] <= 105 
// 
// Related Topics Array Hash Table 
// 👍 1347 👎 1284

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _575DistributeCandies {

    public static void main(String[] args) {
        Solution solution = new _575DistributeCandies().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功:
         * 执行耗时:41 ms,击败了21.46% 的Java用户
         * 内存消耗:44.7 MB,击败了63.57% 的Java用户
         *
         * 2023年07月26日20:50:48
         * 比较巧妙
         * @param candies
         * @return
         */
        public int distributeCandies(int[] candies) {
            Arrays.sort(candies);
            int count = 1;
            for (int i = 1; i < candies.length && count < candies.length / 2; i++)
                if (candies[i] > candies[i - 1])
                    count++;
            return count;
        }

        /**
         * 解答成功:
         * 执行耗时:36 ms,击败了75.88% 的Java用户
         * 内存消耗:44.8 MB,击败了49.66% 的Java用户
         * 2023年07月26日20:49:28
         *
         * @param candies
         * @return
         */
        public int distributeCandies_bySet(int[] candies) {
            HashSet<Integer> set = new HashSet<>();
            for (int candy : candies) {
                set.add(candy);
            }
            return Math.min(set.size(), candies.length / 2);
        }

        /**
         * 解答成功:
         * 执行耗时:49 ms,击败了10.33% 的Java用户
         * 内存消耗:44 MB,击败了99.57% 的Java用户
         * <p>
         * 2023年07月26日20:47:32
         * 一遍过
         *
         * @param candyType
         * @return
         */
        public int distributeCandies_myself(int[] candyType) {
            if (candyType.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : candyType) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            return Math.min(candyType.length / 2, map.size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}