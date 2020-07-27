//Given a sorted array and a target value, return the index if the target is fou
//nd. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics Array Binary Search 
// 👍 2463 👎 257


package com.roger.bigdream.leetcode.editor.en;

class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return myApproach(nums, target);
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:38.9 MB, less than 82.96% of Java online submissions.
         *
         * @param nums
         * @param target
         * @return
         */
        private int myApproach(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}