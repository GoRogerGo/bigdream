package com.roger.bigdream.leetcode.editor.en;
//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but num
//s may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics Array Binary Search 
// 👍 5815 👎 836

public class _81SearchInRotatedSortedArrayIi {

    public static void main(String[] args) {
        Solution solution = new _81SearchInRotatedSortedArrayIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            return search(nums, 0, nums.length - 1, target);
        }

        /**
         * 官方答案
         * 2023年07月29日12:05:38
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.6 MB,击败了98.83% 的Java用户
         *
         * @param nums
         * @param l
         * @param r
         * @param target
         * @return
         */
        private boolean search(int[] nums, int l, int r, int target) {
            if (nums.length == 0) return false;
            if (nums.length == 1) return nums[0] == target;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) return true; //先比较mid位置的值是否符合target

                if (nums[l] == nums[mid] && nums[mid] == nums[r]) { //和33题最大的区别在这里
                    l++;
                    r--;
                } else if (nums[l] <= nums[mid]) { //这里是小于等于
                    if (nums[l] <= target && target < nums[mid]) { //前闭后开
                        r = mid - 1; //这里是mid-1，不是r = mid
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[nums.length - 1]) { //前开后闭，这里是nums[nums.length - 1]，不是nums[r]
                        l = mid + 1;
                    } else {
                        r = mid - 1; //这里是mid-1，不是r = mid
                    }
                }
            }
            return false;
        }

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.5 MB,击败了23.83% 的Java用户
         * 2023年03月09日15:53:43
         * 这是花花的答案，第一次写没有思路。
         * <p>
         * 感想：①递归不可怕，难点是在终止条件上；
         * ②类似search(nums, l, mid, target) || search(nums, mid + 1, r, target)这种或的写法完全没有想象能力
         * 注意点：①target <= nums[mid]是小于等于
         *
         * @param nums
         * @param l
         * @param r
         * @param target
         * @return
         */
        private boolean search_huahua(int[] nums, int l, int r, int target) {
            if (l > r) return false;
            if (l == r) return nums[l] == target;
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid] && nums[mid] < nums[r]) {
                return target <= nums[mid] ? search_huahua(nums, l, mid, target) : search_huahua(nums, mid + 1, r, target);
            } else {
                return search_huahua(nums, l, mid, target) || search_huahua(nums, mid + 1, r, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}