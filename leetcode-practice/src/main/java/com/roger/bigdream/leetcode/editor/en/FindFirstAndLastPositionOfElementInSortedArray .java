//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// nums is a non decreasing array. 
// -10^9 <= target <= 10^9 
// 
// Related Topics Array Binary Search 
// 👍 3590 👎 152


package com.roger.bigdream.leetcode.editor.en;

class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return myApproach(nums, target);
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:42.8 MB, less than 28.81% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        private int[] myApproach(int[] nums, int target) {
            int[] result = new int[]{-1, -1};
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    while (low <= mid) {
                        if (nums[low] != target) {
                            low++;
                            continue;
                        } else {
                            result[0] = low;
                            break;
                        }
                    }
                    while (high >= mid) {
                        if (nums[high] != target) {
                            high--;
                            continue;
                        } else {
                            result[1] = high;
                            break;
                        }
                    }
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}