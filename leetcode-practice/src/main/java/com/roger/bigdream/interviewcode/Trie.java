package com.roger.bigdream.interviewcode;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * <p>
 * void insert(String word) 向前缀树中插入字符串 word 。
 * <p>
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * <p>
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    //    private Trie next;
    private Trie[] children;
    //    private char value;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
    }

    void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            Trie trie = node.children[c - 'a'];
            if (null == trie) {
                node.children[c - 'a'] = new Trie();
                node = node.children[c - 'a'];
            } else {
                node = trie;
            }
        }
        isEnd = node.children.length == 0;
    }

    boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }
        return node.isEnd;
    }

    boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }
        return true;
    }
}
