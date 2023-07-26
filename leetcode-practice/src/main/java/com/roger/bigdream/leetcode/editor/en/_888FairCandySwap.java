package com.roger.bigdream.leetcode.editor.en;
//Alice and Bob have a different total number of candies. You are given two inte
//ger arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies 
//of the ith box of candy that Alice has and bobSizes[j] is the number of candies 
//of the jth box of candy that Bob has. 
//
// Since they are friends, they would like to exchange one candy box each so tha
//t after the exchange, they both have the same total amount of candy. The total a
//mount of candy a person has is the sum of the number of candies in each box they
// have. 
//
// Return an integer array answer where answer[0] is the number of candies in th
//e box that Alice must exchange, and answer[1] is the number of candies in the bo
//x that Bob must exchange. If there are multiple answers, you may return any one 
//of them. It is guaranteed that at least one answer exists. 
//
// 
// Example 1: 
//
// 
//Input: aliceSizes = [1,1], bobSizes = [2,2]
//Output: [1,2]
// 
//
// Example 2: 
//
// 
//Input: aliceSizes = [1,2], bobSizes = [2,3]
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: aliceSizes = [2], bobSizes = [1,3]
//Output: [2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= aliceSizes.length, bobSizes.length <= 104 
// 1 <= aliceSizes[i], bobSizes[j] <= 105 
// Alice and Bob have a different total number of candies. 
// There will be at least one valid answer for the given input. 
// 
// Related Topics Array Hash Table Binary Search Sorting 
// 👍 1899 👎 338

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _888FairCandySwap {

    public static void main(String[] args) {
        Solution solution = new _888FairCandySwap().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功:
         * 执行耗时:19 ms,击败了41.98% 的Java用户
         * 内存消耗:45.9 MB,击败了5.05% 的Java用户
         * <p>
         * 2023年07月26日21:07:17
         * 看的官方答案，下次再写
         *
         * @param aliceSizes
         * @param bobSizes
         * @return
         */
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
            int countAlice = Arrays.stream(aliceSizes).sum();
            int countBob = Arrays.stream(bobSizes).sum();
            int gap = (countAlice - countBob) / 2;
            Set<Integer> setAlice = new HashSet<>();
            for (int aliceSize : aliceSizes) {
                setAlice.add(aliceSize);
            }
            int[] result = new int[2];
            for (int bobSize : bobSizes) {
                int aim = gap + bobSize;
                if (setAlice.contains(aim)) {
                    result[0] = aim;
                    result[1] = bobSize;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}