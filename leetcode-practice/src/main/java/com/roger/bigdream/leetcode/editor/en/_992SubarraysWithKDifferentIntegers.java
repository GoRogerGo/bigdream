package com.roger.bigdream.leetcode.editor.en;
//Given an integer array nums and an integer k, return the number of good subarr
//ays of nums. 
//
// A good array is an array where the number of different integers in that array
// is exactly k.
//“好的”数组是一个数组，其中不同整数的数量恰好为 k。
// 
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3. 
// 
//
// A subarray is a contiguous part of an array. 
//子数组是指数组中的连续一部分。
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,2,3], k = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1],
// [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,4], k = 3
//Output: 3
//Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2
//,1,3], [1,3,4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i], k <= nums.length 
// 
// Related Topics Array Hash Table Sliding Window Counting 
// 👍 4148 👎 61

import java.util.HashMap;
import java.util.Map;

public class _992SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        Solution solution = new _992SubarraysWithKDifferentIntegers().new Solution();
        solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这是leetcode给的解决方案：
         * 为了方便起见，我们用元组来表示子数组：(i,j) = [A[i], A[i+1], ..., A[j]]，并称一个子数组为“有效”，当它具有 K 个不同的整数时。
         * 对于每个 j，我们考虑所有满足子数组 (i, j) 为“有效”的 i 组成的集合 S_j。
         * 首先，S_j 必须是一个连续的区间。如果 i1 < i2 < i3，且 (i1,j) 和 (i3,j) 是有效的，但 (i2,j) 不是有效的，那么这就是个矛盾，因为 (i2,j) 必须包含超过 K 个不同的元素（因为 (i3,j) 包含 K 个不同的元素），但 (i1,j)（它是 (i2,j) 的超集）只包含 K 个不同的整数。
         * 现在，我们将 S_j 写成区间的形式：S_j=[left1j,left2j]。
         * 第二个观察是这些区间的端点必须单调递增 left1j-left2j 即，是单调递增的。利用类似上文的逻辑，我们可以构造出这个事实的证明，但直觉是：在向子数组中添加一个额外元素后，它们已经是有效的，或者我们需要稍微缩小它们以保持它们的有效性。
         * 我们将维护两个滑动窗口，分别对应于left1j和left2j。每个滑动窗口将能够计数窗口中有多少不同的元素，并以类似队列的方式添加和删除元素。
         * <p>
         * 解答成功: 执行耗时:58 ms,击败了23.86% 的Java用户 内存消耗:48 MB,击败了5.49% 的Java用户
         * 2023年04月07日16:48:47
         *
         * @param nums
         * @param k
         * @return
         */
        public int subarraysWithKDistinct(int[] nums, int k) {
            Window window1 = new Window();
            Window window2 = new Window();
            int ans = 0, left1 = 0, left2 = 0;
            for (int right = 0; right < nums.length; right++) {
                int x = nums[right];
                window1.add(x);
                window2.add(x);

                while (window1.diff() > k) {
                    window1.remove(nums[left1++]);
                }
                while (window2.diff() >= k) {
                    window2.remove(nums[left2++]);
                }
                ans += left2 - left1;
            }
            return ans;
        }
    }

    class Window {
        Map<Integer, Integer> counter;
        int nonZero;

        public Window() {
            this.counter = new HashMap<>();
            this.nonZero = 0;
        }

        public void add(int x) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
            if (counter.get(x) == 1) {
                nonZero++;
            }
        }

        public void remove(int x) {
            counter.put(x, counter.getOrDefault(x, 0) - 1);
            if (counter.get(x) == 0) {
                nonZero--;
            }
        }

        public int diff() {
            return nonZero;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}