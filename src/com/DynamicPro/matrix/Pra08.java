package com.DynamicPro.matrix;

/**
 * <p>Project: Algorithm20230913 - Pra08
 * <p>Powered by Lantz On 2023-12-28 22:40:24
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra08
 * @since 1.8
 */
public class Pra08 {
    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        int[][] grid = {{1,2,3}, {4,5,6}};
        int result = solution08.minPathSum(grid);
        System.out.println(result);
    }
}

class Solution08 {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue; // 指的就是位于第一个格子（从左往右，从上往下）
                else if (i == 0) grid[i][j] = grid[i][j] + grid[i][j-1];
                else if (j == 0) grid[i][j] = grid[i][j] + grid[i-1][j];
                else grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
