package com.roger.bigdream.leetcode.editor.en;
//Nearly everyone has used the Multiplication Table. The multiplication table of
// size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed). 
//
// Given three integers m, n, and k, return the kth smallest element in the m x 
//n multiplication table. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 3, k = 5
//Output: 3
//Explanation: The 5th smallest number is 3.
// 
//
// Example 2: 
//
// 
//Input: m = 2, n = 3, k = 6
//Output: 6
//Explanation: The 6th smallest number is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 3 * 104 
// 1 <= k <= m * n 
// 
// Related Topics Math Binary Search 
// 👍 1894 👎 52

public class _668KthSmallestNumberInMultiplicationTable {

    public static void main(String[] args) {
        Solution solution = new _668KthSmallestNumberInMultiplicationTable().new Solution();
        solution.findKthNumber(3, 3, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:17 ms,击败了84.93% 的Java用户 内存消耗:39.3 MB,击败了51.14% 的Java用
         * 花花的答案，我对乘法表的特性不甚了解。。
         * 2023年03月15日11:41:06
         *
         * @param m
         * @param n
         * @param k
         * @return
         */
        public int findKthNumber(int m, int n, int k) {
            int r = m * n + 1; //乘法表的特性：mat[i][j] == i * j
            int l = 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (LEX(m, n, mid) >= k) r = mid;
                else l = mid + 1;
            }
            return l;
        }

        /**
         * 返回乘法表里小于target的元素个数
         *
         * @param m
         * @param n
         * @param target
         * @return
         */
        private int LEX(int m, int n, int target) {
            int count = 0;
            for (int i = 1; i <= m; ++i) {
                count += Math.min(n, target / i);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}