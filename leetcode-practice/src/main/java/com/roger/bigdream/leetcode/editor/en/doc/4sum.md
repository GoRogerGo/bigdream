[TOC]

## Solution

This problem is a follow-up of [3Sum](https://leetcode.com/articles/3sum/), so take a look at that problem first if you haven't. 4Sum and 3Sum are very similar; the difference is that we are looking for unique quadruplets instead of triplets.

As you see, 3Sum just wraps Two Sum in an outer loop. As it iterates through each value `v`, it finds all pairs whose sum is equal to `target - v` using one of these approaches:

1. [Two Sum](https://leetcode.com/articles/two-sum/) uses a hash set to check for a matching value.
2. [Two Sum II](https://leetcode.com/articles/two-sum-ii-input-array-is-sorted/) uses the two pointers pattern in a sorted array.

Following a similar logic, we can implement 4Sum by wrapping 3Sum in another loop. But wait - there is a catch. If an interviewer asks you to solve 4Sum, they can follow-up with 5Sum, 6Sum, and so on. What they are really expecting at this point is a kSum solution. Therefore, we will focus on a generalized implementation here.

---

#### Approach 1: Two Pointers

The two pointers pattern requires the array to be sorted, so we do that first.  Also, it's easier to deal with duplicates if the array is sorted: repeated values are next to each other and easy to skip.

For 3Sum, we enumerate each value in a single loop, and use the two pointers pattern for the rest of the array. For kSum, we will have `k - 2` nested loops to enumerate all combinations of `k - 2` values.

![0 ](https://leetcode.com/problems//Figures/18/18-1.png )  ![1 ](https://leetcode.com/problems//Figures/18/18-2.png )  ![2 ](https://leetcode.com/problems//Figures/18/18-3.png )  ![3 ](https://leetcode.com/problems//Figures/18/18-4.png )  ![4 ](https://leetcode.com/problems//Figures/18/18-5.png )  ![5 ](https://leetcode.com/problems//Figures/18/18-6.png )  ![6 ](https://leetcode.com/problems//Figures/18/18-7.png )  ![7 ](https://leetcode.com/problems//Figures/18/18-8.png )  ![8 ](https://leetcode.com/problems//Figures/18/18-9.png )  ![9 ](https://leetcode.com/problems//Figures/18/18-10.png )  

**Algorithm**

We can implement `k - 2` loops using a recursion. We will pass the starting point and `k` as the parameters. When `k == 2`, we will call `twoSum`, terminating the recursion.

1. For the main function:
    - Sort the input array `nums`.
    - Call `kSum` with `start = 0`, `k = 4`, and `target`, and return the result.

2. For `kSum` function:
    - Check if the sum of `k` smallest values is greater than `target`, or the sum of `k` largest values is smaller than `target`. Since the array is sorted, the smallest value is `nums[start]`, and largest - the last element in `nums`.
        - If so, no need to continue - there are no `k` elements that sum to `target`.
    - If `k` equals `2`, call `twoSum` and return the result.
    - Iterate `i` through the array from `start`:
        - If the current value is the same as the one before, skip it.
        - Recursively call `kSum` with `start = i + 1`, `k = k - 1`, and `target - nums[i]`.
        - For each returned `set` of values:
            - Include the current value `nums[i]` into `set`.
            - Add `set` to the result `res`.
    - Return the result `res`.

3. For `twoSum` function:
    - Set the low pointer `lo` to `start`, and high pointer `hi` to the last index.
    - While low pointer is smaller than high:
        - If the sum of `nums[lo]` and `nums[hi]` is less than `target`, increment `lo`.
            - Also increment `lo` if the value is the same as for `lo - 1`.
        - If the sum is greater than `target`, decrement `hi`.
            - Also decrement `hi` if the value is the same as for `hi + 1`.
        - Otherwise, we found a pair:
            - Add it to the result `res`.
            - Decrement `hi` and increment `lo`.
    - Return the result `res`.

```
public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
}
public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
        return res;
    if (k == 2)
        return twoSum(nums, target, start);
    for (int i = start; i < nums.length; ++i)
        if (i == start || nums[i - 1] != nums[i])
            for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(set);
            }
    return res;
}
public List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int lo = start, hi = nums.length - 1;
    while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
            ++lo;
        else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
            --hi;
        else
            res.add(Arrays.asList(nums[lo++], nums[hi--]));
    }
    return res;
}
```

**Complexity Analysis**

- Time Complexity: ![\mathcal{O}(n^{k-1}) ](./p__mathcal{O}_n^{k_-_1}__.png) , or ![\mathcal{O}(n^3) ](./p__mathcal{O}_n^3__.png)  for 4Sum. We have *k - 2* loops, and `twoSum` is ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png) .

    Note that for *k > 2*, sorting the array does not change the overall time complexity.

- Space Complexity: ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png) . We need ![\mathcal{O}(k) ](./p__mathcal{O}_k__.png)  space for the recursion. *k* can be the same as *n* in the worst case for the generalized algorithm.

    Note that, for the purpose of complexity analysis, we ignore the memory required for the output.

---

#### Approach 2: Hash Set

Since elements must sum up to the exact target value, we can also use the [Two Sum: One-pass Hash Table](https://leetcode.com/articles/two-sum/#approach-3-one-pass-hash-table) approach.

In [3Sum: Hash Set](https://leetcode.com/articles/3sum/#approach-2-hash-set), we solved the problem without sorting the array. To do that, we needed to sort values within triplets, and track them in a hash set. Doing the same for k values could be impractical.

So, for this approach, we will also sort the array and skip duplicates the same way as in the Two Pointers approach above. Thus, the code will only differ in the `twoSum` implementation.

**Algorithm**

`twoSum` implementation here is almost the same as in [Two Sum: One-pass Hash Table](https://leetcode.com/articles/two-sum/#approach-3-one-pass-hash-table). The only difference is the check to avoid duplicates. Since the array is sorted, we can just compare the found pair with the last one in the result `res`.

<iframe src="https://leetcode.com/playground/BrQ72KdV/shared" frameBorder="0" width="100%" height="500" name="BrQ72KdV"></iframe>

**Complexity Analysis**

- Time Complexity: ![\mathcal{O}(n^{k-1}) ](./p__mathcal{O}_n^{k_-_1}__.png) , or ![\mathcal{O}(n^3) ](./p__mathcal{O}_n^3__.png)  for 4Sum. We have *k - 2* loops iterating over *n* elements, and `twoSum` is ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png) .

    Note that for *k > 2*, sorting the array does not change the overall time complexity.

- Space Complexity: ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png)  for the hash set. The space needed for the recursion will not exceed ![\mathcal{O}(n) ](./p__mathcal{O}_n__.png) .