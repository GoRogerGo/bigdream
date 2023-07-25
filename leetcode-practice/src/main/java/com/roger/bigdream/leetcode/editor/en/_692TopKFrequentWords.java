package com.roger.bigdream.leetcode.editor.en;
//Given an array of strings words and an integer k, return the k most frequent s
//trings. 
//
// Return the answer sorted by the frequency from highest to lowest. Sort the wo
//rds with the same frequency by their lexicographical order. 
//
// 
// Example 1: 
//
// 
//Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//Output: ["i","love"]
//Explanation: "i" and "love" are the two most frequent words.
//Note that "i" comes before "love" due to a lower alphabetical order.
// 
//
// Example 2: 
//
// 
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"],
// k = 4
//Output: ["the","is","sunny","day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
//with the number of occurrence being 4, 3, 2 and 1 respectively.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i].length <= 10 
// words[i] consists of lowercase English letters. 
// k is in the range [1, The number of unique words[i]] 
// 
//
// 
// Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space? 
// Related Topics Hash Table String Trie Sorting Heap (Priority Queue) Bucket So
//rt Counting 
// 👍 7165 👎 333

import java.util.*;

public class _692TopKFrequentWords {

    public static void main(String[] args) {
        Solution solution = new _692TopKFrequentWords().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功:
         * 执行耗时:6 ms,击败了88.32% 的Java用户
         * 内存消耗:44.1 MB,击败了26.93% 的Java用户
         * <p>
         * 2023年07月25日11:04:15
         *
         * @param words
         * @param k
         * @return
         */
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> occurrences = new HashMap<>();
            for (String word : words) {
                occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<Data> priorityQueue = new PriorityQueue<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.getCount() == o2.getCount() ? o2.getWord().compareTo(o1.getWord()) : o1.getCount() - o2.getCount();
                }
            });
            for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
                String word = entry.getKey();
                Integer count = entry.getValue();
                priorityQueue.offer(new Data(word, count));
                if (k < priorityQueue.size()) {
                    priorityQueue.poll();
                }
            }
            List<java.lang.String> result = new ArrayList<>();
            while (!priorityQueue.isEmpty()) {
                result.add(priorityQueue.poll().getWord());
            }
            Collections.reverse(result); //加这行代码
            return result;
        }
    }

    class Data {
        private String word;
        private Integer count;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Data(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}