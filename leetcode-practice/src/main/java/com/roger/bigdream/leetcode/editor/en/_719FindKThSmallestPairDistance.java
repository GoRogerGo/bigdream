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
         *
         * @param nums
         * @param k
         * @return
         */
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int minDist = 0; // minimum distance between 2 numbers is 0 if they are the same
            int maxDist = nums[nums.length - 1] - nums[0]; // max distance in sorted array is leftmost - rightmost element

            // now we have our upper and lower bounds which represent all possible distances between pairs in the input array
            while (minDist <= maxDist) { // time to implement our binary search

                int midDist = minDist + (maxDist - minDist) / 2;
                // (minDist + maxDist)/2 also works but can cause overflow errors in some languages

                // since we want the k-th smallest distance pair we now need to count the number of pairs with a distance
                // greater than midDist so that we can decide how to modify our search space

                int left = 0;
                int right = 0;
                int count = 0;

                while (right < nums.length) {
                    if (nums[right] - nums[left] > midDist) {
                        // if this condition is met then the current number and all numbers to its right will be greater
                        // than midDist fom nums[left] because the array is sorted so we can just increment left
                        left++;
                    } else {
                        count += right - left; // adds the number of pairs between right and left
                        // for example: distance of 0 = 1 pair, distance of 2 = 2 pairs
                        // distance of 3 = 1 + 2 = 3 pairs
                        // distance of 4 = 1 + 2 + 3 = 6 pairs and so on
                        right++;
                    }
                }

                if (count >= k) {
                    // we found too many pairs which means the k-th smallest distance pair must have a distance that is
                    // less than our guess so we remove the lower half of our search space
                    maxDist = midDist - 1;
                } else {
                    // we found too few pairs which means the k-th smallest distance pair must have a distance that is
                    // greater than our guess so we remove the lower half of our search space
                    minDist = midDist + 1;
                }
            }
            return minDist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}