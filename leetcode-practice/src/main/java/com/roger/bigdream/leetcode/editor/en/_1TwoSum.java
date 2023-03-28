package com.roger.bigdream.leetcode.editor.en;
//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time comp
//lexity? Related Topics Array Hash Table 
// 👍 44568 👎 1452

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {

    public static void main(String[] args) {
        Solution solution = new _1TwoSum().new Solution();
        System.out.println(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(solution.twoSum(new int[]{3, 2, 4}, 6));
        System.out.println(solution.twoSum(new int[]{3, 3}, 6));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:2 ms,击败了82.53% 的Java用户 内存消耗:42.4 MB,击败了79.23% 的Java用户
         * 在题目Follow-up的提示下才知道思路
         * 2023年03月25日22:59:07
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer aim = map.get(target - nums[i]);
                if (aim != null) {
                    return new int[]{i, aim};
                }
                if (map.get(nums[i]) == null) {
                    map.put(nums[i], i);
                }
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}