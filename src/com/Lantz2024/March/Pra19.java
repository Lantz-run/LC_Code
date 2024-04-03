package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra19
 * <p>Powered by Lantz On 2024-03-25 15:13:45
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra19
 * @since 1.8
 */
public class Pra19 {

}

/**
 * 518. 零钱兑换 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 *
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 *
 * 输入：amount = 10, coins = [10]
 * 输出：1
 */
class Solution19 {
    public int change(int amount, int[] coins) {
        int f[] = new int[amount + 1];
        f[0] = 1;
        for(int x : coins){
            for(int c = x; c <= amount; c++){
                f[c] += f[c - x];
            }
        }
        return f[amount];
    }
}
