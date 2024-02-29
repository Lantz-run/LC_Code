package com.DynamicPro.matrix;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra11
 * <p>Powered by Lantz On 2024-02-23 22:59:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra11
 * @since 1.8
 */
public class Pra11 {

}

/**
 * 931. 下降路径最小和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 *
 *
 *
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 */
class Solution11 {
    // 记忆化搜索
    private int[][] matrix, memo;
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        memo = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int c = 0; c < n; c++){
            ans = Math.min(ans, dfs(n-1, c));
        }
        return ans;
    }
    // 从下往上走
    private int dfs(int r, int c){
        // 边界条件
        if(c < 0 || c >= matrix.length) return Integer.MAX_VALUE;
        if(r == 0) return matrix[0][c]; // 到达第一行
        if(memo[r][c] != Integer.MIN_VALUE) return memo[r][c];
        return memo[r][c] = Math.min(Math.min(
                dfs(r-1, c-1), dfs(r-1, c)), dfs(r-1, c+1)) + matrix[r][c];
    }
}
