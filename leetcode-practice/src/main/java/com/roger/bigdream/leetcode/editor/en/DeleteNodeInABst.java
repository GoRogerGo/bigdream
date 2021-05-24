package com.roger.bigdream.leetcode.editor.en;

//Given a root node reference of a BST and a key, delete the node with the given
// key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages: 
//
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
//
// Follow up: Can you solve it with time complexity O(height of tree)? 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and de
//lete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also
// accepted.
//
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
// 
//
// Example 3: 
//
// 
//Input: root = [], key = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// Each node has a unique value. 
// root is a valid binary search tree. 
// -105 <= key <= 105 
// 
// Related Topics Tree 
// 👍 3000 👎 108


public class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param root
         * @param key
         * @return
         */
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode p = root;
            TreeNode pp = null;
            while (p != null && p.val != key) {
                pp = p;
                if (p.val > key) p = p.left;
                else p = p.right;
            }
            if (p == null) return root;

            // 要删除的节点有两个子节点
            if (p.left != null && p.right != null) {
                TreeNode minP = p.right;
                TreeNode minPP = p;
                while (minP.left != null) {// 查找右子树中最小节点
                    minPP = minP;
                    minP = minP.left;
                }
                p.val = minP.val; // 将minP的数据替换到p中
                p = minP; // 下面就变成了删除minP了
                pp = minPP;
            }

            // 删除节点是叶子节点或者仅有一个子节点
            TreeNode child;
            if (p.left != null) child = p.left;
            else if (p.right != null) child = p.right;
            else child = null;

            // 删除的是根节点
            if (pp == null) root = child; // 删除的是根节点
            else if (pp.left == p) pp.left = child;
            else pp.right = child;
            return root;
        }


    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}