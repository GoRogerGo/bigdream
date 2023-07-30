package com.roger.bigdream.leetcode.editor.en;
//The distance of a pair of integers a and b is defined as the absolute differen
//ce between a and b. 
//
// Given an integer array nums and an integer k, return the kth smallest distanc
//e among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,1], k = 1
//Output: 0
//Explanation: Here are all the pairs:
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//Then the 1st smallest distance pair is (1,1), and its distance is 0.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1], k = 2
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1,6,1], k = 3
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 104 
// 0 <= nums[i] <= 106 
// 1 <= k <= n * (n - 1) / 2 
// 
// Related Topics Array Two Pointers Binary Search Sorting 
// 👍 2573 👎 80

import java.util.Arrays;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _719FindKThSmallestPairDistance {

    public static void main(String[] args) {
        Solution solution = new _719FindKThSmallestPairDistance().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 完全抄的，不懂第二个while循环的含义
         * 2023年03月17日15:00:38
         * 解答成功: 执行耗时:8 ms,击败了31.69% 的Java用户 内存消耗:43.6 MB,击败了86.01% 的Java用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
            while (left <= right) {
                int mid = (left + right) / 2;
                int cnt = calcDistance(nums, n, mid);
                if (cnt >= k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 给定距离mid，计算所有距离小于等于mid的数对数目cnt可以使用双指针：
         * 初始左端点i=0，我们从小到大枚举所有数对的右端点j，移动左端点直到nums[j]−nums[i]≤mid，那么右端点为j且距离小于等于mid的数对数目为j−i，计算这些数目之和。
         *
         * @param nums
         * @param n
         * @param mid
         * @return
         */
        private int calcDistance(int[] nums, int n, int mid) {
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}