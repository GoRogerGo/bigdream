package com.roger.bigdream.leetcode.editor.en;
//Given an array of integers nums sorted in non-decreasing order, find the start
//ing and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 16084 👎 378

public class _34FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new _34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] result;
//        result = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        result = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
//        result = solution.searchRange(new int[]{}, 0);
        result = solution.searchRange(new int[]{1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] defaultResult = new int[]{-1, -1};

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:46.2 MB,击败了16.93% 的Java用户
         * 花花的做法，有点新奇，想不到，等到第二次再自己写一遍吧
         * 2023年03月07日11:20:12
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange(int[] nums, int target) {
            return new int[]{firstPos(nums, target), lastPos(nums, target)};
        }

        int firstPos(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] >= target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            if (l == nums.length || nums[l] != target) return -1;
            return l;
        }

        int lastPos(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] > target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            // l points to the first element this is greater than target.
            --l;
            if (l < 0 || nums[l] != target) return -1;
            return l;
        }

        public int[] searchRange_myself(int[] nums, int target) {
            if (nums.length == 0) return defaultResult;
            return searchRange0(nums, 0, nums.length - 1, target);
        }

        /**
         * 运行失败: Time Limit Exceeded 测试用例:[5,7,7,8,8,10] 6 stdout:
         * 2023年03月07日11:13:46
         *
         * @param nums
         * @param l
         * @param r
         * @param target
         * @return
         */
        private int[] searchRange0(int[] nums, int l, int r, int target) {
            while (l <= r) {
                int midIndex = l + (r - l) / 2;
                if (nums[midIndex] == target) {
                    l = midIndex;
                    r = midIndex;
                    while (l >= 0) {
                        if (nums[l] != target) break;
                        l--;
                    }
                    while (r < nums.length) {
                        if (nums[r] != target) break;
                        r++;
                    }
                    return new int[]{l + 1, r - 1};
                } else if (nums[midIndex] > target) {
                    r = midIndex;
                } else {
                    l = midIndex + 1;
                }
            }
            return defaultResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}