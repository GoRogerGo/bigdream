package com.roger.bigdream.leetcode.editor.en;
//You are given a sorted integer array arr containing 1 and prime numbers, where
// all the integers of arr are unique. You are also given an integer k. 
//
// For every i and j where 0 <= i < j < arr.length, we consider the fraction arr
//[i] / arr[j]. 
//
// Return the kth smallest fraction considered. Return your answer as an array o
//f integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j]. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,5], k = 3
//Output: [2,5]
//Explanation: The fractions to be considered in sorted order are:
//1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
//The third fraction is 2/5.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,7], k = 1
//Output: [1,7]
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 104 
// arr[0] == 1 
// arr[i] is a prime number for i > 0. 
// All the numbers of arr are unique and sorted in strictly increasing order. 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
//
// 
//Follow up: Can you solve the problem with better than O(n2) complexity? Relate
//d Topics Array Binary Search Sorting Heap (Priority Queue) 
// 👍 1055 👎 47

/**
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * <p>
 * 对于每对满足 0 <= i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * <p>
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _786KThSmallestPrimeFraction {

    public static void main(String[] args) {
        Solution solution = new _786KThSmallestPrimeFraction().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}