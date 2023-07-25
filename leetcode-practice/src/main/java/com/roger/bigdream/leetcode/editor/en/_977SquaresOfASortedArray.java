package com.roger.bigdream.leetcode.editor.en;
//Given an integer array nums sorted in non-decreasing order, return an array of
// the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, co
//uld you find an O(n) solution using a different approach? Related Topics Array Two Pointers Sorting
// 👍 7578 👎 188

public class _977SquaresOfASortedArray {

    public static void main(String[] args) {
        Solution solution = new _977SquaresOfASortedArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:44.5 MB,击败了21.61% 的Java用户
         * 2023年03月28日20:26:50
         * 看的别人的答案，死记硬背吧
         *
         * @param nums
         * @return
         */
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0, j = nums.length - 1, pos = nums.length - 1; i <= j; ) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    res[pos] = nums[i] * nums[i];
                    i++;
                } else {
                    res[pos] = nums[j] * nums[j];
                    j--;
                }
                pos--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}