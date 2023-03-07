package com.roger.bigdream.leetcode.editor.en;
//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is possibly rotated at an unknow
//n pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, retur
//n the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 20185 👎 1215

public class _33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new _33SearchInRotatedSortedArray().new Solution();
//        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(solution.search(new int[]{1}, 0));
//        System.out.println(solution.search(new int[]{1}, 1));
//        System.out.println(solution.search(new int[]{1, 3}, 1));
//        System.out.println(solution.search(new int[]{1, 3}, 0));
        System.out.println(solution.search(new int[]{3, 1}, 3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            return -1;
        }

        public int search_myWrongAnswer(int[] nums, int target) {
            int temp = -1;
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) index = i;
                if (nums[i] > temp) {
                    temp = nums[i];
                    continue;
                } else {
                    return target == nums[i] ? i : -1;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}