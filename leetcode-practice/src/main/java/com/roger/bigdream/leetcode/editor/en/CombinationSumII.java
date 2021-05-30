//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sums
// to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking 
// 👍 1841 👎 70


package com.roger.bigdream.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public static void main(String[] args) {
        Solution solution = new CombinationSumII().new Solution();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:2 ms, faster than 98.71% of Java online submissions.
         * Memory Usage:39.9 MB, less than 53.92% of Java online submissions.
         *
         * @param candidates
         * @param target
         * @return
         */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, curr, res);
            return res;
        }

        private void dfs(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) return;
                if (i > start && candidates[i] == candidates[i - 1]) continue;//相同元素在同一层里不能使用
                curr.add(candidates[i]);
                // 和39题的差别在于start参数，这里是i+1，那里是i
                dfs(candidates, target - candidates[i], i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}