package com.roger.bigdream.leetcode.editor.en;
//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,6], target = 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,5,6], target = 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 12533 👎 548

public class _35SearchInsertPosition {

    public static void main(String[] args) {
        Solution solution = new _35SearchInsertPosition().new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 7));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:41.6 MB,击败了82.32% 的Java用户
         * 2023年03月06日23:38:14
         * 注意点：①注意searchInsert0的第三个参数，是nums.length，不是nums.length-1；②中断条件下返回l
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0) return 0;
            return searchInsert0(nums, 0, nums.length, target);
        }

        private int searchInsert0(int[] nums, int l, int r, int target) {
            if (l >= r) return l;
            int midIndex = l + (r - l) / 2;
            if (nums[midIndex] == target) return midIndex;
            else if (nums[midIndex] < target) return searchInsert0(nums, midIndex + 1, r, target);
            else return searchInsert0(nums, l, midIndex, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}