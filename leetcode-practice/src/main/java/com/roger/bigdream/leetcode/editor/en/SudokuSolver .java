//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-b
//oxes of the grid. 
// 
//
// Empty cells are indicated by the character '.'. 
//
// 
//A sudoku puzzle... 
//
// 
//...and its solution numbers marked in red. 
//
// Note: 
//
// 
// The given board contain only digits 1-9 and the character '.'. 
// You may assume that the given Sudoku puzzle will have a single unique solutio
//n. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table Backtracking 
// 👍 1863 👎 92


package com.roger.bigdream.leetcode.editor.en;

class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        solution.solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] row, col, boxes;

        /**
         * Runtime:3 ms, faster than 94.71% of Java online submissions.
         * Memory Usage:36.7 MB, less than 74.77% of Java online submissions.
         *
         * @param board
         */
        public void solveSudoku(char[][] board) {
            row = new int[9][9];
            col = new int[9][9];
            boxes = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int k = c - '0';
                        int box = i / 3 * 3 + j / 3;
                        row[i][k - 1] = 1;
                        col[j][k - 1] = 1;
                        boxes[box][k - 1] = 1;
                    }
                }
            }
            fill(board, 0, 0);
        }

        private boolean fill(char[][] board, int x, int y) {
            if (y == 9) return true;
            int nx = (x + 1) % 9;
            int ny = nx == 0 ? y + 1 : y;
            if (board[x][y] != '.') return fill(board, nx, ny);
            for (int i = 0; i < 9; i++) {
                int bx = x / 3;
                int by = y / 3;
                int box = bx * 3 + by;
                if (row[x][i] == 0 && col[y][i] == 0 && boxes[box][i] == 0) {
                    row[x][i] = 1;
                    col[y][i] = 1;
                    boxes[box][i] = 1;
                    board[x][y] = (char) (i + 1 + '0');
                    if (fill(board, nx, ny)) return true;
                    row[x][i] = 0;
                    col[y][i] = 0;
                    boxes[box][i] = 0;
                    board[x][y] = '.';
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}