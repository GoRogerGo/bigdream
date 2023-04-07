[TOC]

## Solution
---
#### Approach 1: Sliding Window

**Intuition**

For convenience, let's denote subarrays by tuples: `(i,j) = [A[i], A[i+1], ..., A[j]]`, and call a subarray *valid* if it has `K` different integers.

For each `j`, let's consider the set *S_j* of all `i` such that the subarray `(i, j)` is valid.

Firstly, *S_j* must be a contiguous interval.  If `i1 < i2 < i3`, `(i1,j)` and `(i3,j)` are valid, but `(i2,j)` is not valid, this is a contradiction because `(i2,j)` must contain more than `K` different elements [as `(i3,j)` contains `K`], but `(i1,j)` [which is a superset of `(i2,j)`] only contains `K` different integers.

So now let's write *S_j* as intervals: ![S_j=\[\text{left1}_j,\text{left2}_j\] ](./p__S_j_=__text{left1}_j,_text{left2}_j__.png) .

The second observation is that the endpoints of these intervals must be monotone increeasing - namely, ![\text{left1}_j ](./p__text{left1}_j_.png)  and ![\text{left2}_j ](./p__text{left2}_j_.png)  are monotone increasing.  With similar logic to the above, we could construct a proof of this fact, but the intuition is that after adding an extra element to our subarrays, they are already valid, or we need to shrink them a bit to keep them valid.

**Algorithm**

We'll maintain two sliding windows, corresponding to ![\text{left1}_j ](./p__text{left1}_j_.png)  and ![\text{left2}_j ](./p__text{left2}_j_.png) .  Each sliding window will be able to count how many different elements there are in the window, and add and remove elements in a queue-like fashion.

```
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            window1.add(x);
            window2.add(x);

            while (window1.different() > K)
                window1.remove(A[left1++]);
            while (window2.different() >= K)
                window2.remove(A[left2++]);

            ans += left2 - left1;
        }

        return ans;
    }
}

class Window {
    Map<Integer, Integer> count;
    int nonzero;

    Window() {
        count = new HashMap();
        nonzero = 0;
    }

    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }

    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }

    int different() {
        return nonzero;
    }
}
```

**Complexity Analysis**

* Time Complexity:  *O(N)*, where *N* is the length of `A`.

* Space Complexity:  *O(N)*.
<br />
<br />