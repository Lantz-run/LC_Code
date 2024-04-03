package com.Lantz2024.March;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-03-24 15:27:52
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {
}

/**
 * 322. 零钱兑换
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
class Solution18 {
    public int coinChange(int[] coins, int amount) {
        int f[] = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for(int x : coins){
            for(int c = x; c <= amount; c++){
                f[c] = Math.min(f[c], f[c - x] + 1);
            }
        }
        int ans = f[amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
}
