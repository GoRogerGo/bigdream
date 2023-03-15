package com.roger.bigdream.leetcode.editor.en;
//Given an n x n matrix where each of the rows and columns is sorted in ascendin
//g order, return the kth smallest element in the matrix. 
//
// Note that it is the kth smallest element in the sorted order, not the kth dis
//tinct element. 
//
// You must find a solution with a memory complexity better than O(n2). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the
// 8th smallest number is 13
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-5]], k = 1
//Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// All the rows and columns of matrix are guaranteed to be sorted in non-decreas
//ing order. 
// 1 <= k <= n2 
// 
//
// 
// Follow up: 
//
// 
// Could you solve the problem with a constant memory (i.e., O(1) memory complex
//ity)? 
// Could you solve the problem in O(n) time complexity? The solution may be too 
//advanced for an interview but you may find reading this paper fun. 
// 
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 
// 👍 8817 👎 310

public class _378KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        Solution solution = new _378KthSmallestElementInASortedMatrix().new Solution();
        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{-5}}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功:
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:48.4 MB,击败了27.70% 的Java用户
         * 2023年03月15日09:51:31
         * 心得：①和no240有共性和差异，差异是result += (i + 1)，这一点很精妙 ②起始l和r的取值 ③ countSmallOrEquals的妙用
         *
         * @param matrix
         * @param k
         * @return
         */
        public int kthSmallest(int[][] matrix, int k) {
            int l = matrix[0][0], r = matrix[matrix.length - 1][matrix.length - 1];
            while (l < r) {
                int m = l + (r - l) / 2;
                int count = countSmallOrEquals(matrix, m);
                if (count < k) l = m + 1;
                else r = m;
            }
            return l;
        }

        private int countSmallOrEquals(int[][] matrix, int target) {
            int result = 0;

            int rowCount = matrix.length;
            int columnCount = matrix[0].length;

            int i = rowCount - 1;
            int j = 0;
            while (i >= 0 && j < columnCount) {
                if (matrix[i][j] <= target) {
                    result += (i + 1);
                    j++;
                } else {
                    i--;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}