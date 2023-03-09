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
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1}, 0));
        System.out.println(solution.search(new int[]{1}, 1));
        System.out.println(solution.search(new int[]{1, 3}, 1));
        System.out.println(solution.search(new int[]{1, 3}, 0));
        System.out.println(solution.search(new int[]{3, 1}, 3));
        System.out.println(solution.search(new int[]{5, 1, 3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.4 MB,击败了14.79% 的Java用户
         * 2023年03月09日11:06:57
         * 感想：这是花花的答案，吾天赋不可直得，下次再写吧~
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int x = (target < nums[0]) == (nums[mid] < nums[0])
                        ? nums[mid] :
                        target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                if (x < target) l = mid + 1;
                else if (x > target) r = mid;
                else return mid;
            }
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
                    return (i == nums.length - 1) ? index : (target == nums[i] ? i : -1);
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}