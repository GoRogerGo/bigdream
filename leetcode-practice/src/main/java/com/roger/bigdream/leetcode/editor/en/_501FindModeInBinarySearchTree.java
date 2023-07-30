package com.roger.bigdream.leetcode.editor.en;
//Given the root of a binary search tree (BST) with duplicates, return all the m
//ode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the i
//mplicit stack space incurred due to recursion does not count). Related Topics Tr
//ee Depth-First Search Binary Search Tree Binary Tree 
// 👍 2962 👎 669

import java.util.ArrayList;
import java.util.List;

public class _501FindModeInBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new _501FindModeInBinarySearchTree().new Solution();

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
    /**
     * 我们可以顺序扫描中序遍历序列，用base记录当前的数字，用count记录当前数字重复的次数，用maxCount来维护已经扫描过的数当中出现最多的那个数字的出现次数，用answer 数组记录出现的众数。
     * 每次扫描到一个新的元素：
     * <p>
     * 首先更新base 和count:如果该元素和base 相等，那么count 自增1；
     * 否则将base 更新为当前数字，count 复位为1。
     * 然后更新maxCount：
     * 如果count=maxCount，那么说明当前的这个数字（base）出现的次数等于当前众数出现的次数，将base 加入answer 数组；
     * 如果count>maxCount，那么说明当前的这个数字（base）出现的次数大于当前众数出现的次数，因此，我们需要将maxCount 更新为count，清空answer 数组后将base 加入answer 数组。
     * 我们可以把这个过程写成一个update 函数。这样我们在寻找出现次数最多的数字的时候就可以省去一个哈希表带来的空间消耗。
     * <p>
     * 然后，我们考虑不存储这个中序遍历序列。 如果我们在递归进行中序遍历的过程中，访问当了某个点的时候直接使用上面的update 函数，就可以省去中序遍历序列的空间，代码如下。
     */
    class Solution {

        List<Integer> answer = new ArrayList<Integer>();
        int base, count, maxCount;

        /**
         * 执行耗时:1 ms,击败了71.58% 的Java用户 内存消耗:43.5 MB,击败了97.87% 的Java用户
         * 官网答案，清晰易懂！
         * 2023年07月30日11:13:41
         *
         * @param root
         * @return
         */
        public int[] findMode(TreeNode root) {
            dfs(root);
            int[] result = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                result[i] = answer.get(i);
            }
            return result;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            update(root.val);
            dfs(root.right);
        }

        private void update(int val) {
            if (val == base) {
                count++;
            } else {
                count = 1;
                base = val;
            }
            if (count == maxCount) {
                answer.add(val);
            }
            if (count > maxCount) {
                maxCount = count;
                answer.clear();
                answer.add(val);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}