package com.DynamicPro.matrix;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2023-12-23 10:21:01
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 *
 * 动态规划：不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 *
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 */
public class Pra07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int m = 3, n = 2;
        int result = solution07.uniquePaths(m, n);
        System.out.println(result);
    }
}

class Solution07 {
    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//         }
//        for (int j = 0; j < n; j++) {
//            dp[0][j] = 1;
//        }
//        // 由于上面初始化了1，所以要会从1开始
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
        int[] dp = new int[n];
        Arrays.fill(dp,1); // 第一行列初始化为1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }
}