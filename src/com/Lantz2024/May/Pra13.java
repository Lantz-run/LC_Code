package com.Lantz2024.May;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-05-13 15:15:54
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {
}

/**
 * 994. 腐烂的橘子
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0
 */

class Solution13 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> q = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++; // 统计新鲜橘子的个数
                } else if(grid[i][j] == 2){
                    q.add(new int[]{i, j}); // 一开始就腐烂的橘子的个数
                }
            }
        }

        int ans = -1;
        while(!q.isEmpty()){
            ans++; // 经过一分钟
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for(int[] pos : tmp){ // 已经腐烂的橘子
                for(int[] d : DIRECTIONS){
                    // 开始的位置
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    if(0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1){
                        fresh--;
                        grid[i][j] = 2; // 变成腐烂的橘子
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : Math.max(ans, 0);
    }
}
