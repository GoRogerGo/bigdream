//Given an array nums and a value val, remove all instances of that value in-pla
//ce and return the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// The order of elements can be changed. It doesn't matter what you leave beyond
// the new length. 
//
// Example 1: 
//
// 
//Given nums = [3,2,2,3], val = 3,
//
//Your function should return length = 2, with the first two elements of nums be
//ing 2.
//
//It doesn't matter what you leave beyond the returned length.
// 
//
// Example 2: 
//
// 
//Given nums = [0,1,2,2,3,0,4,2], val = 2,
//
//Your function should return length = 5, with the first five elements of nums c
//ontaining 0, 1, 3, 0, and 4.
//
//Note that the order of those five elements can be arbitrary.
//
//It doesn't matter what values are set beyond the returned length. 
//
// Clarification: 
//
// Confused why the returned value is an integer but your answer is an array? 
//
// Note that the input array is passed in by reference, which means modification
// to the input array will be known to the caller as well. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeElement(nums, val);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} Related Topics Array Two Pointers 
// 👍 1452 👎 2717


package com.roger.bigdream.leetcode.editor.en;

class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        solution.removeElement(new int[]{3, 2, 2, 3}, 3);
        solution.removeElement(new int[]{0, 1, 2, 3, 0, 4, 2}, 2);
        solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:39.8 MB, less than 7.64% of Java online submissions.
         *
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage:38.1 MB, less than 54.35% of Java online submissions.
     *
     * @param nums
     * @param val
     * @return
     */
    private int myApproach(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (i < nums.length - 1) {
                    if (nums[i + 1] == val) {
                        continue;
                    }
                    nums[j++] = nums[++i];
                }
            } else {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}