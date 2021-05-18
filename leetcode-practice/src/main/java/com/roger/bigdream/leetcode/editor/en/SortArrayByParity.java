package com.roger.bigdream.leetcode.editor.en;

//Given an array nums of non-negative integers, return an array consisting of al
//l the even elements of nums, followed by all the odd elements of nums. 
//
// You may return any answer array that satisfies this condition. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,2,4]
//Output: [2,4,3,1]
//The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// 
//
// 
//
// Note: 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// 
// Related Topics Array 
// 👍 1726 👎 91


public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
        solution.sortArrayByParity(new int[]{3, 1, 2, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:1 ms, faster than 98.40% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public int[] sortArrayByParity(int[] nums) {
            int[] odd = new int[nums.length];
            int[] even = new int[nums.length];
            int oddCtn = 0, evenCtn = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    even[evenCtn++] = num;
                } else {
                    odd[oddCtn++] = num;
                }
            }
            for (int i = 0; i < oddCtn; i++) {
                even[evenCtn + i] = odd[i];
            }
            return even;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}