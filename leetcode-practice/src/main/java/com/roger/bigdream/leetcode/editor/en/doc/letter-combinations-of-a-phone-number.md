[TOC]

## Solution

---

#### Approach 1: Backtracking

[Backtracking](https://en.wikipedia.org/wiki/Backtracking) 
is an algorithm for finding all
solutions by exploring all potential candidates.
If the solution candidate turns to be _not_ a solution 
(or at least not the _last_ one), 
backtracking algorithm discards it by making some changes 
on the previous step, *i.e.* _backtracks_ and then try again.

Here is a backtrack function `backtrack(combination, next_digits)`
which takes as arguments an ongoing letter combination 
and the next digits to check.

* If there is no more digits to check
that means that the current combination is done.
* If there are still digits to check :
    * Iterate over the letters mapping the next available digit.
        * Append the current letter to the current combination 
        `combination = combination + letter`.
        * Proceed to check next digits : 
        `backtrack(combination + letter, next_digits[1:])`.
        
![0 ](https://leetcode.com/problems//Figures/17/17_slide_7.png )  ![1 ](https://leetcode.com/problems//Figures/17/17_slide_8.png )  ![2 ](https://leetcode.com/problems//Figures/17/17_slide_9.png )  ![3 ](https://leetcode.com/problems//Figures/17/17_slide_10.png )  ![4 ](https://leetcode.com/problems//Figures/17/17_slide_11.png )  ![5 ](https://leetcode.com/problems//Figures/17/17_slide_12.png )  ![6 ](https://leetcode.com/problems//Figures/17/17_slide_13.png )  ![7 ](https://leetcode.com/problems//Figures/17/17_slide_14.png )  ![8 ](https://leetcode.com/problems//Figures/17/17_slide_15.png )  ![9 ](https://leetcode.com/problems//Figures/17/17_slide_16.png )  ![10 ](https://leetcode.com/problems//Figures/17/17_slide_17.png )  ![11 ](https://leetcode.com/problems//Figures/17/17_slide_18.png )  ![12 ](https://leetcode.com/problems//Figures/17/17_slide_19.png )  ![13 ](https://leetcode.com/problems//Figures/17/17_slide_20.png )  

```
class Solution {
  Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  List<String> output = new ArrayList<String>();

  public void backtrack(String combination, String next_digits) {
    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map 
      // the next available digit
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0)
      backtrack("", digits);
    return output;
  }
}
```

**Complexity Analysis**

* Time complexity : ![\mathcal{O}(3^N\times4^M) ](./p__mathcal{O}_3^N_times_4^M__.png) 
where `N` is the number of digits in the input that maps to  3 letters 
(*e.g.* `2, 3, 4, 5, 6, 8`) and `M` is the number of digits in the input
that maps to 4 letters (*e.g.* `7, 9`),
and `N+M` is the total number digits in the input.
 
* Space complexity : ![\mathcal{O}(3^N\times4^M) ](./p__mathcal{O}_3^N_times_4^M__.png)  since one has to keep
![3^N\times4^M ](./p__3^N_times_4^M_.png)  solutions.