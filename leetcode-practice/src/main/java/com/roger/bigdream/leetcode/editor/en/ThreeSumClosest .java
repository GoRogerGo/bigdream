//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
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
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers


package com.roger.bigdream.leetcode.editor.en;

import java.util.Arrays;

class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            return twoPointerAccelerate(nums, target);
        }

        /**
         * Runtime:10 ms, faster than 21.48% of Java online submissions.
         * Memory Usage:39.1 MB, less than 62.39% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        private int binarySearch(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length && diff != 0; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int complement = target - nums[i] - nums[j];
                    int idx = Arrays.binarySearch(nums, j + 1, nums.length - 1, complement);
                    int hi = idx >= 0 ? idx : ~idx;
                    int lo = hi - 1;
                    if (hi < nums.length && Math.abs(complement - nums[hi]) < Math.abs(diff)) {
                        diff = complement - nums[hi];
                    }
                    if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
                        diff = complement - nums[lo];
                }
            }
            return target - diff;
        }


        /**
         * Runtime:6 ms, faster than 49.71% of Java online submissions.
         * Memory Usage:39.2 MB, less than 48.95% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        private int twoPointer(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (i >= 1 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - sum) < Math.abs(diff)) {
                        diff = target - sum;
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return target - diff;
        }


        /**
         * Runtime:5 ms, faster than 57.30% of Java online submissions.
         * Memory Usage:38.7 MB, less than 94.47% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        private int twoPointerAccelerate(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                if (i >= 1 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = nums.length - 1;

                if (nums[i] + nums[right - 1] + nums[right] <= target) {
                    left = right - 1;
                }
                if (nums[i] + nums[left] + nums[left + 1] >= target) {
                    right = left + 1;
                }

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - sum) < Math.abs(diff)) {
                        diff = target - sum;
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return target - diff;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}