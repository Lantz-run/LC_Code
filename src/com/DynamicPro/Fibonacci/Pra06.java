package com.DynamicPro.Fibonacci;

/**
 * 动态规划第六题： 删除并获得点数
 *
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class Pra06 {
    public static void main(String[] args) {

        Solution06 solution06 = new Solution06();
        int[] nums = {3, 4, 2};
        int result = solution06.deleteAndEarn(nums);
        System.out.println(result);
    }
}

class Solution06 {
//    int[] cnts = new int[10010];
    public int deleteAndEarn(int[] nums) {
        int n  = 10010;
        int[] dp = new int[n];
        for (int x : nums
             ) {
            dp[x] += x; // 将nums的数通过建立dp中间状态变量存储进去
        }
        int[] f = new int[n];
        int[] g = f.clone(); // g等于选择，f等于不选
        for (int i = 1; i < n; i++) {
            g[i] = f[i-1] + dp[i];
            f[i] = Math.max(f[i-1], g[i-1]);
        }
        return Math.max(f[n-1], g[n-1]);

//        // 看不懂的代码。。。。想s--2023.11.20
//        int len = nums.length;
//        int max = 0;
//        for (int x : nums
//             ) {
//            cnts[x]++;
//            max = Math.max(max, x);
//
//        }
//        // f[i][0]不选择，f[i][1]选择
//        int[][] f = new int[max+1][2];
//        for (int i = 1; i <= max; i++) {
//            f[i][0] = Math.max(f[i-1][1], f[i-1][0]);
//            f[i][1] = f[i-1][0] + i*cnts[i];
//         }
//
//        return Math.max(f[max][1], f[max][0])
    }
}