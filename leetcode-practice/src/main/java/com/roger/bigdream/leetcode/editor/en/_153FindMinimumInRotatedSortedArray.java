package com.roger.bigdream.leetcode.editor.en;
//Suppose an array of length n sorted in ascending order is rotated between 1 an
//d n times. For example, the array nums = [0,1,2,4,5,6,7] might become: 
//
// 
// [4,5,6,7,0,1,2] if it was rotated 4 times. 
// [0,1,2,4,5,6,7] if it was rotated 7 times. 
// 
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. 
//
// Given the sorted rotated array nums of unique elements, return the minimum el
//ement of this array. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times
//.
// 
//
// Example 3: 
//
// 
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
//
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// All the integers of nums are unique. 
// nums is sorted and rotated between 1 and n times. 
// 
// Related Topics Array Binary Search 
// 👍 9927 👎 465

public class _153FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new _153FindMinimumInRotatedSortedArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 官方答案
         * 2023年07月29日12:13:44
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:41.3 MB,击败了22.13% 的Java用户
         *
         * @param nums
         * @return
         */
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else {
                    low = pivot + 1;
                }
            }
            return nums[low];

//            return findMin_huahua(nums, 0, nums.length - 1);
        }

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.2 MB,击败了26.73% 的Java用户
         * 2023年03月09日16:37:33
         * 花花的答案。。。
         *
         * @param nums
         * @param l
         * @param r
         * @return
         */
        private int findMin_huahua(int[] nums, int l, int r) {
            // Only 1 or 2 elements
            if (l + 1 >= r) return Math.min(nums[l], nums[r]);

            // Sorted
            if (nums[l] < nums[r]) return nums[l];

            int mid = l + (r - l) / 2;

            return Math.min(findMin_huahua(nums, l, mid - 1),
                    findMin_huahua(nums, mid, r));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}