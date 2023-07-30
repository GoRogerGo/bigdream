package com.roger.bigdream.leetcode.editor.en;
//You are given two lists of closed intervals, firstList and secondList, where f
//irstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of in
//tervals is pairwise disjoint and in sorted order. 
//
// Return the intersection of these two interval lists. 
//
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with
// a <= x <= b. 
//
// The intersection of two closed intervals is a set of real numbers that are ei
//ther empty or represented as a closed interval. For example, the intersection of
// [1, 3] and [2, 4] is [2, 3]. 
//
// 
// Example 1: 
//
// 
//Input: firstList = [[0,2],[5,10],[13,23],[24,25]],
//      secondList = [[1,5],[8,12],[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// Example 2: 
//
// 
//Input: firstList = [[1,3],[5,9]], secondList = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 109 
// endi < starti+1 
// 0 <= startj < endj <= 109 
// endj < startj+1 
// 
// Related Topics Array Two Pointers 
// 👍 5015 👎 98

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _986IntervalListIntersections {

    public static void main(String[] args) {
        Solution solution = new _986IntervalListIntersections().new Solution();
        System.out.println(solution.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
        System.out.println(solution.intervalIntersection(new int[][]{{5, 10}}, new int[][]{{5, 6}}));
        System.out.println(solution.intervalIntersection(new int[][]{{3, 5}, {9, 20}}, new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}}));
        System.out.println(solution.intervalIntersection(new int[][]{{4, 6}, {7, 8}, {10, 17}}, new int[][]{{5, 10}}));
        System.out.println(solution.intervalIntersection(new int[][]{{0, 4}, {7, 8}, {12, 19}}, new int[][]{{0, 10}, {14, 15}, {18, 20}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] defaultRes = new int[][]{};

        /**
         * 2023年07月30日15:33:33
         * 解答成功: 执行耗时:3 ms,击败了97.18% 的Java用户 内存消耗:44.5 MB,击败了86.00% 的Java用户
         * 官网答案
         *
         * @param firstList
         * @param secondList
         * @return
         */
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            List<int[]> ans = new ArrayList();
            int i = 0, j = 0;

            while (i < firstList.length && j < secondList.length) {
                // Let's check if A[i] intersects B[j].
                // lo - the startpoint of the intersection
                // hi - the endpoint of the intersection
                int lo = Math.max(firstList[i][0], secondList[j][0]);
                int hi = Math.min(firstList[i][1], secondList[j][1]);
                if (lo <= hi)
                    ans.add(new int[]{lo, hi});

                // Remove the interval with the smallest endpoint
                if (firstList[i][1] < secondList[j][1])
                    i++;
                else
                    j++;
            }

            return ans.toArray(new int[ans.size()][]);
        }

        /**
         * 解答成功: 执行耗时:2 ms,击败了99.17% 的Java用户 内存消耗:43.3 MB,击败了43.21% 的Java用户
         * 2023年03月24日01:12:06
         * 别人的做法，时间太晚了，后面再研读吧
         *
         * @param firstList
         * @param secondList
         * @return
         */
        public int[][] intervalIntersection_others(int[][] firstList, int[][] secondList) {
            List<int[]> result = new LinkedList<>();
            getInterval(firstList, secondList, 0, 0, result);
            return result.toArray(new int[result.size()][]);
        }

        public List<int[]> getInterval(int[][] firstList, int[][] secondList, int pointerA, int pointerB, List<int[]> result) {
            if (pointerA == firstList.length || pointerB == secondList.length) {
                return result;
            }
            int[] a = firstList[pointerA];
            int[] b = secondList[pointerB];
            int min = Math.max(a[0], b[0]);
            int max = Math.min(a[1], b[1]);
            if (min <= max) {
                result.add(new int[]{min, max});
                if (a[1] == max) {
                    return getInterval(firstList, secondList, pointerA + 1, pointerB, result);
                }
                return getInterval(firstList, secondList, pointerA, pointerB + 1, result);
            }
            if (a[0] == min) {
                return getInterval(firstList, secondList, pointerA, pointerB + 1, result);
            }
            return getInterval(firstList, secondList, pointerA + 1, pointerB, result);
        }

        /**
         * 解答成功: 执行耗时:21 ms,击败了5.66% 的Java用户 内存消耗:43.7 MB,击败了22.53% 的Java用户
         * 2023年03月24日01:05:06
         * 花了很久，才把逻辑条件写对：new Pair(Math.max(firstL, secondL), Math.min(firstR, secondR))
         *
         * @param firstList
         * @param secondList
         * @return
         */
        public int[][] intervalIntersection_myself(int[][] firstList, int[][] secondList) {
            if (firstList.length == 0 || secondList.length == 0) return defaultRes;
            int firstLen = firstList.length;
            int secondLen = secondList.length;

            if (firstLen > secondLen) return intervalIntersection_myself(secondList, firstList);
            // 特殊情况快速返回
            int firstMin = firstList[0][0];
            int firstMax = firstList[firstLen - 1][1];
            int secondMin = secondList[0][0];
            int secondMax = secondList[secondLen - 1][1];
            if (firstMax < secondMin || firstMin > secondMax) return defaultRes;

            List<Pair> pairs = new ArrayList<>();
            for (int i = secondLen; i > 0; i--) {
                int secondL = secondList[i - 1][0];
                int secondR = secondList[i - 1][1];
                for (int j = firstLen; j > 0; j--) {
                    int firstL = firstList[j - 1][0];
                    int firstR = firstList[j - 1][1];
                    // 快速返回
                    if (firstL > secondR || firstR < secondL) {
                        continue;
                    }
                    pairs.add(new Pair(Math.max(firstL, secondL), Math.min(firstR, secondR)));
                }
            }
            int[][] res = new int[pairs.size()][];
            for (int i = 0; i < pairs.size(); i++) {
                int index = pairs.size() - 1 - i;
                res[i] = new int[]{pairs.get(index).getFirst(), pairs.get(index).getSecond()};
            }
            return res;
        }

        class Pair {
            private int first;
            private int second;

            public int getFirst() {
                return first;
            }

            public int getSecond() {
                return second;
            }

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}