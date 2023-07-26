package com.roger.bigdream.leetcode.editor.en;
//A trie (pronounced as "try") or prefix tree is a tree data structure used to e
//fficiently store and retrieve keys in a dataset of strings. There are various ap
//plications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (i
//.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously inser
//ted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 104 calls in total will be made to insert, search, and startsWith
//. 
// 
// Related Topics Hash Table String Design Trie 
// 👍 10548 👎 119

public class _208ImplementTriePrefixTree {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        /**
         * 解答成功:
         * 执行耗时:38 ms,击败了82.31% 的Java用户
         * 内存消耗:54.6 MB,击败了85.92% 的Java用户
         * 2023年07月26日16:48:57
         * 看极客讲义直接抄的
         */

        class TrieNode {
            public char data;
            public TrieNode[] children = new TrieNode[26];
            public boolean isEndingChar = false;

            public TrieNode(char data) {
                this.data = data;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode('/'); // 存储无意义字符
        }

        public void insert(String word) {
            TrieNode p = root;
            char[] text = word.toCharArray();
            for (int i = 0; i < text.length; ++i) {
                int index = text[i] - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(text[i]);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndingChar = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            char[] pattern = word.toCharArray();
            for (int i = 0; i < pattern.length; ++i) {
                int index = pattern[i] - 'a';
                if (p.children[index] == null) {
                    return false; // 不存在pattern
                }
                p = p.children[index];
            }
            if (p.isEndingChar == false) return false;// 不能完全匹配，只是前缀
            else return true; // 找到pattern
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)


}