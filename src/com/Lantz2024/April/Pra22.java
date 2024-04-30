package com.Lantz2024.April;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra22
 * <p>Powered by Lantz On 2024-04-22 12:54:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra22
 * @since 1.8
 */
public class Pra22 {

}

/**
 * 377. 组合总和 Ⅳ
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 */

class Solution22 {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1); // -1 代表没有被计算过
        return dfs(target, nums, memo);
    }

    private int dfs(int i, int[] nums, int[] memo){
        if(i == 0){ // 爬完了
            return 1;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int res = 0;
        for(int x : nums){
            if(x <= i){
                res += dfs(i - x, nums, memo);
            }
        }
        return memo[i] = res;
    }
}