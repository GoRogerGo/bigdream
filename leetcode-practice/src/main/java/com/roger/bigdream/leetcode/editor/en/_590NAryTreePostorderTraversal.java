package com.roger.bigdream.leetcode.editor.en;
//Given the root of an n-ary tree, return the postorder traversal of its nodes' 
//values. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
//Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
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
// 👍 2199 👎 92

import java.util.ArrayList;
import java.util.List;

public class _590NAryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new _590NAryTreePostorderTraversal().new Solution();

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
         * 解答成功: 执行耗时:1 ms,击败了83.65% 的Java用户 内存消耗:44.6 MB,击败了34.39% 的Java用户
         * 2023年07月24日15:42:15
         *
         * @param root
         * @return
         */
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            postorder0(root, result);
            return result;
        }

        private void postorder0(Node node, List<Integer> result) {
            if (node == null) return;
            for (Node node0 : node.children) {
                postorder0(node0, result);
            }
            result.add(node.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}