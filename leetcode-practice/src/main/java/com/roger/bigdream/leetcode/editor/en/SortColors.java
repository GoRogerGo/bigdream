package com.roger.bigdream.leetcode.editor.en;

//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and b
//lue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2: 
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3: 
// Input: nums = [0]
//Output: [0]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant ex
//tra space? 
// Related Topics Array Two Pointers Sort 
// 👍 5389 👎 310


public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param nums
         */
        public void sortColors(int[] nums) {
            if (nums.length <= 1) return;
            // 查找数组中数据的范围(该步省略，直接定为3)
            int[] c = new int[3]; // 申请一个计数数组c，下标大小[0,max]
            for (int num : nums) {
                c[num]++;
            }
            int k = 0;
            for (int i = 0; i < 3; i++) {
                int j = 0;
                while (j++ < c[i]) {
                    nums[k++] = i;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}