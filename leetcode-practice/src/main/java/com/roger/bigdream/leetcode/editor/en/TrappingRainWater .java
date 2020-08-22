//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack 
// 👍 7488 👎 128


package com.roger.bigdream.leetcode.editor.en;

class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        solution.trap(new int[]{4, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:2 ms, faster than 35.55% of Java online submissions.
         * Memory Usage:40.9 MB, less than 9.30% of Java online submissions.
         * <p>
         * Time complexity:O(n)
         * Space complexity:O(1)
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int sum = 0, left = 0, right = height.length - 1;
            int max_l = height[left], max_r = height[right];
            while (left < right) {
                if (max_l < max_r) {
                    sum += max_l - height[left];
                    max_l = Math.max(max_l, height[++left]);
                } else {
                    sum += max_r - height[right];
                    max_r = Math.max(max_r, height[--right]);
                }
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * Runtime:1 ms, faster than 95.47% of Java online submissions.
     * Memory Usage:38.9 MB, less than 93.74% of Java online submissions.
     * <p>
     * 空间换时间 We can pre-compute the max of h[0~i] and h[i~n-1] in O(n)
     * l[i] = max(h[0~i])
     * r[i] = max(h[i~n-1])
     * <p>
     * l[i] = max(l[i-1], h[i]) i: 0 ~ n-1
     * r[i] = max(r[i+1], h[i]) i: n-1 ~ 0
     * <p>
     * Time complexity:O(n)
     * Space complexity:O(n)
     *
     * @param height
     * @return
     */
    private int dp(int[] height) {
        if (height.length < 2) return 0;
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            left[i] = i == 0 ? height[i] : Math.max(left[i - 1], height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = i == height.length - 1 ? height[i] : Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }


    private int myWrongApproach(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) continue;
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                if (left <= height[j]) {
                    sum += sumArea(height, i, j);
                    i = j - 1;
                    break;
                }
                if (j == height.length - 1) {
                    sum += sumArea(height, i, j);
                }
            }
        }
        return sum;
    }

    private int sumArea(int[] height, int i, int j) {
        int sum = 0;
        int level = Math.min(height[i], height[j]);
        for (int k = i; k <= j; k++) {
            sum += level > height[k] ? level - height[k] : 0;
        }
        return sum;
    }
}