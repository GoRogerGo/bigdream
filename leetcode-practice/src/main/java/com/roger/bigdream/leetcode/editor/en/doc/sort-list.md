[TOC]

## Solution
---

#### Overview ####

The problem is to sort the linked list in ![\mathcal{O}(n\logn) ](./p__mathcal{O}_n_log_n__.png)  time and using only constant extra space. If we look at various sorting algorithms, [Merge Sort](https://en.wikipedia.org/wiki/Merge_sort) is one of the efficient sorting algorithms that is popularly used for sorting the linked list. The merge sort algorithm runs in ![\mathcal{O}(n\logn) ](./p__mathcal{O}_n_log_n__.png)  time in all the cases. Let's discuss approaches to sort linked list using merge sort.

> [Quicksort](https://en.wikipedia.org/wiki/Quicksort) is also one of the efficient algorithms with the average time complexity of ![\mathcal{O}(n\logn) ](./p__mathcal{O}_n_log_n__.png) . But the worst-case time complexity is ![\mathcal{O}(n^{2}) ](./p__mathcal{O}_n_^{2}__.png) . Also, variations of the quick sort like randomized quicksort are not efficient for the linked list because unlike arrays, random access in the linked list is not possible in ![\mathcal{O}(1) ](./p__mathcal{O}_1__.png)  time.
If we sort the linked list using quicksort, we would end up using the head as a pivot element which may not be efficient in all scenarios.
---

#### Approach 1: Top Down Merge Sort

**Intuition**

Merge sort is a popularly known algorithm that follows the[ Divide and Conquer Strategy](https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm). The divide and conquer strategy can be split into 2 phases:

 _Divide phase_: Divide the problem into subproblems.

_Conquer phase_: Repeatedly solve each subproblem independently and combine the result to form the original problem.

The Top Down approach for merge sort recursively splits the original list into sublists of equal sizes, sorts each sublist independently, and eventually merge the sorted lists.  Let's look at the algorithm to implement merge sort in Top Down Fashion.

**Algorithm**

- Recursively split the original list into two halves. The split continues until there is only one node in the linked list (Divide phase). To split the list into two halves, we find the middle of the linked list using the Fast and Slow pointer approach as mentioned in [Find Middle Of Linked List](https://leetcode.com/problems/middle-of-the-linked-list/).

- Recursively sort each sublist and combine it into a single sorted list. (Merge Phase). This is similar to the problem [Merge two sorted linked lists](https://leetcode.com/problems/merge-two-sorted-lists/)


The process continues until we get the original list in sorted order.

For the linked list = `[10,1,60,30,5]`, the following figure illustrates the merge sort process using a top down approach.

![img](https://leetcode.com/problems//Figures/148/topDown_merge_sort.png)

If we have sorted lists, list1 = `[1,10]` and list2 = `[5,30,60]`. The following animation illustrates the merge process of both lists into a single sorted list.

![0 ](https://leetcode.com/problems//Figures/148/slide_1.png )  ![1 ](https://leetcode.com/problems//Figures/148/slide_2.png )  ![2 ](https://leetcode.com/problems//Figures/148/slide_3.png )  ![3 ](https://leetcode.com/problems//Figures/148/slide_4.png )  ![4 ](https://leetcode.com/problems//Figures/148/slide_5.png )  ![5 ](https://leetcode.com/problems//Figures/148/slide_6.png )  ![6 ](https://leetcode.com/problems//Figures/148/slide_7.png )  ![7 ](https://leetcode.com/problems//Figures/148/slide_8.png )  ![8 ](https://leetcode.com/problems//Figures/148/slide_9.png )  

```

class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next)
            return head;
        ListNode* mid = getMid(head);
        ListNode* left = sortList(head);
        ListNode* right = sortList(mid);
        return merge(left, right);
    }

    ListNode* merge(ListNode* list1, ListNode* list2) {
        ListNode dummyHead(0);
        ListNode* ptr = &dummyHead;
        while (list1 && list2) {
            if (list1->val < list2->val) {
                ptr->next = list1;
                list1 = list1->next;
            } else {
                ptr->next = list2;
                list2 = list2->next;
            }
            ptr = ptr->next;
        }
        if(list1) ptr->next = list1;
        else ptr->next = list2;

        return dummyHead.next;
    }

    ListNode* getMid(ListNode* head) {
        ListNode* midPrev = nullptr;
        while (head && head->next) {
            midPrev = (midPrev == nullptr) ? head : midPrev->next;
            head = head->next->next;
        }
        ListNode* mid = midPrev->next;
        midPrev->next = nullptr;
        return mid;
    }
};

```

**Complexity Analysis**

* Time Complexity: ![\mathcal{O}(n\logn) ](./p__mathcal{O}_n_log_n__.png) , where *n* is the number of nodes in linked list.
The algorithm can be split into 2 phases, Split and Merge.

Let's assume that *n* is power of *2*. For `n = 16`, the split and merge operation in  Top Down fashion can be visualized as follows

![img](https://leetcode.com/problems//Figures/148/top_down_time_complexity.png)

**_Split_**

The recursion tree expands in form of a complete binary tree, splitting the list into two halves recursively. The number of levels in a complete binary tree is given by ![\log_{2}n ](./p__log_{2}_n_.png) . For *n=16*, number of splits = ![\log_{2}16=4 ](./p__log_{2}_16_=_4_.png) 

**_Merge_**  

At each level, we merge n nodes which takes ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png)  time.
For *n = 16*, we perform merge operation on *16* nodes in each of the *4* levels.

So the time complexity for split and merge operation is ![\mathcal{O}(n\logn) ](./p__mathcal{O}_n_log_n__.png) 

* Space Complexity: ![\mathcal{O}(\logn) ](./p__mathcal{O}_log_n__.png)  , where *n* is the number of nodes in linked list. Since the problem is recursive, we need additional space to store the recursive call stack. The maximum depth of the recursion tree is ![\logn ](./p__log_n_.png) 

---

#### Approach 2: Bottom Up Merge Sort

**Intuition**

The Top Down Approach for merge sort uses ![\mathcal{O}(\logn) ](./p__mathcal{O}_log_n__.png)  extra space due to recursive call stack. Let's understand how we can implement merge sort using constant extra space using Bottom Up Approach.

The Bottom Up approach for merge sort starts by splitting the problem into the smallest subproblem and iteratively merge the result to solve the original problem.
- First, the list is split into sublists of size 1 and merged iteratively in sorted order. The merged list is solved similarly.

- The process continues until we sort the entire list.

This approach is solved iteratively and can be implemented using constant extra space. Let's look at the algorithm to implement merge sort in Bottom Up Fashion.


**Algorithm**

Assume, *n* is the number of nodes in the linked list.
- Start with splitting the list into sublists of size *1*. Each adjacent pair of sublists of size *1* is merged in sorted order. After the first iteration, we get the sorted lists of size *2*. A similar process is repeated for a sublist of size *2*. In this way, we iteratively split the list into sublists of size *1,2,4,8 ..* and so on until we reach *n*.

- To split the list into two sublists of given ![\text{size} ](./p__text{size}_.png)  beginning from ![\text{start} ](./p__text{start}_.png) , we use two pointers, ![\text{mid} ](./p__text{mid}_.png)  and ![\text{end} ](./p__text{end}_.png)  that references to the start and end of second linked list respectively. The split process finds the middle of linked lists for the given ![\text{size} ](./p__text{size}_.png) .

- Merge the lists in sorted order as discussed in  _Approach 1_

- As we iteratively split the list and merge, we have to keep track of the previous merged list using pointer ![\text{tail} ](./p__text{tail}_.png)  and the next sublist to be sorted using pointer ![\text{nextSubList} ](./p__text{nextSubList}_.png) .

For the linked list = `[10,1,30,2,5]`, the following figure illustrates the merge sort process using a Bottom Up approach.

![img](https://leetcode.com/problems//Figures/148/bottom_up_merge_sort.png)


```

class Solution {
public:
    ListNode* tail = new ListNode();
    ListNode* nextSubList = new ListNode();

    ListNode* sortList(ListNode* head) {
        if (!head || !head -> next)
            return head;
        int n = getCount(head);
        ListNode* start = head;
        ListNode dummyHead(0);
        for (int size = 1; size < n; size = size * 2) {
            tail = &dummyHead;
            while (start) {
                if (!start->next) {
                    tail->next = start;
                    break;
                }
                ListNode* mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    ListNode* split(ListNode* start, int size) {
        ListNode* midPrev = start;
        ListNode* end = start->next;
        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev->next || end->next); index++) {
            if (end->next) {
                end = (end->next->next) ? end->next->next : end->next;
            }
            if (midPrev->next) {
                midPrev = midPrev->next;
            }
        }
        ListNode* mid = midPrev->next;
        nextSubList = end->next;
        midPrev->next = nullptr;
        end->next = nullptr;
        // return the start of second linked list
        return mid;
    }

    void merge(ListNode* list1, ListNode* list2) {
        ListNode dummyHead(0);
        ListNode* newTail = &dummyHead;
        while (list1 && list2) {
            if (list1->val < list2->val) {
                newTail->next = list1;
                list1 = list1->next;
                newTail = newTail->next;
            } else {
                newTail->next = list2;
                list2 = list2->next;
                newTail = newTail->next;
            }
        }
        newTail->next = (list1) ? list1 : list2;
        // traverse till the end of merged list to get the newTail
        while (newTail->next) {
            newTail = newTail->next;
        }
        // link the old tail with the head of merged list
        tail->next = dummyHead.next;
        // update the old tail with the new tail of merged list
        tail = newTail;
    }

    int getCount(ListNode* head) {
        int cnt = 0;
        ListNode* ptr = head;
        while (ptr) {
            ptr = ptr->next;
            cnt++;
        }
        return cnt;
    }
};

```

**Complexity Analysis**

* Time Complexity: ![\mathcal{O}(n\logn) ](./p__mathcal{O}_n_log_n__.png) , where *n* is the number of nodes in linked list.
 Let's analyze the time complexity of each step:

1) Count Nodes - Get the count of number nodes in the linked list requires ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png)  time.

2) Split and Merge - This operation is similar to _Approach 1_ and takes  ![\mathcal{O}(n\logn) ](./p___mathcal{O}_n_log_n__.png)  time.
For `n = 16`, the split and merge operation in Bottom Up fashion can be visualized as follows

![img](https://leetcode.com/problems//Figures/148/bottom_up_time_complexity.png)

This gives us total time complexity as
![\mathcal{O}(n)+\mathcal{O}(n\logn)=\mathcal{O}(n\logn) ](./p__mathcal{O}_n__+_mathcal{O}_n_log_n__=_mathcal{O}_n_log_n__.png) 

* Space Complexity: ![\mathcal{O}(1) ](./p__mathcal{O}_1__.png)  We use only constant space for storing the reference pointers  ![\text{tail} ](./p__text{tail}_.png)  , ![\text{nextSubList} ](./p__text{nextSubList}_.png)  etc.