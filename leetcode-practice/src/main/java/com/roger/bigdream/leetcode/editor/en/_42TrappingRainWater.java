package com.roger.bigdream.leetcode.editor.en;
//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack 
// 👍 25596 👎 352

public class _42TrappingRainWater {

    public static void main(String[] args) {
        Solution solution = new _42TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:1 ms,击败了98.68% 的Java用户 内存消耗:43.1 MB,击败了53.82% 的Java用户
         * 2023年03月21日17:52:16
         * 花花的答案
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int n = height.length;
            if (n == 0) return 0;
            int l = 0;
            int r = n - 1;
            int max_l = height[l];
            int max_r = height[r];
            int ans = 0;
            while (l < r) {
                if (max_l < max_r) {
                    ans += max_l - height[l];
                    max_l = Math.max(max_l, height[++l]);
                } else {
                    ans += max_r - height[r];
                    max_r = Math.max(max_r, height[--r]);
                }
            }
            return ans;
        }

        public int trap_myWrongAnswer(int[] height) {
            int amount = 0;
            for (int i = 1; i < height.length - 1; i++) {
                if (height[i] <= height[i + 1] && height[i] <= height[i - 1]) {
                    int l = i - 1;
                    int r = i + 1;
                    while (l > 0 && height[l] < height[l - 1]) {
                        amount += (Math.min(height[l - 1], height[r]) - height[l]);
                        l--;
                    }
                    while (r < height.length - 1 && height[r] < height[r + 1]) {
                        amount += (Math.min(height[l], height[r + 1]) - height[r]);
                        r++;
                    }
                    amount += (Math.min(height[l], height[r]) - height[i]);
                    i = r;
                }
            }
            return amount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}