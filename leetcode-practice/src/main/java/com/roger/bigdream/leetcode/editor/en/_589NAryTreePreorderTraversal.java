package com.roger.bigdream.leetcode.editor.en;
//Given the root of an n-ary tree, return the preorder traversal of its nodes' v
//alues. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
//Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// 0 <= Node.val <= 104 
// The height of the n-ary tree is less than or equal to 1000. 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree Depth-First Search 
// 👍 2980 👎 168

import java.util.ArrayList;
import java.util.List;

public class _589NAryTreePreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _589NAryTreePreorderTraversal().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
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
};
*/

    class Solution {
        /**
         * 解答成功:
         * 执行耗时:1 ms,击败了86.76% 的Java用户
         * 内存消耗:44.1 MB,击败了93.48% 的Java用户
         * 2023年07月24日15:41:59
         *
         * @param root
         * @return
         */
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            preorder0(root, result);
            return result;
        }

        private void preorder0(Node node, List<Integer> result) {
            if (node == null) return;
            result.add(node.val);
            for (Node node0 : node.children) {
                preorder0(node0, result);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}