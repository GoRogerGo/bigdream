package com.roger.bigdream.leetcode.editor.en;
//Given an integer array nums of length n and an integer target, find three inte
//gers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 500 
// -1000 <= nums[i] <= 1000 
// -104 <= target <= 104 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 8875 👎 476

import java.util.Arrays;

public class _16ThreeSumClosest {

    public static void main(String[] args) {
        Solution solution = new _16ThreeSumClosest().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:13 ms,击败了90.46% 的Java用户 内存消耗:42.2 MB,击败了46.45% 的Java用户
         * 2023年03月28日20:08:05
         * 注意点：和no15类似，区别在于要注意①根据sum和target的大小关系决定双指针的移动
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            int min = Integer.MAX_VALUE;
            int res = Integer.MIN_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int l = i + 1;
                int r = nums.length - 1;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target) return target;
                    int d = Math.abs(sum - target);
                    if (d < min) {
                        min = d;
                        res = sum;
                    }
                    if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}