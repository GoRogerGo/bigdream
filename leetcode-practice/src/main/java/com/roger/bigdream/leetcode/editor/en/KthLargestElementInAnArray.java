package com.roger.bigdream.leetcode.editor.en;

//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
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
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics Divide and Conquer Heap 
// 👍 5664 👎 361


import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            /**
             * Runtime:3 ms, faster than 66.20% of Java online submissions
             */
/*            PriorityQueue<Integer> queue = new PriorityQueue<>(k);
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.add(num);
                } else if (queue.peek() < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
            return queue.poll();*/

            /**
             * Runtime:17 ms, faster than 12.08% of Java online submissions.
             */
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
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                }
            }
            int temp = nums[right];
            nums[right] = nums[i];
            nums[i] = temp;
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}