package com.roger.bigdream.leetcode.editor.en;

//Given a non-empty list of words, return the k most frequent elements. 
// Your answer should be sorted by frequency from highest to lowest. If two word
//s have the same frequency, then the word with the lower alphabetical order comes
// first. 
//
// Example 1: 
// 
//Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//Output: ["i", "love"]
//Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
// 
// 
//
// Example 2: 
// 
//Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
//, k = 4
//Output: ["the", "is", "sunny", "day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
// 
// 
//
// Note: 
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Input words contain only lowercase letters. 
// 
// 
//
// Follow up: 
// 
// Try to solve it in O(n log k) time and O(n) extra space. 
// 
// Related Topics Hash Table Heap Trie 
// 👍 3049 👎 201


import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
//        solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
//        solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        solution.topKFrequent(new String[]{"glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx", "qrkgmliewc", "zskaqzwo", "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc", "qkjzgws", "fqizrrnmif", "jqrlad", "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk", "glarko", "hdemkfr", "axyak", "hdemkfr", "nsfspyox", "nsfspyox", "qrkgmliewc", "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy", "glarko", "nbuorw", "nsfspyox", "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc", "jqrlad", "nftk", "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay", "nsfspyox", "zskaqzwo", "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb", "pwqvwmlgri", "zskaqzwo", "qengse", "glarko", "qkjzgws", "pwqvwmlgri", "fqizrrnmif", "nbuorw", "nftk", "ijy", "hdemkfr", "nftk", "qkjzgws", "jqrlad", "nftk", "ccjel", "qggx", "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg", "qengse", "fqizrrnmif", "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri", "htpvnmozay", "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx", "zlfiwwb", "bwp", "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx", "zlfiwwb", "nsfspyox", "ijy", "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko", "hdemkfr", "pwqvwmlgri"}, 14);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Runtime:5 ms, faster than 83.66% of Java online submissions.
         *
         * @param words
         * @param k
         * @return
         */
        public List<String> topKFrequent(String[] words, int k) {
            // step1: count word by freq using hashtable O(n)
            Map<String, Integer> hashMap = new HashMap<>();
            for (String word : words) {
                int count = null == hashMap.get(word) ? 0 : hashMap.get(word);
                hashMap.put(word, ++count);
            }
            // step2: add each element to a min heap with k max elements O(n*logk)
            PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(k,
                    (a, b) -> a.getValue() - b.getValue() != 0 ? a.getValue() - b.getValue() : b.getKey().compareTo(a.getKey()));
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                priorityQueue.add(entry);
                if (priorityQueue.size() > k) priorityQueue.poll();
            }
            // step3: extract mins from the heap and reverse the result O(n*logk)
            List<String> result = new ArrayList<>();
            while (k > 0) {
                result.add(0, priorityQueue.remove().getKey());
                k--;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}