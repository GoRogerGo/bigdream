//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking 
// 👍 1948 👎 61


package com.roger.bigdream.leetcode.editor.en;

import java.util.*;

class PermutationsII {
    public static void main(String[] args) {
        Solution solution = new PermutationsII().new Solution();
//        solution.permuteUnique(new int[]{1, 2, 3});
        solution.permuteUnique(new int[]{1, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:5 ms, faster than 33.27% of Java online submissions.
         * Memory Usage:44.2 MB, less than 5.56% of Java online submissions.
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 1) return res;
            Arrays.sort(nums);
            dfs(res, nums, new ArrayList<>(), new boolean[nums.length]);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] nums, List<Integer> cur, boolean[] visited) {
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                // Same number can be only used once at each depth.
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                cur.add(nums[i]);
                visited[i] = true;
                dfs(res, nums, cur, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    private List<List<Integer>> myApproach(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        List<Boolean> used = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            used.add(false);
        }

        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            path.add(-1);
        }

        dfs(0, res, nums, used, path);

        return new ArrayList<>(res);
    }

    /**
     * Runtime:37 ms, faster than 14.75% of Java online submissions.
     * Memory Usage:40.1 MB, less than 63.44% of Java online submissions.
     *
     * @param curPos
     * @param res
     * @param nums
     * @param used
     * @param path
     */
    private void dfs(int curPos, Set<List<Integer>> res, int[] nums, List<Boolean> used, List<Integer> path) {
        if (curPos == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used.get(i)) {
                used.set(i, true);
                path.set(i, nums[curPos]);
                dfs(curPos + 1, res, nums, used, path);
                used.set(i, false);
            }
        }
    }
}