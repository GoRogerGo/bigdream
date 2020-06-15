//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer


package com.roger.bigdream.leetcode.editor.en;

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}