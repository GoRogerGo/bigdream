## Solution
---
#### Approach 1: Elementary Math

**Intuition**

Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.

![Illustration of Adding two numbers](https://leetcode.com/problems//Figures/2_add_two_numbers.svg)


*Figure 1. Visualization of the addition of two numbers: *342 + 465 = 807*.  
Each node contains a single digit and the digits are stored in reverse order.*


**Algorithm**

Just like how you would sum two numbers on a piece of paper, we begin by summing the least-significant digits, which is the head of *l1* and *l2*. Since each digit is in the range of ![0\ldots9 ](./p__0_ldots_9_.png) , summing two digits may "overflow". For example *5 + 7 = 12*. In this case, we set the current digit to *2* and bring over the *carry = 1* to the next iteration. *carry* must be either *0* or *1* because the largest possible sum of two digits (including the carry) is *9 + 9 + 1 = 19*.

The pseudocode is as following:

* Initialize current node to dummy head of the returning list.
* Initialize carry to *0*.
* Loop through lists *l1* and *l2* until you reach both ends and carry is *0*.
    * Set *x* to node *l1*'s value. If *l1* has reached the end of *l1*, set to *0*.
    * Set *y* to node *l2*'s value. If *l2* has reached the end of *l2*, set to *0*.
    * Set *sum = x + y + carry*.
    * Update *carry = sum / 10*.
    * Create a new node with the digit value of ![(sum\bmod10) ](./p___sum_bmod_10__.png)  and set it to current node's next, then advance current node to next.
    * Advance both *l1* and *l2*.
* Return dummy head's next node.

Note that we use a dummy head to simplify the code. Without a dummy head, you would have to write extra conditional statements to initialize the head's value.

Take extra caution of the following cases:

| Test case | Explanation |
| ------------- | ---------------- |
| *l1=[0,1]*<br>*l2=[0,1,2]* | When one list is longer than the other. |
| *l1=[]*<br>*l2=[0,1]* | When one list is null, which means an empty list. |
| *l1=[9,9]*<br>*l2=[1]* | The sum could have an extra carry of one at the end, which is easy to forget. |

**Implementation**

```
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummyHead = new ListNode(0);
        ListNode* curr = dummyHead;
        int carry = 0;
        while (l1 != NULL || l2 != NULL || carry != 0) {
            int x = l1 ? l1->val : 0;
            int y = l2 ? l2->val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr->next = new ListNode(sum % 10);
            curr = curr->next;
            l1 = l1 ? l1->next : nullptr;
            l2 = l2 ? l2->next : nullptr;
        }
        return dummyHead->next;
    }
};
```

**Complexity Analysis**

* Time complexity : ![O(\max(m,n)) ](./p__O_max_m,_n___.png) . Assume that *m* and *n* represents the length of *l1* and *l2* respectively, the algorithm above iterates at most ![\max(m,n) ](./p__max_m,_n__.png)  times.

* Space complexity : ![O(\max(m,n)) ](./p__O_max_m,_n___.png) . The length of the new list is at most ![\max(m,n)+1 ](./p__max_m,n__+_1_.png) .

**Follow up**

What if the the digits in the linked list are stored in non-reversed order? For example:

![(3\to4\to2)+(4\to6\to5)=8\to0\to7 ](./p____3_to_4_to_2__+__4_to_6_to_5__=_8_to_0_to_7__.png) 