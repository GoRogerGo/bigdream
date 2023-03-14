package com.roger.bigdream.leetcode.editor.en;
//You are given an m x n integer matrix matrix with the following two properties
//: 
//
// 
// Each row is sorted in non-decreasing order. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Given an integer target, return true if target is in matrix or false otherwis
//e. 
//
// You must write a solution in O(log(m * n)) time complexity. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search Matrix 
// 👍 11596 👎 337

public class _74SearchA2dMatrix {

    public static void main(String[] args) {
        Solution solution = new _74SearchA2dMatrix().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        System.out.println(solution.searchMatrix(new int[][]{{1}}, 0));
        System.out.println(solution.searchMatrix(new int[][]{{1}}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.6 MB,击败了12.65% 的Java用户
         * 花花的方法，牛逼了啊，他是直接将二维数组给拉长了，视为一个长数组！
         * 心得：①matrix.length * matrix[0].length ②[m / cols][m % cols]
         * 2023年03月14日08:43:56
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target) {
//            return searchMatrix(matrix, 0, matrix.length - 1, target);
            if (matrix.length == 0) return false;
            int l = 0;
            int r = matrix.length * matrix[0].length;
            int cols = matrix[0].length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (matrix[m / cols][m % cols] == target) {
                    return true;
                } else if (matrix[m / cols][m % cols] > target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return false;
        }

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.3 MB,击败了25.58% 的Java用户
         * 2023年03月14日08:38:27
         * 注意点：①两层递归的终止都要标准化 ②line81的l0 >= matrix_.length的三元表达式判断需要注意
         *
         * @param matrix
         * @param l
         * @param r
         * @param target
         * @return
         */
        private boolean searchMatrix_myself(int[][] matrix, int l, int r, int target) {
            if (l > r) return false;
            if (l == r) return searchMatrix0(target, matrix[l], 0, matrix[l].length);
            int mid = l + (r - l) / 2;
            int[] matrix_ = matrix[mid];
            if (matrix_[0] > target) return searchMatrix_myself(matrix, l, mid, target);
            else if (matrix_[matrix_.length - 1] < target) return searchMatrix_myself(matrix, mid + 1, r, target);
            else return searchMatrix0(target, matrix_, 0, matrix_.length);
        }

        private boolean searchMatrix0(int target, int[] matrix_, int l0, int r0) {
            if (l0 > r0) return false;
            if (l0 == r0) return l0 >= matrix_.length ? false : target == matrix_[l0];
            while (l0 < r0) {
                int mid0 = l0 + (r0 - l0) / 2;
                if (matrix_[mid0] == target) return true;
                else if (matrix_[mid0] > target) r0 = mid0;
                else l0 = mid0 + 1;
            }
            return searchMatrix0(target, matrix_, l0, r0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}