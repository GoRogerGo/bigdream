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
            return enumeratePositionsForNum(nums);
        }

        /**
         * Enumerate positions for a number
         * 决定当前数字可以放哪些位置
         * <p>
         * Runtime:1 ms, faster than 93.92% of Java online submissions.
         * Memory Usage:39.5 MB, less than 75.35% of Java online submissions.
         *
         * @param nums
         * @return
         */
        private List<List<Integer>> enumeratePositionsForNum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                path.add(-1);
            }
            List<Boolean> used = new ArrayList<>(nums.length); // true if path[i] is used
            for (int i = 0; i < nums.length; i++) {
                used.add(false);
            }
            enumeratePositionsForNum(0, nums, res, path, used);
            return res;
        }

        // curPos is the index to num
        private void enumeratePositionsForNum(int curPos, int[] nums, List<List<Integer>> res, List<Integer> path, List<Boolean> used) {
            if (curPos == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            // 决定当前数字可以放哪些位置
            for (int i = 0; i < path.size(); i++) {
                if (!used.get(i)) {
                    used.set(i, true);
                    path.set(i, nums[curPos]);
                    enumeratePositionsForNum(curPos + 1, nums, res, path, used);
                    used.set(i, false);
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * Enumerate numbers for a position
     * 决定当前postion可以放哪些数字
     * <p>
     * Runtime:2 ms, faster than 61.65% of Java online submissions.
     * Memory Usage:41.8 MB, less than 6.60% of Java online submissions.
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> enumerateNumsForPosition(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            path.add(-1);
        }
        List<Boolean> used = new ArrayList<>(nums.length); // true if nums[i] is used
        for (int i = 0; i < nums.length; i++) {
            used.add(false);
        }
        enumerateNumsForPosition(0, nums, res, path, used);
        return res;
    }

    // curPos is the index to path
    private void enumerateNumsForPosition(int curPos, int[] nums, List<List<Integer>> res, List<Integer> path, List<Boolean> used) {
        if (curPos == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 决定当前postion可以放哪些数字
        for (int i = 0; i < nums.length; i++) {
            if (!used.get(i)) {
                used.set(i, true);
                path.set(curPos, nums[i]);
                enumerateNumsForPosition(curPos + 1, nums, res, path, used);
                used.set(i, false);
            }
        }
    }
}