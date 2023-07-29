package com.roger.bigdream.leetcode.editor.en;
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has pile
//s[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she choose
//s some pile of bananas and eats k bananas from that pile. If the pile has less t
//han k bananas, she eats all of them instead and will not eat any more bananas du
//ring this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas bef
//ore the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h h
//ours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 104 
// piles.length <= h <= 109 
// 1 <= piles[i] <= 109 
// 
// Related Topics Array Binary Search 
// 👍 7294 👎 334

public class _875KokoEatingBananas {

    public static void main(String[] args) {
        Solution solution = new _875KokoEatingBananas().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 2023年07月29日09:45:40
         * 官网答案，比花花的代码多，但是更清晰
         * <p>
         * 解答成功: 执行耗时:6 ms,击败了98.98% 的Java用户 内存消耗:44 MB,击败了88.79% 的Java用
         *
         * @param piles
         * @param h
         * @return
         */
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1;
            int high = 0;
            for (int pile : piles) {
                high = Math.max(high, pile);
            }
            int k = high;
            while (low < high) {
                int speed = (high - low) / 2 + low;
                long time = getTime(piles, speed);
                if (time <= h) {
                    k = speed;
                    high = speed;
                } else {
                    low = speed + 1;
                }
            }
            return k;
        }

        private long getTime(int[] piles, int speed) {
            long time = 0;
            for (int pile : piles) {
                int curTime = (pile + speed - 1) / speed;
                time += curTime;
            }
            return time;
        }

        /**
         * 解答成功: 执行耗时:10 ms,击败了96.73% 的Java用户 内存消耗:43.4 MB,击败了50.28% 的Java用户
         * 2023年03月14日17:27:13
         * 来自花花
         * 这道题的特征是search for the smallest k [1, max_pile_length] such that eating time h <= H
         * 心得：①return l是精髓啊 ②标准写法是(p + m - 1) / m
         *
         * @param piles
         * @param h
         * @return
         */
        public int minEatingSpeed_huahua(int[] piles, int h) {
            int l = 1;
            int r = Integer.MIN_VALUE;
            for (int i = 0; i < piles.length; i++) {
                if (r < piles[i]) r = piles[i];
            }
            while (l < r) {
                int m = l + (r - l) / 2;
                int hour = 0;
                for (int p : piles) {
                    hour += (p + m - 1) / m;
                }
                if (hour <= h) r = m;
                else l = m + 1;
            }
            return l; //这里是精髓啊
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}