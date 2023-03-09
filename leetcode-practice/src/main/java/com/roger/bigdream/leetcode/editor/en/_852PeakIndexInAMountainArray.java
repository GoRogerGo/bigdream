package com.roger.bigdream.leetcode.editor.en;
//An array arr a mountain if the following properties hold: 
//
// 
// arr.length >= 3 
// There exists some i with 0 < i < arr.length - 1 such that:
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// Given a mountain array arr, return the index i such that arr[0] < arr[1] < ..
//. < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]. 
//
// You must solve it in O(log(arr.length)) time complexity. 
//
// 
// Example 1: 
//
// 
//Input: arr = [0,1,0]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: arr = [0,2,1,0]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: arr = [0,10,5,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 105 
// 0 <= arr[i] <= 106 
// arr is guaranteed to be a mountain array. 
// 
// Related Topics Array Binary Search 
// 👍 4746 👎 1777

public class _852PeakIndexInAMountainArray {

    public static void main(String[] args) {
        Solution solution = new _852PeakIndexInAMountainArray().new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 10, 5, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:59.1 MB,击败了72.56% 的Java用户
         * 和no.162是一样的
         * 2023年03月09日17:21:10
         *
         * @param arr
         * @return
         */
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > arr[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}