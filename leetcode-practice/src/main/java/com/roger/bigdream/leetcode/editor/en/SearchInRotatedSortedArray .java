//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search 
// 👍 5216 👎 462


package com.roger.bigdream.leetcode.editor.en;

class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(solution.search(new int[]{1}, 1));
        System.out.println(solution.search(new int[]{1, 3}, 0));
        System.out.println(solution.search(new int[]{1, 3}, 2));
        System.out.println(solution.search(new int[]{1, 3}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:39 MB, less than 57.02% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int reverseIndex = findReverseIndex(nums);
            if (target >= nums[0] && target <= nums[reverseIndex]) {
                return findTarget(nums, target, 0, reverseIndex);
            } else {
                return findTarget(nums, target, reverseIndex + 1, nums.length - 1);
            }
        }

        private int findTarget(int[] nums, int target, int low, int high) {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[low] > target || nums[high] < target) return -1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private int findReverseIndex(int[] nums) {
            if (nums.length == 1) return 0;
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] >= nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}