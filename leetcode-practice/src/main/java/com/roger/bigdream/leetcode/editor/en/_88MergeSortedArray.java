package com.roger.bigdream.leetcode.editor.en;
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing ord
//er, and two integers m and n, representing the number of elements in nums1 and n
//ums2 respectively. 
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order. 
//
// The final sorted array should not be returned by the function, but instead be
// stored inside the array nums1. To accommodate this, nums1 has a length of m + n
//, where the first m elements denote the elements that should be merged, and the 
//last n elements are set to 0 and should be ignored. nums2 has a length of n. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming f
//rom nums1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there t
//o ensure the merge result can fit in nums1.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[j] <= 109 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(m + n) time? 
// Related Topics Array Two Pointers Sorting 
// 👍 9561 👎 894

public class _88MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new _88MergeSortedArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.5 MB,击败了43.49% 的Java用户
         * 2023年03月07日20:09:08
         * 感受：毫无想法，花花的解法真是天才！它是从后往前copy的。
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int tail = m + n - 1;
            while (j >= 0) {
                nums1[tail--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}