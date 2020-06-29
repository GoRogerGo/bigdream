//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers


package com.roger.bigdream.leetcode.editor.en;

import java.util.*;

class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
//        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        solution.fourSum(new int[]{0, 0, 0, 0}, 0);
//        solution.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 0);
//        solution.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
        solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            return myApproachBaseOn3Sum(nums, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    Set<List<Integer>> result = new HashSet<>();

    /**
     * Runtime:106 ms, faster than 6.98% of Java online submissions.
     * Memory Usage:42.2 MB, less than 6.73% of Java online submissions.
     *
     * @param nums
     * @param target
     * @return
     */
    private List<List<Integer>> myApproachBaseOn3Sum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>(result);
        if (nums.length == 4 && nums[0] + nums[1] + nums[2] + nums[3] == target) {
            result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return new ArrayList<>(result);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            threeSum(nums, i, target - nums[i]);
        }

        return new ArrayList<>(result);
    }

    private void threeSum(int[] nums, int i, int target) {

        for (int j = 0; j < nums.length - 1; j++) {
            if (j == i) continue;

            int left = j + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (i == left) {
                    left++;
                    continue;
                }
                if (i == right) {
                    right--;
                    continue;
                }

                int gap = nums[j] + nums[left] + nums[right] - target;
                if (gap == 0) {
                    result.add(sortFourNums(nums[i], nums[j], nums[left], nums[right]));

                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (gap > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }

    private List<Integer> sortFourNums(int num0, int num1, int num2, int num3) {
        Integer[] nums = new Integer[]{num0, num1, num2, num3};
        Arrays.sort(nums);
        return Arrays.asList(nums);
    }

}