package com.roger.bigdream.leetcode.editor.en;

//
//Given a list of sorted characters letters containing only lowercase letters, a
//nd given a target letter target, find the smallest element in the list that is l
//arger than the given target.
// 
//Letters also wrap around. For example, if the target is target = 'z' and lette
//rs = ['a', 'b'], the answer is 'a'.
// 
//
// Examples: 
// 
//Input:
//letters = ["c", "f", "j"]
//target = "a"
//Output: "c"
//
//Input:
//letters = ["c", "f", "j"]
//target = "c"
//Output: "f"
//
//Input:
//letters = ["c", "f", "j"]
//target = "d"
//Output: "f"
//
//Input:
//letters = ["c", "f", "j"]
//target = "g"
//Output: "j"
//
//Input:
//letters = ["c", "f", "j"]
//target = "j"
//Output: "c"
//
//Input:
//letters = ["c", "f", "j"]
//target = "k"
//Output: "c"
// 
// 
//
// Note: 
// 
// letters has a length in range [2, 10000]. 
// letters consists of lowercase letters, and contains at least 2 unique letters
//. 
// target is a lowercase letter. 
// 
// Related Topics Binary Search 
// 👍 657 👎 730


public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
//        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(solution.nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
//            return approachWithSet(letters, target);
            return binarySearch(letters, 0, letters.length, target);
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param letters
         * @param target
         * @return
         */
        private char approachWithSet(char[] letters, char target) {
            boolean[] seen = new boolean[26];
            for (char c : letters) {
                seen[c - 'a'] = true;
            }
            while (true) {
                if (++target > 'z') target = 'a';
                if (seen[target - 'a']) return target;
            }
        }

        /**
         * Runtime:0 ms, faster than 100.00% of Java online submissions.
         *
         * @param letters
         * @param low
         * @param high
         * @param target
         * @return
         */
        private char binarySearch(char[] letters, int low, int high, char target) {
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                if (letters[mid] > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return letters[low % letters.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}