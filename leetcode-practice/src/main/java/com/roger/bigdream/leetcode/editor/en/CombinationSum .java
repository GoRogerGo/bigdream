//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
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
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// Each element of candidate is unique. 
// 1 <= target <= 500 
// 
// Related Topics Array Backtracking 
// 👍 3975 👎 119


package com.roger.bigdream.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return withOutputOrder(candidates, target);
        }

        /**
         * Runtime:4 ms, faster than 67.65% of Java online submissions.
         * Memory Usage:39.6 MB, less than 84.39% of Java online submissions.
         *
         * @param candidates
         * @param target
         * @return
         */
        private List<List<Integer>> withOutputOrder(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            Arrays.sort(candidates);
            for (int n = 1; n <= target / candidates[0]; n++) {
                combinationSum1(candidates, target, 0, 0, n, curr, res);
            }
            return res;
        }

        private void combinationSum1(int[] candidates, int target, int start, int depth, int n, List<Integer> curr, List<List<Integer>> res) {
            if (depth == n && target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                curr.add(candidates[i]);
                combinationSum1(candidates, target - candidates[i], i, depth + 1, n, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private List<List<Integer>> withoutOutputOrder(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum0(candidates, target, 0, curr, res);
        return res;
    }

    private void combinationSum0(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            curr.add(candidates[i]);
            combinationSum0(candidates, target - candidates[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }

    }
}