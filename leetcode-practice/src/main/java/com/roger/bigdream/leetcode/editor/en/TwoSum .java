//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table


package com.roger.bigdream.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
//            return myApproach(nums, target);
            return onePassHashMap(nums, target);
        }

        /**
         * * Time complexity : *O(n)*.
         * * Space complexity : *O(n)*.
         *
         * @param nums
         * @param target
         * @return
         */
        private int[] onePassHashMap(int[] nums, int target) {
            // key:value value:index
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        /**
         * * Time complexity : *O(n^2)*.
         * * Space complexity : *O(1)*.
         *
         * @param nums
         * @param target
         * @return
         */
        private int[] myApproach(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}