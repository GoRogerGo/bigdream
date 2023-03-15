package com.roger.bigdream.leetcode.editor.en;
//Write an efficient algorithm that searches for a value target in an m x n inte
//ger matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matrix[i][j] <= 109 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search Divide and Conquer Matrix 
// 👍 10130 👎 168

public class _240SearchA2dMatrixIi {

    public static void main(String[] args) {
        Solution solution = new _240SearchA2dMatrixIi().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(solution.searchMatrix(new int[][]{{1, 1}}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:4 ms,击败了100.00% 的Java用户 内存消耗:48.7 MB,击败了18.79% 的Java用户
         * 别人简洁的代码，学习一下
         * 感想：题目条件没有利用起来，它每一列也是升序，而我的做法宽一点，只用到了每一行是升序
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int rowCount = matrix.length;
            int columnCount = matrix[0].length;

            int i = rowCount - 1;
            int j = 0;
            while (i >= 0 && j < columnCount) {
                System.out.println(matrix[i][j]);
                if (matrix[i][j] == target) return true;
                if (matrix[i][j] < target) {
                    j++;
                } else {
                    i--; // 利用到了"每一列也是升序"的条件，这里可以简单上移一行
                }
            }
            return false;
        }

        /**
         * 解答成功: 执行耗时:1295 ms,击败了5.19% 的Java用户 内存消耗:48.7 MB,击败了14.47% 的Java用户
         * 2023年03月15日09:07:54
         * <p>
         * 在else逻辑里引入二分法后，
         * 解答成功: 执行耗时:7 ms,击败了38.45% 的Java用户 内存消耗:48.6 MB,击败了18.79% 的Java用
         * 2023年03月15日09:28:50
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix_myself(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int rowCount = matrix.length;
            int columnCount = matrix[0].length;
            for (int i = rowCount; i > 0; i--) {
                for (int j = 0; j < columnCount; j++) {
                    int cur = matrix[i - 1][j];
                    if (cur == target) return true;
                    else if (cur > target) break;
                    else {
                        if (searchMatrix(matrix[i - 1], 0, columnCount - 1, target)) {
                            return true;
                        } else {
                            break;
                        }
                    }
                }
            }
            return false;
        }

        private boolean searchMatrix(int[] matrix, int l, int r, int target) {
            if (l > r) return false;
            if (l == r) return matrix[l] == target;
            int mid = l + (r - l) / 2;
            if (target == matrix[mid]) return true;
            else if (target > matrix[mid]) l = mid + 1;
            else r = mid;
            return searchMatrix(matrix, l, r, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}