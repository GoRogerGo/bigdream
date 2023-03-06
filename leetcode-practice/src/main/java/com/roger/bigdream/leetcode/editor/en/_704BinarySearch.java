package com.roger.bigdream.leetcode.editor.en;
//Given an array of integers nums which is sorted in ascending order, and an int
//eger target, write a function to search target in nums. If target exists, then r
//eturn its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 < nums[i], target < 104 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array Binary Search 
// 👍 8247 👎 178

public class _704BinarySearch {

    public static void main(String[] args) {
        Solution solution = new _704BinarySearch().new Solution();
        int nums[] = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(nums, 9));
        System.out.println(solution.search(nums, 2));
        System.out.println(solution.search(nums, 13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:43.5 MB,击败了17.56% 的Java用户
         * 注意点：注意searchInsert0的第三个参数，是nums.length-1，不是nums.length。可和35题进行比较，等值查找就是length-1，寻找位置就是length
         * 2023年03月06日23:53:40
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            return search0(nums, 0, nums.length - 1, target);
        }

        private int search0(int[] nums, int l, int r, int target) {
            if (l > r) return -1;
            if (l == r) return nums[l] == target ? l : -1;
            int midIndex = l + (r - l) / 2;
            if (nums[midIndex] == target) return midIndex;
            else if (nums[midIndex] < target) return search0(nums, midIndex + 1, r, target);
            else return search0(nums, l, midIndex, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}