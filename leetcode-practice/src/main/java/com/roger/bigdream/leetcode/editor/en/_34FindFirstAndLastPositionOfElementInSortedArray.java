package com.roger.bigdream.leetcode.editor.en;
//Given an array of integers nums sorted in non-decreasing order, find the start
//ing and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 16084 👎 378

public class _34FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new _34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] result;
//        result = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        result = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
//        result = solution.searchRange(new int[]{}, 0);
        result = solution.searchRange(new int[]{1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] defaultResult = new int[]{-1, -1};

        /**
         * 考虑target开始和结束位置，其实我们要找的就是数组中「第一个等于target的位置」（记为leftIdx）和「第一个大于target的位置减一」（记为rightIdx）。
         * 二分查找中，寻找leftIdx即为在数组中寻找第一个大于等于target的下标，寻找rightIdx即为在数组中寻找第一个大于target的下标，然后将下标减一。两者的判断条件不同，为了代码的复用，我们定义binarySearch(nums,target,lower)表示在nums数组中二分查找target的位置，如果lower为true，则查找第一个大于等于target的下标，否则查找第一个大于target的下标。
         * 最后，因为target可能不存在数组中，因此我们需要重新校验我们得到的两个下标leftIdx和rightIdx，看是否符合条件，如果符合条件就返回[leftIdx,rightIdx]，不符合就返回[−1,−1]。
         * <p>
         * 2023年07月29日10:34:17
         * 官网答案
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:44.8 MB,击败了6.36% 的Java用户
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            return new int[]{-1, -1};
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:45.9 MB,击败了28.58% 的Java用户
         * 这是三年前的写法，和自己Time Limit Exceeded的思路是一样的，没啥本质区别┭┮﹏┭┮
         * 2023年03月07日11:26:07
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange_11(int[] nums, int target) {
            int[] result = new int[]{-1, -1};
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    while (low <= mid) {
                        if (nums[low] != target) {
                            low++;
                            continue;
                        } else {
                            result[0] = low;
                            break;
                        }
                    }
                    while (high >= mid) {
                        if (nums[high] != target) {
                            high--;
                            continue;
                        } else {
                            result[1] = high;
                            break;
                        }
                    }
                    break;
                }
            }
            return result;
        }

        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:46.2 MB,击败了16.93% 的Java用户
         * 花花的做法，有点新奇，想不到，等到第二次再自己写一遍吧
         * 2023年03月07日11:20:12
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange_huahua(int[] nums, int target) {
            return new int[]{firstPos(nums, target), lastPos(nums, target)};
        }

        int firstPos(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] >= target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            if (l == nums.length || nums[l] != target) return -1;
            return l;
        }

        int lastPos(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] > target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            // l points to the first element this is greater than target.
            --l;
            if (l < 0 || nums[l] != target) return -1;
            return l;
        }

        public int[] searchRange_myself(int[] nums, int target) {
            if (nums.length == 0) return defaultResult;
            return searchRange0(nums, 0, nums.length - 1, target);
        }

        /**
         * 运行失败: Time Limit Exceeded 测试用例:[5,7,7,8,8,10] 6 stdout:
         * 2023年03月07日11:13:46
         *
         * @param nums
         * @param l
         * @param r
         * @param target
         * @return
         */
        private int[] searchRange0(int[] nums, int l, int r, int target) {
            while (l <= r) {
                int midIndex = l + (r - l) / 2;
                if (nums[midIndex] == target) {
                    l = midIndex;
                    r = midIndex;
                    while (l >= 0) {
                        if (nums[l] != target) break;
                        l--;
                    }
                    while (r < nums.length) {
                        if (nums[r] != target) break;
                        r++;
                    }
                    return new int[]{l + 1, r - 1};
                } else if (nums[midIndex] > target) {
                    r = midIndex;
                } else {
                    l = midIndex + 1;
                }
            }
            return defaultResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}