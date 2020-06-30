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
        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        solution.fourSum(new int[]{0, 0, 0, 0}, 0);
        solution.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 0);
        solution.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
        solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return kSum(nums, target, 0, 4);
        }

        /**
         * Runtime:4 ms, faster than 95.03% of Java online submissions. Memory Usage:39.8 MB, less than 71.29% of Java online submissions.
         *
         * @param nums
         * @param target
         * @param start
         * @param k
         * @return
         */
        private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
                return res;
            if (k == 2)
                return twoSum(nums, target, start);
            for (int i = start; i < nums.length; ++i) {
                if (i == start || nums[i - 1] != nums[i]) {
                    for (List<Integer> kRes : kSum(nums, target - nums[i], i + 1, k - 1)) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i])));
                        res.get(res.size() - 1).addAll(kRes);
                    }
                }
            }
            return res;
        }

        private List<List<Integer>> twoSum(int[] nums, int target, int start) {
            List<List<Integer>> res = new ArrayList<>();
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                if (target < nums[left] + nums[right] || right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                } else if (target > nums[left] + nums[right] || left > start && nums[left - 1] == nums[left]) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[left++], nums[right--]));
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    /**
     * Runtime:20 ms, faster than 33.14% of Java online submissions.
     * Memory Usage:40.1 MB, less than 46.53% of Java online submissions.
     *
     * @param nums
     * @param target
     * @return
     */
    private List<List<Integer>> improveMyApproach(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < size; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int left = j + 1;
                        int right = size - 1;
                        while (left < right) {
                            int newTarget = nums[i] + nums[j] + nums[left] + nums[right];
                            if (newTarget == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                left++;
                                while (left < right && nums[left] == nums[left - 1]) left++;
                                right--;
                                while (left < right && nums[right] == nums[right + 1]) right--;
                            } else if (newTarget > target) {
                                right--;
                            } else {
                                left++;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }


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