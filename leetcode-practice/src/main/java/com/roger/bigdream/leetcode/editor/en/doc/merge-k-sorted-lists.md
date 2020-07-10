[TOC]
## Solution

---
#### Approach 1: Brute Force

**Intuition & Algorithm**

- Traverse all the linked lists and collect the values of the nodes into an array.
- Sort and iterate over this array to get the proper value of nodes.
- Create a new sorted linked list and extend it with the new nodes.

As for sorting, you can refer [here](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html) for more about sorting algorithms.

```
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        self.nodes = []
        head = point = ListNode(0)
        for l in lists:
            while l:
                self.nodes.append(l.val)
                l = l.next
        for x in sorted(self.nodes):
            point.next = ListNode(x)
            point = point.next
        return head.next
```

**Complexity Analysis**

* Time complexity : ![O(N\logN) ](./p__O_Nlog_N__.png)  where *N* is the total number of nodes.
    - Collecting all the values costs *O(N)* time.
    - A stable sorting algorithm costs ![O(N\logN) ](./p__O_Nlog_N__.png)  time.
    - Iterating for creating the linked list costs *O(N)* time.


* Space complexity : *O(N)*.
    - Sorting cost *O(N)* space (depends on the algorithm you choose).
    - Creating a new linked list costs *O(N)* space.
<br />
<br />
---

#### Approach 2: Compare one by one

**Algorithm**

- Compare every ![\text{k} ](./p__text{k}_.png)  nodes (head of every linked list) and get the node with the smallest value.
- Extend the final sorted linked list with the selected nodes.

![0 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide1.PNG )  ![1 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide2.PNG )  ![2 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide3.PNG )  ![3 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide4.PNG )  ![4 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide5.PNG )  ![5 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide6.PNG )  ![6 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide7.PNG )  ![7 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide8.PNG )  ![8 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide9.PNG )  ![9 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide10.PNG )  ![10 ](https://leetcode.com/problems//Figures/23/23_Merge_listsSlide11.PNG )  

**Complexity Analysis**

* Time complexity : *O(kN)* where ![\text{k} ](./p__text{k}_.png)  is the number of linked lists.
    - Almost every selection of node in final linked costs *O(k)* (![\text{k-1} ](./p__text{k-1}_.png)  times comparison).
    - There are *N* nodes in the final linked list.


* Space complexity :
    - *O(n)* Creating a new linked list costs *O(n)* space.
    - *O(1)* It's not hard to apply in-place method - connect selected nodes instead of creating new nodes to fill the new linked list.
<br />
<br />
---
#### Approach 3: Optimize Approach 2 by Priority Queue

**Algorithm**

Almost the same as the one above but optimize the **comparison process** by **priority queue**. You can refer [here](https://en.wikipedia.org/wiki/Priority_queue) for more information about it.

```
from Queue import PriorityQueue

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = point = ListNode(0)
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put((l.val, l))
        while not q.empty():
            val, node = q.get()
            point.next = ListNode(val)
            point = point.next
            node = node.next
            if node:
                q.put((node.val, node))
        return head.next
```

**Complexity Analysis**

* Time complexity : ![O(N\logk) ](./p__O_Nlog_k__.png)  where ![\text{k} ](./p__text{k}_.png)  is the number of linked lists.
    - The comparison cost will be reduced to ![O(\logk) ](./p__O_log_k__.png)  for every pop and insertion to priority queue. But finding the node with the smallest value just costs *O(1)* time.
    - There are *N* nodes in the final linked list.


* Space complexity :
    - *O(n)* Creating a new linked list costs *O(n)* space.
    - *O(k)* The code above present applies in-place method which cost *O(1)* space. And the priority queue (often implemented with heaps) costs *O(k)* space (it's far less than *N* in most situations).
<br />
<br />
---

#### Approach 4: Merge lists one by one

**Algorithm**

Convert merge ![\text{k} ](./p__text{k}_.png)  lists problem to merge 2 lists (![\text{k-1} ](./p__text{k-1}_.png) ) times. Here is the [merge 2 lists](https://leetcode.com/problems/merge-two-sorted-lists/description/) problem page.


**Complexity Analysis**

* Time complexity : *O(kN)* where ![\text{k} ](./p__text{k}_.png)  is the number of linked lists.
    - We can merge two sorted linked list in *O(n)* time where *n* is the total number of nodes in two lists.
    - Sum up the merge process and we can get:  ![O(\sum_{i=1}^{k-1}(i*(\frac{N}{k})+\frac{N}{k}))=O(kN) ](./p__O_sum_{i=1}^{k-1}__i*_frac{N}{k}__+_frac{N}{k}___=_O_kN__.png) .


* Space complexity : *O(1)*
    - We can merge two sorted linked list in *O(1)* space.
<br />
<br />
---

#### Approach 5: Merge with Divide And Conquer

**Intuition & Algorithm**

This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

  - Pair up ![\text{k} ](./p__text{k}_.png)  lists and merge each pair.

  - After the first pairing, ![\text{k} ](./p__text{k}_.png)  lists are merged into *k/2* lists with average *2N/k* length, then *k/4*, *k/8* and so on.

  -  Repeat this procedure until we get the final sorted linked list.

Thus, we'll traverse almost *N* nodes per pairing and merging, and repeat this procedure about ![\log_{2}{k} ](./p__log_{2}{k}_.png)   times.

 [Divide_and_Conquer](https://leetcode.com/problems//Figures/23/23_divide_and_conquer_new.png)
{align = "center"}


```
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        amount = len(lists)
        interval = 1
        while interval < amount:
            for i in range(0, amount - interval, interval * 2):
                lists[i] = self.merge2Lists(lists[i], lists[i + interval])
            interval *= 2
        return lists[0] if amount > 0 else lists

    def merge2Lists(self, l1, l2):
        head = point = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                point.next = l1
                l1 = l1.next
            else:
                point.next = l2
                l2 = l1
                l1 = point.next.next
            point = point.next
        if not l1:
            point.next=l2
        else:
            point.next=l1
        return head.next
```

**Complexity Analysis**

* Time complexity : ![O(N\logk) ](./p__O_Nlog_k__.png)  where ![\text{k} ](./p__text{k}_.png)  is the number of linked lists.
    - We can merge two sorted linked list in *O(n)* time where *n* is the total number of nodes in two lists.
    - Sum up the merge process and we can get: ![O\big(\sum_{i=1}^{log_{2}{k}}N\big)=O(N\logk) ](./p__Obig_sum_{i=1}^{log_{2}{k}}N_big_=_O_Nlog_k__.png) 


* Space complexity : *O(1)*
    - We can merge two sorted linked lists in *O(1)* space.