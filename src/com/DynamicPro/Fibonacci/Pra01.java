package com.DynamicPro.Fibonacci;

/**
 * 2023.10.16
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class Pra01 {
    public static void main(String[] args) {
        Solution_D01 solution_d01 = new Solution_D01();
        int n = 3;
        int result = solution_d01.climbStairs(n);
        System.out.println(result);

    }
}

/**
 * 斐波那契数列的基本性质，每个数都是前两个数之和
 */
class Solution_D01 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1]; // 斐波那契数也把0位计算在内
        // dp[0] 存储的是第0个斐波那契数（通常为1），dp[1] 存储的是第1个斐波那契数（也通常为1）
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
