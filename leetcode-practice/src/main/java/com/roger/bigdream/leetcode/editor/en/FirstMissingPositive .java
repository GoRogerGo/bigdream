//Given an unsorted integer array, find the smallest missing positive integer.
//
// Example 1: 
//
// 
//Input: [1,2,0]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [3,4,-1,1]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: [7,8,9,11,12]
//Output: 1
// 
//
// Follow up: 
//
// Your algorithm should run in O(n) time and uses constant extra space. 
// Related Topics Array 
// 👍 3735 👎 815


package com.roger.bigdream.leetcode.editor.en;

class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:37.5 MB, less than 63.72% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    swap0(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void swap0(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}