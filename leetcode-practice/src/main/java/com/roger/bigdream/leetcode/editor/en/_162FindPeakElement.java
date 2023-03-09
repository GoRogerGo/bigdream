package com.roger.bigdream.leetcode.editor.en;
//A peak element is an element that is strictly greater than its neighbors. 
//
// Given a 0-indexed integer array nums, find a peak element, and return its ind
//ex. If the array contains multiple peaks, return the index to any of the peaks. 
//
//
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is a
//lways considered to be strictly greater than a neighbor that is outside the arra
//y. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index num
//ber 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak ele
//ment is 2, or index number 5 where the peak element is 6. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// nums[i] != nums[i + 1] for all valid i. 
// 
// Related Topics Array Binary Search 
// 👍 8680 👎 4215

public class _162FindPeakElement {

    public static void main(String[] args) {
        Solution solution = new _162FindPeakElement().new Solution();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(solution.findPeakElement(new int[]{1, 2}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1}));
        System.out.println(solution.findPeakElement(new int[]{1}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:42.1 MB,击败了27.40% 的Java用户
         * 2023年03月09日17:13:58
         * 感想：仍旧是花花的答案，感觉自己就是废物。看起来很简单，但需要有逻辑推导和计算的，我都是自己想想就算了。。。
         *
         * @param nums
         * @return
         */
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1; // preventing OOB
            while (l < r) {
                int m = l + (r - l) / 2;
                // Find the first m s.t. num[m] > num[m + 1]
                if (nums[m] > nums[m + 1])
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}