package com.roger.bigdream.leetcode.editor.en;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public int getVal() {
        return val;
    }

    public List<Node> getChildren() {
        return children;
    }
}
