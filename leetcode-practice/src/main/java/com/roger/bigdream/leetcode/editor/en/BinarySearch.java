package com.roger.bigdream.leetcode.editor.en;

//Given an array of integers nums which is sorted in ascending order, and an int
//eger target, write a function to search target in nums. If target exists, then r
//eturn its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -9999 <= nums[i], target <= 9999 
// All the integers in nums are unique. 
// nums is sorted in an ascending order. 
// 
// Related Topics Binary Search 
// 👍 1364 👎 62


public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            /**
             * Runtime:0 ms, faster than 100.00% of Java online submissions.
             */
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        private int binarySearch(int[] nums, int left, int right, int target) {
            if (left > right) return -1;
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}