package com.roger.bigdream.leetcode.editor.en;
//Your friend is typing his name into a keyboard. Sometimes, when typing a chara
//cter c, the key might get long pressed, and the character will be typed 1 or mor
//e times. 
//
// You examine the typed characters of the keyboard. Return True if it is possib
//le that it was your friends name, with some characters (possibly none) being lon
//g pressed. 
//
// 
// Example 1: 
//
// 
//Input: name = "alex", typed = "aaleex"
//Output: true
//Explanation: 'a' and 'e' in 'alex' were long pressed.
// 
//
// Example 2: 
//
// 
//Input: name = "saeed", typed = "ssaaedd"
//Output: false
//Explanation: 'e' must have been pressed twice, but it was not in the typed out
//put.
// 
//
// 
// Constraints: 
//
// 
// 1 <= name.length, typed.length <= 1000 
// name and typed consist of only lowercase English letters. 
// 
// Related Topics Two Pointers String 
// 👍 2107 👎 302

public class _925LongPressedName {

    public static void main(String[] args) {
        Solution solution = new _925LongPressedName().new Solution();
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(solution.isLongPressedName("ppyplrza", "pyypllrza"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:40.9 MB,击败了16.36% 的Java用户
         * 2023年03月23日11:53:16
         * 自己的答案，第二次提交成功
         * 注意点：①最后的返回要判断l>0
         *
         * @param name
         * @param typed
         * @return
         */
        public boolean isLongPressedName(String name, String typed) {
            int l = name.length();
            int r = typed.length();
            if (l > r) return false;
            if (l == r) return name.equals(typed);
            char sameWord = name.charAt(l - 1);
            while (r > 0) {
                if (l > 0 && name.charAt(l - 1) == typed.charAt(r - 1)) {
                    sameWord = name.charAt(l - 1);
                    l--;
                    r--;
                } else {
                    if (sameWord == typed.charAt(r - 1)) r--;
                    else return false;
                }
            }
            return l > 0 ? false : true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}