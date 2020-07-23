//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possi
//ble order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its correspond
//ing outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array 
// 👍 3450 👎 1250


package com.roger.bigdream.leetcode.editor.en;

import java.util.Arrays;

class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
//        solution.nextPermutation(new int[]{1, 2, 3});
//        solution.nextPermutation(new int[]{3, 2, 1});
//        solution.nextPermutation(new int[]{1, 1, 5});
//        solution.nextPermutation(new int[]{1, 3, 2});
//        solution.nextPermutation(new int[]{2, 3, 1});
//        solution.nextPermutation(new int[]{5, 1, 1});
        solution.nextPermutation(new int[]{5, 4, 7, 5, 3, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         * Memory Usage:39.9 MB, less than 15.28% of Java online submissions.
         *
         * @param nums
         */
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            // 倒着来，先找到前一个数比后一个数小的
            while (i >= 0 && nums[i + 1] <= nums[i]) {// 后一个数比前一个数小，继续遍历
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                // 倒着来，先找到i右边第一个比num[i]大的数
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                // 交换这个两数字(只要能进入这个if，说明一定有后一个数比前一个数大的)
                swap(nums, i, j);
            }
            // i以后的数字进行翻转
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int low = start, high = nums.length - 1;
            while (low < high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private void myWrongAnswer(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                swap2num(nums, i);
                return;
            }
            if (i > 1 && nums[i] < nums[i - 1]) {
                if (nums[i] > nums[i - 2]) {
                    swap3num_1(nums, i);
                    return;
                }
                if (nums[i] < nums[i - 2]) {
                    if (nums[i - 2] < nums[i - 1]) {
                        swap3num_2(nums, i);
                        return;
                    } else {
                        Arrays.sort(nums);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap3num_2(int[] nums, int i) {
        int temp = nums[i - 2];
        nums[i - 2] = nums[i - 1];
        nums[i - 1] = nums[i];
        nums[i] = temp;
    }

    private void swap3num_1(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = nums[i - 2];
        nums[i - 2] = temp;
    }

    private void swap2num(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp;
    }
}