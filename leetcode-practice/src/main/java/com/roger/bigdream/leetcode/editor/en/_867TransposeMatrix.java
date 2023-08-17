package com.roger.bigdream.leetcode.editor.en;
//Given a 2D integer array matrix, return the transpose of matrix. 
//
// The transpose of a matrix is the matrix flipped over its main diagonal, switc
//hing the matrix's row and column indices. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[1,4,7],[2,5,8],[3,6,9]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6]]
//Output: [[1,4],[2,5],[3,6]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 105 
// -109 <= matrix[i][j] <= 109 
// 
// Related Topics Array Matrix Simulation 
// 👍 2963 👎 427

public class _867TransposeMatrix {

    public static void main(String[] args) {
        Solution solution = new _867TransposeMatrix().new Solution();
        int[][] matrix = solution.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:44.3 MB,击败了76.07% 的Java用户
         * 2023年08月17日18:38:49
         * 想复杂了
         *
         * @param matrix
         * @return
         */
        public int[][] transpose(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] transposed = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }
            return transposed;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}