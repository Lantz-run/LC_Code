package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra17
 * <p>Powered by Lantz On 2024-05-17 12:01:24
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra17
 * @since 1.8
 */
public class Pra17 {
}

/**
 * 826. 安排工作以达到最大收益
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 *
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 *
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 示例 2:
 *
 * 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * 输出:
 */

class Solution17 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for(int i = 0; i < n; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker); // 从小到大排序

        // 双指针
        int ans = 0, j = 0, maxProfix = 0;
        for(int w : worker){
            while(j < n && jobs[j][0] <= w){
                maxProfix = Math.max(maxProfix, jobs[j++][1]);
            }
            ans += maxProfix;
        }
        return ans;
    }
}
