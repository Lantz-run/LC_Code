package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra31
 * <p>Powered by Lantz On 2024-05-31 17:54:51
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra31
 * @since 1.8
 */
public class Pra31 {
}

/**
 * 2965. 找出缺失和重复的数字
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 *
 * 任务是找出重复的数字a 和缺失的数字 b 。
 *
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,3],[2,2]]
 * 输出：[2,4]
 * 解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
 * 示例 2：
 *
 * 输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
 * 输出：[9,5]
 * 解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。
 */

class Solution31 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        for(int[] row : grid){
            for(int x : row){
                cnt[x]++;
            }
        }
        int[] ans = new int[2];
        for(int i = 0; i <= n * n ; i++){
            if(cnt[i] == 2){
                ans[0] = i; // 出现两次的数
            }
            if(cnt[i] == 0){
                ans[1] = i; // 出现零次的数
            }
        }
        return ans;
    }
}