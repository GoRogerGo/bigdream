[TOC]

## Solution
---

#### Approach 1: Pop and Push Digits & Check before Overflow

**Intuition**

We can build up the reverse integer one digit at a time.
While doing so, we can check beforehand whether or not appending another digit would cause overflow.

**Algorithm**

Reversing an integer can be done similarly to reversing a string.

We want to repeatedly "pop" the last digit off of *x* and "push" it to the back of the ![\text{rev} ](./p__text{rev}_.png) . In the end, ![\text{rev} ](./p__text{rev}_.png)  will be the reverse of the *x*.

To "pop" and "push" digits without the help of some auxiliary stack/array, we can use math.

```cpp
//pop operation:
pop = x % 10;
x /= 10;

//push operation:
temp = rev * 10 + pop;
rev = temp;
```

However, this approach is dangerous, because the statement ![\text{temp}=\text{rev}\cdot10+\text{pop} ](./p__text{temp}_=_text{rev}_cdot_10_+_text{pop}_.png)  can cause overflow.

Luckily, it is easy to check beforehand whether or this statement would cause an overflow.

To explain, lets assume that ![\text{rev} ](./p__text{rev}_.png)  is positive.

1. If ![temp=\text{rev}\cdot10+\text{pop} ](./p__temp_=_text{rev}_cdot_10_+_text{pop}_.png)  causes overflow, then it must be that ![\text{rev}\geq\frac{INTMAX}{10} ](./p__text{rev}_geq_frac{INTMAX}{10}_.png) 
2. If ![\text{rev}>\frac{INTMAX}{10} ](./p__text{rev}___frac{INTMAX}{10}_.png) , then ![temp=\text{rev}\cdot10+\text{pop} ](./p__temp_=_text{rev}_cdot_10_+_text{pop}_.png)  is guaranteed to overflow.
3. If ![\text{rev}==\frac{INTMAX}{10} ](./p__text{rev}_==_frac{INTMAX}{10}_.png) , then ![temp=\text{rev}\cdot10+\text{pop} ](./p__temp_=_text{rev}_cdot_10_+_text{pop}_.png)  will overflow if and only if ![\text{pop}>7 ](./p__text{pop}___7_.png) 

Similar logic can be applied when ![\text{rev} ](./p__text{rev}_.png)  is negative.

```
class Solution {
public:
    int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
            if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
};
```

**Complexity Analysis**

* Time Complexity: ![O(\log(x)) ](./p__O_log_x___.png) . There are roughly ![\log_{10}(x) ](./p__log_{10}_x__.png)  digits in *x*.
* Space Complexity: *O(1)*.