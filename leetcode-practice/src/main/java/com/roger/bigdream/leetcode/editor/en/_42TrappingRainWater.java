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
         * <p>
         * 注意到下标i处能接的雨水量由leftMax[i]和rightMax[i]中的最小值决定。由于数组leftMaxleftMax是从左往右计算，数组rightMaxrightMax是从右往左计算，因此可以使用双指针和两个变量代替两个数组。
         * 维护两个指针left和right，以及两个变量leftMax和rightMax，初始时left=0,right=n−1,leftMax=0,rightMax=0。指针left只会向右移动，指针right只会向左移动，在移动指针的过程中维护两个变量leftMax和rightMax的值。
         * 当两个指针没有相遇时，进行如下操作：
         * 1.使用height[left]和height[right]的值更新leftMax和rightMax的值；
         * 2.如果height[left]<height[right]，则必有leftMax<rightMax，下标left处能接的雨水量等于leftMax−height[left]，将下标left处能接的雨水量加到能接的雨水总量，然后将left加1（即向右移动一位）；
         * 3.如果height[left]≥height[right]，则必有leftMax≥rightMax，下标right处能接的雨水量等于rightMax−height[right]，将下标right处能接的雨水量加到能接的雨水总量，然后将right减1（即向左移动一位）。
         * 当两个指针相遇时，即可得到能接的雨水总量。
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
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