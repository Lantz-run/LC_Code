package com.DynamicPro.Fibonacci;

/**
 * 2023.10.26
 * 动态规划第四题：使用最小花费爬楼梯
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * 示例 1：
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15
 *
 * 示例 2：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 *
 * 提示：
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 */
public class Pra04 {
    public static void main(String[] args) {
        Solution_D04 solution_d04 = new Solution_D04();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int result = solution_d04.minCostClimbingStairs(cost);
        System.out.println(result);

    }
}

/**
 * @Lantz
 * tips: 先支付再爬楼梯
 * 1、到达第i阶楼梯就要花费cost[i], 那么第 i-1 阶就要花费 cost[i-1]
 * 2、cost[i]如果从0开始就有 i+1阶，就是 i+1才是楼梯顶部；从1开始，i就是楼梯顶部
 */
class Solution_D04 {
    public int minCostClimbingStairs(int[] cost) {
//        int size = cost.length;
//        int[] mincost = new int[size];
//        mincost[0] = 0;
//        mincost[1] = Math.min(cost[0], cost[1]);
//        // 已经初始化了0和1阶楼梯，所以从2开始
//        for (int i = 2; i < size; i++) {
//            mincost[i] = Math.min(mincost[i-1]+cost[i], mincost[i-2]+cost[i-1]);
//
//        }
//
//        return mincost[size-1];

        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);

        }

        return dp[len];
    }
}