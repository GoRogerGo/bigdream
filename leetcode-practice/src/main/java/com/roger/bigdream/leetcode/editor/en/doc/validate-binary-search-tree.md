[TOC]

## Video Solution

---

<div class='video-preview'></div>

<div>&nbsp;
</div>

## Solution Article

---

#### Tree definition

First of all, here is the definition of the ```TreeNode``` which we would use.

```
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
};
```
<br />
<br />


---
#### Intuition

On the first sight, the problem is trivial. Let's traverse the tree
and check at each step if `node.right.val > node.val` and
`node.left.val < node.val`. This approach would even work for some
trees
![compute](https://leetcode.com/problems//Figures/98/98_not_bst.png)

The problem is this approach will not work for all cases.
Not only the right child should be larger than the node
but all the
elements in the right subtree. Here is an example :

![compute](https://leetcode.com/problems//Figures/98/98_not_bst_3.png)

That means one should keep both upper
and lower limits for each node while traversing the tree,
and compare the node value not
with children values but with these limits.
<br />
<br />


---
#### Approach 1: Recursive Traversal with Valid Range

The idea above could be implemented as a recursion.
One compares the node value with its upper and lower limits
if they are available. Then one repeats the same
step recursively for left and right subtrees.

![0 ](https://leetcode.com/problems//Figures/98/98_slide_1.png )  ![1 ](https://leetcode.com/problems//Figures/98/98_slide_2.png )  ![2 ](https://leetcode.com/problems//Figures/98/98_slide_3.png )  ![3 ](https://leetcode.com/problems//Figures/98/98_slide_4.png )  

```
class Solution {
public:
    bool validate(TreeNode* root, TreeNode* low, TreeNode* high) {
        // Empty trees are valid BSTs.
        if (root == nullptr) {
            return true;
        }

        // The current node's value must be between low and high.
        if ((low != nullptr and root->val <= low->val) or
            (high != nullptr and root->val >= high->val)) {
            return false;
        }

        // The left and right subtree must also be valid.
        return validate(root->right, root, high) and
               validate(root->left, low, root);
    }

    bool isValidBST(TreeNode* root) {
        return validate(root, nullptr, nullptr);
    }
};
```

**Complexity Analysis**

* Time complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  since we visit each node exactly once.
* Space complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  since we keep up to the entire tree.

<br />
<br />


---
#### Approach 2: Iterative Traversal with Valid Range

The above recursion could be converted into iteration,
with the help of an explicit stack. DFS would be better than BFS since
it works faster here.

```
class Solution {
private:
    stack<TreeNode*> stk, lower_limits, upper_limits;

public:
    void update(TreeNode* root, TreeNode* low, TreeNode* high) {
        stk.push(root);
        lower_limits.push(low);
        upper_limits.push(high);
    }
    bool isValidBST(TreeNode* root) {
        TreeNode* low = nullptr;
        TreeNode* high = nullptr;
        update(root, low, high);

        while (!stk.empty()) {
            root = stk.top();
            stk.pop();
            low = lower_limits.top();
            lower_limits.pop();
            high = upper_limits.top();
            upper_limits.pop();

            if (root == nullptr) {
                continue;
            }

            TreeNode* val_node = root;
            if (low != nullptr and val_node->val <= low->val) {
                return false;
            }
            if (high != nullptr and val_node->val >= high->val) {
                return false;
            }
            update(root->right, val_node, high);
            update(root->left, low, val_node);
        }
        return true;
    }
};
```

**Complexity Analysis**

* Time complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  since we visit each node exactly once.
* Space complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  since we keep up to the entire tree.

<br />
<br />

---

#### Approach 3: Recursive Inorder Traversal

**Algorithm**

Let's use the order of nodes in the
[inorder traversal](https://leetcode.com/articles/binary-tree-inorder-traversal/)
`Left -> Node -> Right`.

![postorder](https://leetcode.com/problems//Figures/145_transverse.png)

Here the nodes are enumerated in the order you visit them,
and you could follow `1-2-3-4-5` to compare different strategies.

`Left -> Node -> Right` order of inorder traversal
means for BST that each element should be smaller
than the next one.

Hence the algorithm with ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  time complexity
and ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  space complexity could be simple:

- Compute inorder traversal list `inorder`.

- Check if each element in `inorder` is smaller than the next one.

![postorder](https://leetcode.com/problems//Figures/98/98_bst_inorder.png)

> Do we need to keep the whole `inorder` traversal list?

Actually, no. The last added inorder element is enough
to ensure at each step that the tree is BST (or not).
Hence one could merge both steps into one and
reduce the used space.

**Code**

We can implement the algorithm recursively.

```
class Solution {
private:
    TreeNode* prev = nullptr;

public:
    bool isValidBST(TreeNode* root) {
        return inorder(root);
    }

    bool inorder(TreeNode* root) {
        if (root == nullptr) {
            return true;
        }
        if (!inorder(root->left)) {
            return false;
        }
        if (prev != nullptr && root->val <= prev->val) {
            return false;
        }
        prev = root;
        return inorder(root->right);
    }
};
```

**Complexity Analysis**

* Time complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  in the worst case
when the tree is a BST or the "bad" element is a rightmost leaf.

* Space complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  for the space on the run-time stack.

<br />
<br />

---

#### Approach 4: Iterative Inorder Traversal

Alternatively, we could implement the above algorithm iteratively.

```
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> stk;
        TreeNode* prev = nullptr;

        while (!stk.empty() or root != nullptr) {
            while (root != nullptr) {
                stk.push(root);
                root = root->left;
            }
            root = stk.top();
            stk.pop();

            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (prev != nullptr and root->val <= prev->val) {
                return false;
            }
            prev = root;
            root = root->right;
        }
        return true;
    }
};
```

**Complexity Analysis**

* Time complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  in the worst case
when the tree is BST or the "bad" element is a rightmost leaf.

* Space complexity : ![\mathcal{O}(N) ](./p__mathcal{O}_N__.png)  to keep `stack`.