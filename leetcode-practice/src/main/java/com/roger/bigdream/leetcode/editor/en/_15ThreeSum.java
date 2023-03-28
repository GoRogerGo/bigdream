package com.roger.bigdream.leetcode.editor.en;
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not mat
//ter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 24770 👎 2234

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15ThreeSum {

    public static void main(String[] args) {
        Solution solution = new _15ThreeSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:38 ms,击败了79.11% 的Java用户 内存消耗:49.9 MB,击败了54.19% 的Java用户
         * 参考别人的做法
         * 2023年03月28日19:44:22
         * 注意点：①排序，自己也想到了；②需要一层for循环，但巧妙的是它有两个trick，一个break和一个contine；
         * ③sum == 0时的去重； ④指针移动，尤其是等于0时，l和r相向而行。
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (null == nums || nums.length < 3) return res;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[l] + nums[r] + nums[i];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}