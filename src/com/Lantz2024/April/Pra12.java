package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra12
 * <p>Powered by Lantz On 2024-04-12 11:52:00
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra12
 * @since 1.8
 */
public class Pra12 {

}

/**
 * 2923. 找到冠军 I
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
 *
 * 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：
 * 如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
 *
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 *
 * 返回这场比赛中将会成为冠军的队伍。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[0,1],[0,0]]
 * 输出：0
 * 解释：比赛中有两支队伍。
 * grid[0][1] == 1 表示 0 队比 1 队强。所以 0 队是冠军。
 * 示例 2：
 *
 * 输入：grid = [[0,0,1],[1,0,1],[0,0,0]]
 * 输出：1
 * 解释：比赛中有三支队伍。
 * grid[1][0] == 1 表示 1 队比 0 队强。
 * grid[1][2] == 1 表示 1 队比 2 队强。
 * 所以 1 队是冠军。
 */

class Solution12 {
    public int findChampion(int[][] grid) {
        int ans = 0;
        for(int i = 1; i < grid.length; i++){
            if(grid[i][ans] == 1){
                ans = i;
            }
        }
        return ans;
    }
}
