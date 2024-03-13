package com.Lantz2024.March;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-03-05 15:39:53
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {

}

/**
 * 1976. 到达目的地的方案数
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，
 * 且任意两个路口之间最多有一条路。
 *
 * 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。
 * 你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
 *
 * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * 输出：4
 * 解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
 * 四条花费 7 分钟的路径分别为：
 * - 0 ? 6
 * - 0 ? 4 ? 6
 * - 0 ? 1 ? 2 ? 5 ? 6
 * - 0 ? 1 ? 3 ? 5 ? 6
 * 示例 2：
 *
 * 输入：n = 2, roads = [[1,0,10]]
 * 输出：1
 * 解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
 */
class Solution04 {
    public int countPaths(int n, int[][] roads) {
        long[][] g = new long[n][n]; // 邻接矩阵
        for(long[] row : g){
            Arrays.fill(row, Long.MAX_VALUE / 2); // 防止溢出
        }
        for (int[] r : roads){
            int x = r[0];
            int y = r[1];
            int d = r[2];
            g[x][y] = d;
            g[y][x] = d;
        }

        long[] dis = new long[n];
        Arrays.fill(dis, 1, n, Long.MAX_VALUE / 2);
        int[] f = new int[n];
        f[0] = 1;
        boolean[] done = new boolean[n];
        while(true){
            int x = -1;
            for(int i = 0; i < n; i++){
                if(!done[i] && (x < 0 || dis[i] < dis[x])){
                    x = i;
                }
            }
            if(x == n - 1){
                // 不会有比 dis[n-1] 更短或者一样短的最短路了，这个题目的边权都是正数
                return f[n-1];
            }
            done[x] = true; // 最短路长度已确定
            for(int y = 0; y < n; y++){ // 尝试更新 x 的邻居最短路
                long newDis = dis[x] + g[x][y];
                if(newDis < dis[y]){
                    // 最短路必须经过x
                    dis[y] = newDis;
                    f[y] = f[x];
                } else if(newDis == dis[y]){
                    // 和之前求的最短路一样长
                    f[y] = (f[y] + f[x]) % 1_000_000_007;
                }
            }
        }
    }
}
