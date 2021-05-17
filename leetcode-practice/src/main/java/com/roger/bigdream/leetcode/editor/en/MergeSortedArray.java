package com.roger.bigdream.leetcode.editor.en;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. You may assume that nums1 has a size equal to m + n such that it has enough s
//pace to hold additional elements from nums2. 
//
// 
// Example 1: 
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
// Example 2: 
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
// 
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
//
// 
//Follow up: Can you come up with an algorithm that runs in O(m + n) time? Relat
//ed Topics Array Two Pointers 
// 👍 3796 👎 5358


public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = new int[m];
            for (int i = 0; i < m; i++) {
                temp[i] = nums1[i];
            }
            int i = 0, j = 0, k = 0;
            while (i < m && j < n) {
                if (temp[i] < nums2[j]) {
                    nums1[k++] = temp[i++];
                } else {
                    nums1[k++] = nums2[j++];
                }
            }
            while (i < m) {
                nums1[k++] = temp[i++];
            }
            while (j < n) {
                nums1[k++] = nums2[j++];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}