package com.roger.bigdream.leetcode.editor.en;
//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics Array Two Pointers Greedy 
// 👍 23252 👎 1240

public class _11ContainerWithMostWater {

    public static void main(String[] args) {
        Solution solution = new _11ContainerWithMostWater().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:4 ms,击败了66.35% 的Java用户 内存消耗:52.3 MB,击败了88.98% 的Java用户
         * 2023年03月21日17:04:14
         * 花花的答案
         * 感想：核心逻辑就是比两个边界，谁高就移动另一边
         *
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;
            int maxAmount = 0;
            while (l < r) {
                int amount = (r - l) * Math.min(height[l], height[r]);
                if (amount > maxAmount) maxAmount = amount;
                if (height[l] < height[r])
                    ++l;
                else
                    --r;
            }
            return maxAmount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}