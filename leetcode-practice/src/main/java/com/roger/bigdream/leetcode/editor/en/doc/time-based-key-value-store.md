[TOC]

## Solution

--- 

### Overview

In design questions like these, we are expected to design a custom data structure (using already existing data structures) that will support some given functionalities. For example, you might be aware of a popular design question [Min Stack](https://leetcode.com/problems/min-stack/), where the data structure can return the minimum element in the stack at any time.        
    
Here, we need to design a data structure, in which we can:
- store a `(key, value)` pair at a given `timestamp` and 
- get a `key`'s `value` at a `time` equal to or just less than the given `timestamp`.

The interviewer will expect us to give him the most optimal solution.        
In this article, we will start from the sub-optimal approach and try to optimize it further.

</br>

---

### Approach 1: Hashmap + Linear Search

#### Intuition

We can think of making some buckets for each given `key`, then in each bucket, we can store a `value` at the index `timestamp`.     
Because in the **get** function we have to search for `timestamp` for a particular `key`, so it's wise to place all `timestamps` collectively in a group for each `key`.

It is a 2-dimensional array where the first index will represent the `key`, the second index will represent the `timestamp` and the `value` is stored at that location.   
But instead of using arrays, we will use hashmaps because an array can only have integer numbers as key/index, but in the hashmap, we have control of the key, and it can be whatever we want, integer, string, character, etc.

![buckets](https://leetcode.com/problems//Figures/981/slides/Slide1.png)

The hashmap will store the given **`key`** as a **key** and **another hashmap** as **value**. The inner hashmap will store given  **`timestamp`** as **key** and given **`value`** as **value**.      
So, we made a bucket for each `key` and each bucket will store all `timestamp` and `value` pairs associated with it. 

> Our data structure `keyTimeMap` will look like this:        
`HashMap(key, HashMap(timestamp, value))`.     

<br />

- **`set(key, value, timestamp)` function:**      
To store a `value` for a given `key` and `timestamp`, we need to store it at the `(key, timestamp)` location in `keyTimeMap`. 

    ```c++
    keyTimeMap[key][timestamp] = value;
    ```
<br />

- **`get(key, timestamp)` function:**     
We have to return a `value` from the `key` bucket, which has `time` equal to or just less than the given `timestamp`.     
So, we can iterate on all the times starting from `timestamp` till `1`, and check if a `value` is stored for the current time or not, if stored we can return it, otherwise check for the previous time.      
If at the end no value was found we have to return an empty string.

    ````c++
    for (currTime = timestamp till 1) {
        if (currTime exists in 'keyTimeMap[key]' bucket) {
            return keyTimeMap[key][currTime];
        }
    }
    return "";
    ````

<br />

#### Algorithm

1. Create a hashmap `keyTimeMap` which stores string as key and another hashmap as value, as discussed above.

2. In the `set()` function, store `value` at `timestamp` location in `key` bucket of `keyTimeMap`, i.e. `keyTimeMap[key][timestamp] = value`.

3. In the `get()` function, we iterate on all times in decreasing order from `timestamp` till `1`.
    - For any time while iterating if there exists a value in `key's` bucket, we return that `value`.
    - Otherwise, in the end, we return an empty string.

#### Implementation

```
class TimeMap {
public:
    unordered_map<string, unordered_map<int, string>> keyTimeMap;
    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap[key][timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.count(key)) {
            return "";
        }
        
        // Iterate on time from 'timestamp' to '1'.
        for (int currTime = timestamp; currTime >= 1; --currTime) {
            // If a value for current time is stored in key's bucket we return the value.
            if (keyTimeMap[key].count(currTime)) {
                return keyTimeMap[key][currTime];
            }
        }
        
        // Otherwise no time <= timestamp was stored in key's bucket.
        return "";
    }
};
```

#### Complexity Analysis

If *M* is the number of set function calls, *N* is the number of get function calls, and *L* is average length of key and value strings.          

-  Time complexity: 

    - In the `set()` function, in each call, we store a `value` at `(key, timestamp)` location, which takes *O(L)* time to hash the string.     
       Thus, for *M* calls overall it will take, ![O(M\cdotL) ](./p__O_M_cdot_L__.png)  time.

    - In the `get()` function, in each call, we iterate linearly from `timestamp` to `1` which takes *O(timestamp)* time and again to hash the string it takes *O(L)* time.     
       Thus, for *N* calls overall it will take, ![O(N\cdottimestamp\cdotL) ](./p__O_N_cdot_timestamp_cdot_L__.png)  time.

    > **Note:** This approach can be TLE, since the time complexity is not optimal given the current data range in the problem description.
 

-  Space complexity:

     - In the `set()` function, in each call we store one `value` string of length `L`, which takes *O(L)* space.     
       Thus, for *M* calls we may store *M* unique values, so overall it may take ![O(M\cdotL) ](./p__O_M_cdot_L__.png)  space.

    - In the `get()` function, we are not using any additional space.      
       Thus, for all *N* calls it is a constant space operation.

 <br/>

---

### Approach 2: Sorted Map + Binary Search

#### Intuition

In the previous approach, the `set` function is efficient, but in the `get` function we iterate linearly over the time range. If the `timestamps` in the inner map were sorted, then we can use binary search to find the target time more efficiently.    

Thus, we can use a sorted map instead of a hashmap.           
A sorted map keeps the stored key-value pairs sorted based on the key.

> **Note:** If you are not much familiar with Binary Search you can read about it in our [LeetCode Explore Card](https://leetcode.com/explore/learn/card/binary-search/138/background/971/). In this approach, we will be using in-build binary search functions which will save time during the interview.

> So now our data structure `keyTimeMap` will look like:     
`HashMap(key, SortedMap(timestamp, value))`.     

<br />

- **`set(key, value, timestamp)` function:**      
To store a `value` for a given `key` and `timestamp`, we just need to store it at the `(key, timestamp)` location in `keyTimeMap`. 

    ```c++
    keyTimeMap[key][timestamp] = value;
    ```
<br />

- **`get(key, timestamp)` function:**     
We have to return a `value` from the `key` bucket, which has `time` equal to or just less than the given `timestamp`.     
So, we will find the `upper_bound` of the given `timestamp`, `upper_bound` function returns an iterator pointing to the first element that is **greater than the searched value**. Thus, the left element of the iterator will be equal to or just smaller than the searched value.

  If `upper_bound` points to the beginning of the map it means no `time` less than or equal to the given `timestamp` exists in the map thus we return a null string.       
Otherwise, the target `time` exists at one position left of the position pointed by the `upper_bound`.

    ````c++
    it = results[key].upper_bound(timestamp);
    if (it == results[key].begin()) {
        return "";
    }
    return prev(it)->second;
    ````

> **Note:** Java has a little different implementation, here we will use the`floorKey` method,       
which returns a key equal to or less than searched key or `null` if no such key exists that satisfies the above condition.


#### Algorithm

1. Create a hashmap `keyTimeMap` which stores string as key and a sorted map as value, as discussed.

2. In the `set()` function, store `value` at `key`, `timestamp` location in `keyTimeMap`.

3. In the `get()` function, we find time equal to or less than `timestamp` using binary-search on SortedMap.
    - If no time equal to or less than `timestamp` exists, we return an empty string.
    - Otherwise, we return the value stored at the time equal to or just less than `timestamp`.

#### Implementation

```
class TimeMap {
public:
    unordered_map<string, map<int, string>> keyTimeMap;
    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap[key][timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (keyTimeMap.find(key) == keyTimeMap.end()) {
            return "";
        }
        
        auto it = keyTimeMap[key].upper_bound(timestamp);
        // If iterator points to first element it means, no time <= timestamp exists.
        if (it == keyTimeMap[key].begin()) {
            return "";
        }
        
        // Return value stored at previous position of current iterator.
        return prev(it)->second;
    }
};
```

#### Complexity Analysis
 
If *M* is the number of set function calls, *N* is the number of get function calls, and *L* is average length of key and value strings.          

-  Time complexity:

    - In the `set()` function, in each call we store a `value` at `(key, timestamp)` location, which takes ![O(L\cdotlogM) ](./p__O_L_cdot_logM__.png)  time as the internal implementation of sorted maps is some kind of balanced binary tree and in worst case we might have to compare `logM` nodes (height of tree) of length `L` each with our key.      
       Thus, for *M* calls overall it will take, `![O(L\cdotM\cdotlogM) ](./p__O_L_cdot_M_cdot_logM__.png) ` time.

    - In the `get()` function, we will find correct `key` in our map, which can take ![O(L\cdotlogM) ](./p__O_L_cdot_logM__.png)  time and then use binary search on that bucket which can have at most `M` elements, which takes *O(logM)* time.              
       `peekitem` in python will also take *O(logN)* time to get the value, but the upper bound remains the same.          
       Thus, for *N* calls overall it will take, `![O(N\cdot(L\cdotlogM+logM)) ](./p__O_N_cdot__L_cdot_logM_+_logM___.png) ` time.
 

-  Space complexity:

     - In the `set()` function, in each call we store one `value` string of length `L`, which takes *O(L)* space.     
       Thus, for *M* calls we may store *M* unique values, so overall it may take ![O(M\cdotL) ](./p__O_M_cdot_L__.png)  space.

    - In the `get()` function, we are not using any additional space.      
       Thus, for all *N* calls it is a constant space operation.
 
<br />

---

 
### Approach 3: Array + Binary Search

#### Intuition

If we read the problem statement carefully, it is mentioned that `"All the timestamps of set are strictly increasing"`, thus even if we use an array to store the timestamps, they will be pushed in sorted order. But we also need to store `values` with each `timestamp`, so we will store `(timestamp, value)` pairs in the `key's` bucket which will be an array.

> So now our data structure `keyTimeMap` will look like this:     
`HashMap(key, Array(Pair(timestamp, value)))`.     

<br />

- **`set(key, value, timestamp)` function:**      
To store a `value` for a given `key` and `timestamp`, we just need to push the `(timestamp, value)` pair in the bucket of `key`. 

    ```c++
    keyTimeMap[key].push_back(make_pair(timestamp, value));
    ```
<br />

- **`get(key, timestamp)` function:**     
We need to return `value` in the `key` bucket, which has `time` just less than or equal to the given `timestamp`.     
Similarly here also, we will use binary search to find the time equal to or less than the given `timestamp`.

<br />

> **Note:** In this approach, we will write our own implementation of the binary search. We will not focus on how binary search works, but if you are new to it you can visit this [LeetCode Explore Card](https://leetcode.com/explore/learn/card/binary-search/138/background/971/).

<br />

#### Algorithm

1. Create a hashmap `keyTimeMap` which stores string as key and an array of pairs as value, as discussed.

2. In the `set()` function, push `(timestamp, value)` pair in bucket `key` in `keyTimeMap`.

3. In the `get()` function, we find time equal to or less than `timestamp` using binary-search on the array.
    - If no time equal to or less than `timestamp` exists, we return an empty string.
    - Otherwise, we return the value stored at the time equal to or just less than `timestamp`.

#### Implementation

```
class TimeMap {
public:
    unordered_map<string, vector<pair<int, string>>> keyTimeMap;
    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        // Push '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap[key].push_back({ timestamp, value });
    }
    
    string get(string key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (keyTimeMap.find(key) == keyTimeMap.end()) {
            return "";
        }
        
        if (timestamp < keyTimeMap[key][0].first) {
            return "";
        }
        
        // Using binary search on the array of pairs.
        int left = 0;
        int right = keyTimeMap[key].size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (keyTimeMap[key][mid].first <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // If iterator points to first element it means, no time <= timestamp exists.
        if (right == 0) {
            return "";
        }
                
        return keyTimeMap[key][right - 1].second;
    }
};
```

#### Complexity Analysis
 
If *M* is the number of set function calls, *N* is the number of get function calls, and *L* is average length of key and value strings.           

-  Time complexity:

    - In the `set()` function, in each call, we push a `(timestamp, value)` pair in the `key` bucket, which takes *O(L)* time to hash the string. 
       Thus, for *M* calls overall it will take, `![O(M\cdotL) ](./p__O_M_cdot_L__.png) ` time.

    - In the `get()` function, we use binary search on the `key's` bucket which can have at most `M` elements and to hash the string it takes *O(L)* time, thus overall it will take ![O(L\cdotlogM) ](./p__O_L_cdot_logM__.png)  time for binary search.              
       And, for *N* calls overall it will take, `![O(N\cdotL\cdotlogM) ](./p__O_N_cdot_L_cdot_logM__.png) ` time.
 

-  Space complexity:

     - In the `set()` function, in each call we store one `value` string of length `L`, which takes *O(L)* space.     
       Thus, for *M* calls we may store *M* unique values, so overall it may take ![O(M\cdotL) ](./p__O_M_cdot_L__.png)  space.

    - In the `get()` function, we are not using any additional space.      
       Thus, for all *N* calls it is a constant space operation.