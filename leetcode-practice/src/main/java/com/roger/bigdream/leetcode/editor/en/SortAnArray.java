package com.roger.bigdream.leetcode.editor.en;

//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// 👍 865 👎 380


public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
//        solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        solution.sortArray(new int[]{11, 8, 3, 9, 7, 1, 2, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            //冒泡排序 10 / 13 test cases passed.
            //Status: Time Limit Exceeded
/*            for (int i = 0; i < nums.length; i++) {
                boolean swap = false;
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        swap = true;
                    }
                }
                if (!swap) {
                    break;
                }
            }*/

            //插入排序，优于选择排序
            //Runtime:1362 ms, faster than 10.26% of Java online submissions.
/*            for (int i = 1; i < nums.length; i++) {
                int value = nums[i];
                int j = i - 1;
                for (; j >= 0; --j) {
                    if (nums[j] > value) {
                        nums[j + 1] = nums[j];  // 数据移动
                    } else {
                        break;
                    }
                }
                nums[j + 1] = value; // 插入数据
            }*/

            //归并排序
            //Runtime:258 ms, faster than 22.58% of Java online submissions.
/*            int[] temp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1, temp);*/

            //快速排序
            //Runtime:2126 ms, faster than 5.05% of Java online submissions
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

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

        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            if (left >= right) return;
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }

        private void merge(int[] nums, int left, int mid, int right, int[] temp) {
            System.out.println(left + "," + mid + "," + (mid + 1) + "," + right);
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}