package com.roger.bigdream.leetcode.editor.en;

//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size. 
// Related Topics Hash Table Heap 
// 👍 5049 👎 272


import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 桶排序
         * Runtime:9 ms, faster than 82.48% of Java online submissions.
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums)
                counts.put(num, counts.getOrDefault(num, 0) + 1);

            PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
            for (Integer num : counts.keySet()) {
                queue.offer(new int[]{counts.get(num), num});
                if (queue.size() > k) queue.poll();
            }

            int[] result = new int[k];
            while (k > 0) {
                result[k - 1] = queue.poll()[1];
                k--;
            }
            return result;
        }

        /**
         * Runtime:12 ms, faster than 19.60% of Java online submissions.
         *
         * @param nums
         * @param k
         * @return
         */
        private int[] sameTo692(int[] nums, int k) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums) {
                if (hashMap.containsKey(num)) {
                    hashMap.put(num, hashMap.get(num) + 1);
                } else {
                    hashMap.put(num, 1);
                }
            }
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                queue.add(entry);
                if (queue.size() > k) queue.poll();
            }

            int[] result = new int[k];
            while (k > 0) {
                result[k - 1] = queue.remove().getKey();
                k--;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}