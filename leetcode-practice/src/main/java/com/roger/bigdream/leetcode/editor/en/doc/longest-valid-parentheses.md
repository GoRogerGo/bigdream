[TOC]
## Summary

We need to determine the length of the largest valid substring of parentheses from a given string.

## Solution
---
#### Approach 1: Brute Force

**Algorithm**

In this approach, we consider every possible non-empty even length substring from the given string and check whether it's
a valid string of parentheses or not. In order to check the validity, we use the Stack's Method.

Every time we
encounter a ![\text{‘(’} ](./p__text{‘_’}_.png) , we push it onto the stack. For every ![\text{‘)’} ](./p__text{‘_’}_.png)  encountered, we pop a ![\text{‘(’} ](./p__text{‘_’}_.png)  from the stack. If ![\text{‘(’} ](./p__text{‘_’}_.png)  isn't
 available on the stack for popping at anytime or if stack contains some elements after processing complete substring, the substring of parentheses is invalid. In this way, we repeat the
 process for every possible substring and we keep on
  storing the length of the longest valid string found so far.
```
Example:
"((())"

(( --> invalid
(( --> invalid
() --> valid, length=2
)) --> invalid
((()--> invalid
(())--> valid, length=4
maxlength=4
```

```
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }
}
```

**Complexity Analysis**

* Time complexity : *O(n^3)*. Generating every possible substring from a string of length *n* requires *O(n^2)*. Checking validity of a string of length *n* requires *O(n)*.

* Space complexity : *O(n)*. A stack of depth *n* will be required for the longest substring.
<br />
<br />
---

#### Approach 2: Using Dynamic Programming

**Algorithm**

This problem can be solved by using Dynamic Programming. We make use of a ![\text{dp} ](./p__text{dp}_.png)  array where *i*th element of ![\text{dp} ](./p__text{dp}_.png)  represents the length of the longest valid substring ending at *i*th index. We initialize the complete ![\text{dp} ](./p__text{dp}_.png)  array with 0's. Now, it's obvious that the valid substrings must end with ![\text{‘)’} ](./p__text{‘_’}_.png) . This further leads to the conclusion that the substrings ending with ![\text{‘(’} ](./p__text{‘_’}_.png)  will always contain '0' at their corresponding ![\text{dp} ](./p__text{dp}_.png)  indices. Thus, we update the ![\text{dp} ](./p__text{dp}_.png)  array only when ![\text{‘)’} ](./p__text{‘_’}_.png)  is encountered.

To fill ![\text{dp} ](./p__text{dp}_.png)  array we will check every two consecutive characters of the string and if

1. ![\text{s}\[i\]=\text{‘)’} ](./p__text{s}_i__=_text{‘_’}_.png)  and ![\text{s}\[i-1\]=\text{‘(’} ](./p__text{s}_i_-_1__=_text{‘_’}_.png) , i.e. string looks like ![``.......()"\Rightarrow ](./p__``.......__"_Rightarrow_.png) 

    ![\text{dp}\[i\]=\text{dp}\[i-2\]+2 ](./p_______text{dp}_i_=text{dp}_i-2_+2______.png) 

    We do so because the ending "()" portion is a valid substring anyhow and leads to an increment of 2 in the length of the just previous valid substring's length.

2. ![\text{s}\[i\]=\text{‘)’} ](./p__text{s}_i__=_text{‘_’}_.png)  and ![\text{s}\[i-1\]=\text{‘)’} ](./p__text{s}_i_-_1__=_text{‘_’}_.png) , i.e. string looks like ![``.......))"\Rightarrow ](./p__``.......__"_Rightarrow_.png) 

    if ![\text{s}\[i-\text{dp}\[i-1\]-1\]=\text{‘(’} ](./p__text{s}_i_-_text{dp}_i_-_1__-_1__=_text{‘_’}_.png)  then

    ![\text{dp}\[i\]=\text{dp}\[i-1\]+\text{dp}\[i-\text{dp}\[i-1\]-2\]+2 ](./p_______text{dp}_i_=text{dp}_i-1_+text{dp}_i-text{dp}_i-1_-2_+2______.png) 

   The reason behind this is that if the 2nd last ![\text{‘)’} ](./p__text{‘_’}_.png)  was a part of a valid substring (say *sub_s*), for the last ![\text{‘)’} ](./p__text{‘_’}_.png)  to be a part of a larger substring, there must be a corresponding starting ![\text{‘(’} ](./p__text{‘_’}_.png)  which lies before the valid substring of which the 2nd last ![\text{‘)’} ](./p__text{‘_’}_.png)  is a part (i.e. before *sub_s*). Thus, if the character before *sub_s* happens to be ![\text{‘(’} ](./p__text{‘_’}_.png) , we update the ![\text{dp}\[i\] ](./p__text{dp}_i__.png)  as an addition of *2* in the length of *sub_s* which is ![\text{dp}\[i-1\] ](./p__text{dp}_i-1__.png) . To this, we also add the length of the valid substring just before the term "(,sub_s,)" , i.e. ![\text{dp}\[i-\text{dp}\[i-1\]-2\] ](./p__text{dp}_i-text{dp}_i-1_-2__.png) .

For better understanding of this method, see this example:

<!--![Longest_Valid_Parenthesis](https://leetcode.com/problems//Figures/32_LongestValidParenthesisDP.gif)-->
![0 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide1.JPG )  ![1 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide2.JPG )  ![2 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide3.JPG )  ![3 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide4.JPG )  ![4 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide5.JPG )  ![5 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide6.JPG )  ![6 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide7.JPG )  ![7 ](https://leetcode.com/problems//Figures/32_Longest_Valid2Slide8.JPG )  

```
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
```

**Complexity Analysis**

* Time complexity : *O(n)*. Single traversal of string to fill dp array is done.

* Space complexity : *O(n)*. dp array of size *n* is used.
<br />
<br />
---
#### Approach 3: Using Stack

**Algorithm**

Instead of finding every possible string and checking its validity, we can make use of stack while scanning
the given string to check if the string scanned so far is valid, and also the length of the longest valid string. In order to do so, we start by pushing *-1* onto the stack.

 For every ![\text{‘(’} ](./p__text{‘_’}_.png)  encountered, we push its index onto the stack.

 For every ![\text{‘)’} ](./p__text{‘_’}_.png)  encountered, we pop the topmost element and subtract the current element's index from the top element of the stack, which gives the length of the currently encountered valid string of parentheses. If while popping the element, the stack becomes empty, we push the current element's index onto the stack. In this way, we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.

See this example for better understanding.

<!--![Longest_Valid_Parenthesis](https://leetcode.com/problems//Figures/32_LongestValidParenthesisSTACK.gif)-->
![0 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide1.JPG )  ![1 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide2.JPG )  ![2 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide3.JPG )  ![3 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide4.JPG )  ![4 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide5.JPG )  ![5 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide6.JPG )  ![6 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide7.JPG )  ![7 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide8.JPG )  ![8 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide9.JPG )  ![9 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide10.JPG )  ![10 ](https://leetcode.com/problems//Figures/32_Longest_Valid1Slide11.JPG )  

```
public class Solution {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
```

**Complexity Analysis**

* Time complexity : *O(n)*. *n* is the length of the given string..

* Space complexity : *O(n)*. The size of stack can go up to *n*.
<br />
<br />
---
#### Approach 4: Without extra space

**Algorithm**

In this approach, we make use of two counters *left* and *right*. First, we start traversing the string from the left towards the right and for every ![\text{‘(’} ](./p__text{‘_’}_.png)  encountered, we increment the *left* counter and for every ![\text{‘)’} ](./p__text{‘_’}_.png)  encountered, we increment the *right* counter. Whenever *left* becomes equal to *right*, we calculate the length of the current valid string and keep track of maximum length substring found so far. If *right* becomes greater than *left* we reset *left* and *right* to *0*.

Next, we start traversing the string from right to left and similar procedure is applied.

Example of this approach:

<!--![Longest_Valid_Parenthesis](https://leetcode.com/problems//Figures/32_LongestValidParenthesisLR.gif)-->
![0 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide1.PNG )  ![1 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide2.PNG )  ![2 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide3.PNG )  ![3 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide4.PNG )  ![4 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide5.PNG )  ![5 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide6.PNG )  ![6 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide7.PNG )  ![7 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide8.PNG )  ![8 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide9.PNG )  ![9 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide10.PNG )  ![10 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide11.PNG )  ![11 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide12.PNG )  ![12 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide13.PNG )  ![13 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide14.PNG )  ![14 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide15.PNG )  ![15 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide16.PNG )  ![16 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide17.PNG )  ![17 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide18.PNG )  ![18 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide19.PNG )  ![19 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide20.PNG )  ![20 ](https://leetcode.com/problems//Figures/32_Longest_Valid3Slide21.PNG )  

```
public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
```

**Complexity Analysis**

* Time complexity : *O(n)*. Two traversals of the string.

* Space complexity : *O(1)*. Only two extra variables *left* and *right* are needed.