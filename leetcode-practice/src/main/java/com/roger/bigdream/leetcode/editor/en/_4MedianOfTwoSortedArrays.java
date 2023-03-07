package com.roger.bigdream.leetcode.editor.en;
//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics Array Binary Search Divide and Conquer 
// 👍 22381 👎 2516

public class _4MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new _4MedianOfTwoSortedArrays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:2 ms,击败了100.00% 的Java用户 内存消耗:43.6 MB,击败了30.88% 的Java用户
         * 2023年03月07日20:35:18
         * 另一个博主的解法，有讲解，下次可以尝试写写
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 保证nums1长度<=nums2长度
            // 推论1：在nums1的区间[0,m]里查找恰当的分割线。
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            // 分割线将两个数组分割开来，总长度为奇数则左边多一个，为偶数则两边个数一样多。
            // 推论1：分割线左边的所有元素要满足的个数是(m+n+1)/2
            int m = nums1.length;
            int n = nums2.length;
            int totalLeft = (m + n + 1) / 2;

            // 推论2：将分割线右边的数字下标分别定义为i,j，那么nums1[i-1]<=nums2[j] && nums2[j-1]<=nums1[i]
            int left = 0;
            int right = m;
            while (left < right) {
                int i = (left + right + 1) / 2;
                int j = totalLeft - i;
                if (nums1[i - 1] > nums2[j]) {
                    // 说明分割线在nums1取大了，分割线要向左移，下一轮搜索区间应该是[left, i-1]
                    right = i - 1;
                } else {
                    // 说明分割线在nums2取小了，分割线要向由移，下一轮搜索区间应该是[i, right]
                    left = i;
                }
            }

            // 厘清楚分割线两侧的四个数字
            int i = left;
            int j = totalLeft - i;
            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

            // 计算最后的中位数
            if ((m + n) % 2 == 0) {
                return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
            } else {
                return Math.max(nums1LeftMax, nums2LeftMax);
            }
        }

        /**
         * 解答成功: 执行耗时:2 ms,击败了100.00% 的Java用户 内存消耗:43.4 MB,击败了41.45% 的Java用户
         * 2023年03月07日20:32:09
         * 花花的解法，没有讲解，完全不懂
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays_huahua(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1 > n2)
                return findMedianSortedArrays_huahua(nums2, nums1);

            int k = (n1 + n2 + 1) / 2;
            int l = 0;
            int r = n1;

            while (l < r) {
                int m1 = l + (r - l) / 2;
                int m2 = k - m1;
                if (nums1[m1] < nums2[m2 - 1])
                    l = m1 + 1;
                else
                    r = m1;
            }

            int m1 = l;
            int m2 = k - l;

            int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                    m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

            if ((n1 + n2) % 2 == 1)
                return c1;

            int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                    m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

            return (c1 + c2) * 0.5;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}