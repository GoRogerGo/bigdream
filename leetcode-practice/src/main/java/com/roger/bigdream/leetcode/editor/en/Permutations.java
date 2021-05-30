//Given a collection of distinct integers, return all possible permutations.
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking 
// 👍 3938 👎 105


package com.roger.bigdream.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            permute(nums, 0, nums.length, new boolean[nums.length], new ArrayList<>(), res);
            return res;
        }

        /**
         * Runtime:1 ms, faster than 92.56% of Java online submissions.
         *
         * @param nums
         * @param depth
         * @param length
         * @param used
         * @param curr
         * @param res
         */
        private void permute(int[] nums, int depth, int length, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
            if (depth == length) {
                res.add(new ArrayList<>(curr));
                return;
            }
            for (int i = 0; i < length; i++) {
                if (used[i]) continue;
                used[i] = true;
                curr.add(nums[i]);
                permute(nums, depth + 1, length, used, curr, res);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}