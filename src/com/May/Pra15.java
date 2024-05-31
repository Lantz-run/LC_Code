package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-05-15 15:26:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {
}

/**
 * 2589. 完成所有任务的最少时间
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，
 * 其中 tasks[i] = [starti, endi, durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。
 *
 * 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。
 *
 * 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [[2,3,1],[4,5,1],[1,5,2]]
 * 输出：2
 * 解释：
 * - 第一个任务在闭区间 [2, 2] 运行。
 * - 第二个任务在闭区间 [5, 5] 运行。
 * - 第三个任务在闭区间 [2, 2] 和 [5, 5] 运行。
 * 电脑总共运行 2 个整数时间点。
 * 示例 2：
 *
 * 输入：tasks = [[1,3,2],[2,5,3],[5,6,2]]
 * 输出：4
 * 解释：
 * - 第一个任务在闭区间 [2, 3] 运行
 * - 第二个任务在闭区间 [2, 3] 和 [5, 5] 运行。
 * - 第三个任务在闭区间 [5, 6] 运行。
 * 电脑总共运行 4 个整数时间点。
 */

class Solution15 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int mx = tasks[tasks.length - 1][1];
        int ans = 0;
        boolean[] run = new boolean[mx + 1];
        for(int[] t : tasks){
            int start = t[0];
            int end = t[1];
            int d = t[2];
            for(int i = start; i <= end; i++){
                if(run[i]){
                    d--; // 去掉运行中的时间点
                }
            }
            for(int i = end; d > 0; i--){ // 剩下的 d 填充区间的后缀
                if(!run[i]){
                    run[i] = true; // 运行
                    d--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
