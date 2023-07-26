package com.roger.bigdream.leetcode.editor.en;
//Given an array of integers nums, sort the array in ascending order and return 
//it. 
//
// You must solve the problem without using any built-in functions in O(nlog(n))
// time complexity and with the smallest space complexity possible. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
//Explanation: After sorting the array, the positions of some numbers are not ch
//anged (for example, 2 and 3), while the positions of other numbers are changed (
//for example, 1 and 5).
// 
//
// Example 2: 
//
// 
//Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
//Explanation: Note that the values of nums are not necessairly unique.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge Sort Bucket Sort Radix Sort Counting Sort
// 👍 5207 👎 701

public class _912SortAnArray {

    public static void main(String[] args) {
        Solution solution = new _912SortAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
//            quickSort(nums, 0, nums.length - 1); 快排
            int[] temp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1, temp);
            return nums;
        }

        /**
         * 解答成功:
         * 执行耗时:41 ms,击败了55.16% 的Java用户
         * 内存消耗:55.2 MB,击败了56.04% 的Java用户
         * <p> 归并排序通过了
         * 2023年07月26日21:30:20
         *
         * @param nums
         * @param left
         * @param right
         * @param temp
         */
        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            if (left >= right) return;
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            // 将A[p...q]和A[q+1...r]合并为A[p...r]
            merge(nums, left, mid, right, temp);
        }

        private void merge(int[] nums, int left, int mid, int right, int[] temp) {
            //将[left,mid]和[mid+1,right]合并到[left,right]
            int i = left;
            int j = mid + 1;
            int k = 0;
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            }
            while (i <= mid) {//将左边剩余元素填充进temp中
                temp[k++] = nums[i++];
            }
            while (j <= right) {//将右序列剩余元素填充进temp中
                temp[k++] = nums[j++];
            }
            k = 0;
            //将temp中的元素全部拷贝到原数组中
            while (left <= right) {
                nums[left++] = temp[k++];
            }
        }

        /**
         * 快排 Time Limit Exceeded
         * 2023年07月26日21:25:56
         *
         * @param nums
         * @param left
         * @param right
         */
        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[right];
            int i = left;
            for (int j = left; j < right; j++) {
                if (nums[j] < pivot) {
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