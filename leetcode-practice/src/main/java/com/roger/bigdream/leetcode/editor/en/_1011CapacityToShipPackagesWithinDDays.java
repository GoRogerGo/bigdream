package com.roger.bigdream.leetcode.editor.en;
//A conveyor belt has packages that must be shipped from one port to another wit
//hin days days. 
//
// The ith package on the conveyor belt has a weight of weights[i]. Each day, we
// load the ship with packages on the conveyor belt (in the order given by weights
//). We may not load more weight than the maximum weight capacity of the ship. 
//
// Return the least weight capacity of the ship that will result in all the pack
//ages on the conveyor belt being shipped within days days. 
//
// 
// Example 1: 
//
// 
//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 
//5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of cap
//acity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8)
//, (9), (10) is not allowed.
// 
//
// Example 2: 
//
// 
//Input: weights = [3,2,2,4,1,4], days = 3
//Output: 6
//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3
// days like this:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4
// 
//
// Example 3: 
//
// 
//Input: weights = [1,2,3,1,1], days = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= days <= weights.length <= 5 * 104 
// 1 <= weights[i] <= 500 
// 
// Related Topics Array Binary Search 
// 👍 7602 👎 167

public class _1011CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        Solution solution = new _1011CapacityToShipPackagesWithinDDays().new Solution();
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(solution.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功: 执行耗时:11 ms,击败了52.17% 的Java用户 内存消耗:48.4 MB,击败了84.58% 的Java用户
         * 2023年03月14日18:02:16
         * 注意点：①overload的场景需要提前终止
         *
         * @param weights
         * @param days
         * @return
         */
        public int shipWithinDays(int[] weights, int days) {
            int l = 1;
            int r = 0;
            for (int w : weights) r += w;
            while (l < r) {
                int m = l + (r - l) / 2;
                int M = l + (r - l) / 2;
                int d = 1;
                boolean overload = false;
                for (int w : weights) {
                    if (m < w) {
                        l = m + 1;
                        overload = true;
                        break;
                    }
                    if (M < w) {
                        d++;
                        M = m;
                    }
                    M -= w;
                }
                if (overload) continue;
                if (d <= days) r = m;
                else l = m + 1;
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}