package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra24
 * <p>Powered by Lantz On 2024-05-24 18:15:16
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra24
 * @since 1.8
 */
public class Pra24 {
}

/**
 * 1673. 找出最具竞争力的子序列
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 *
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 *
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 * 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 *
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 */

class Solution24 {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] st = new int[k]; // 用数组模拟栈，容量大小为 k
        int m = 0; // 栈的大小
        for(int i = 0; i < n; i++){
            int x = nums[i];
            while(m > 0 && x < st[m - 1] && m + (n - i) > k){
                m--; // 弹出栈顶
            }
            if(m < k) st[m++] = x; // 入栈
        }
        return st;
    }
}
