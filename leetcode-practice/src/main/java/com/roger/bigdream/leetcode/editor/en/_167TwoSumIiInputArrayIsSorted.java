package com.roger.bigdream.leetcode.editor.en;
//Given a 1-indexed array of integers numbers that is already sorted in non-decr
//easing order, find two numbers such that they add up to a specific target number
//. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1
// < index2 <= numbers.length. 
//
// Return the indices of the two numbers, index1 and index2, added by one as an 
//integer array [index1, index2] of length 2. 
//
// The tests are generated such that there is exactly one solution. You may not 
//use the same element twice. 
//
// Your solution must use only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We re
//turn [1, 2].
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We ret
//urn [1, 3].
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We r
//eturn [1, 2].
// 
//
// 
// Constraints: 
//
// 
// 2 <= numbers.length <= 3 * 104 
// -1000 <= numbers[i] <= 1000 
// numbers is sorted in non-decreasing order. 
// -1000 <= target <= 1000 
// The tests are generated such that there is exactly one solution. 
// 
// Related Topics Array Two Pointers Binary Search 
// 👍 9138 👎 1191

public class _167TwoSumIiInputArrayIsSorted {

    public static void main(String[] args) {
        Solution solution = new _167TwoSumIiInputArrayIsSorted().new Solution();
//        System.out.println(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
//        System.out.println(solution.twoSum(new int[]{2, 3, 4}, 6));
        System.out.println(solution.twoSum(new int[]{-1, 0}, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:1 ms,击败了99.08% 的Java用户 内存消耗:45.6 MB,击败了21.63% 的Java用
         * 2023年03月25日23:31:34
         * 注意点：①这道题推崇双指针法
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            while (i < j) {
                int m = numbers[i] + numbers[j];
                if (m == target) return new int[]{i + 1, j + 1};
                else if (m > target) j--;
                else i++;
            }
            return new int[]{};
        }

        /**
         * 解答成功: 执行耗时:6 ms,击败了14.61% 的Java用户 内存消耗:45.4 MB,击败了38.54% 的Java用户
         * 二分法效率就是不高，花花的做法。
         * 2023年03月25日23:27:31
         * 注意点：我错误的写法和这个类似，主要差别是l = i + 1;
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSumBinarySearch(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int l = i + 1;
                int r = numbers.length;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (numbers[m] == target - numbers[i]) {
                        return new int[]{i + 1, m + 1};
                    } else if (numbers[m] < target - numbers[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
            }
            return null;
        }

        /**
         * 运行失败: Time Limit Exceeded
         * 测试用例:[3,24,50,79,88,150,345] 200
         * 2023年03月25日23:21:36
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum_myself(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int l = i;
                int r = numbers.length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (numbers[m] == target - numbers[i]) {
                        return new int[]{i + 1, m + 1};
                    } else if (numbers[m] < target - numbers[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}