package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra12
 * <p>Powered by Lantz On 2024-03-16 16:15:34
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra12
 * @since 1.8
 */
public class Pra12 {

}

/**
 * 2684. 矩阵中移动的最大次数
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 *
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 *
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * 输出：3
 * 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * 可以证明这是能够移动的最大次数。
 * 示例 2：
 *
 *
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
 * 输出：0
 * 解释：从第一列的任一单元格开始都无法移动。
 *
 */
class Solution12 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int[] row : grid){
            row[0] *= -1; // 入队标记
        }
        for(int j = 0; j < n-1; j++){
            boolean ok = false;
            for(int i = 0; i < m; i++){
                if(grid[i][j] > 0){
                    continue; // 不在队列
                }
                for(int k = Math.max(i-1, 0); k < Math.min(i+2, m); k++){
                    if(grid[k][j + 1] > -grid[i][j] ){
                        grid[k][j+1] *= -1; // 入队标记
                        ok = true;
                    }
                }
            }
            if(!ok){ // 无法向右走
                return j;
            }
        }
        return n-1;
    }
}
