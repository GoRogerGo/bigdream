package com.roger.bigdream.leetcode.editor.en;
//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// Can you solve it without sorting? 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 14557 👎 711

public class _215KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new _215KthLargestElementInAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 2023年07月23日14:48:31
         * 解答成功: 执行耗时:30 ms,击败了63.62% 的Java用户 内存消耗:54.7 MB,击败了55.19% 的Java用户
         * <p>
         * O(n) 时间复杂度内求无序数组中的第 K 大元素。
         * 比如，4， 2， 5， 12， 3 这样一组数据，第 3 大元素就是 4。
         * 我们选择数组区间 A[0...n-1]的最后一个元素 A[n-1]作为 pivot，对数组 A[0...n-1]原地分区，这样数组就分成了三部分，A[0...p-1]、A[p]、A[p+1...n-1]。
         * 如果 p+1=K，那 A[p]就是要求解的元素；
         * 如果 K>p+1, 说明第 K 大元素出现在 A[p+1...n-1]区间，我们再按照上面的思路递归地在 A[p+1...n-1]这个区间内查找。
         * 如果 K<p+1，那我们就在 A[0...p-1]区间查找。
         */
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length - 1, k);
        }

        private int quickSort(int[] nums, int left, int right, int k) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                return quickSort(nums, left, pivot - 1, k);
            } else {
                return quickSort(nums, pivot + 1, right, k);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int target = nums[right];
            int i = left;
            for (int j = left; j < right; j++) {
                if (nums[j] > target) {
                    // swap A[i] with A[j]
                    swap(nums, i, j);
                    i++;
                }
            }
            // swap A[i] with A[right]
            swap(nums, i, right);
            return i;
        }

        private void swap(int[] nums, int i, int right) {
            int temp = nums[right];
            nums[right] = nums[i];
            nums[i] = temp;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}