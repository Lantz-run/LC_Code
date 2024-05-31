package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra26
 * <p>Powered by Lantz On 2024-05-26 11:38:13
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra26
 * @since 1.8
 */
public class Pra26 {
}

/**
 * 1738. 找出第 K 大的异或坐标值
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值
 */

class Solution26 {
    public int kthLargestValue(int[][] matrix, int k) {
        /**
         * 异或操作 如果两个位相同，则结果为0。如果两个位不同，则结果为1
         * 3 ^= 5
         * 3 的二进制表示： 011
         * 5 的二进制表示： 101
         * 异或结果：010
         * 结果为：2
         *
         * 5 ^= 5 101 ^ 101 = 000
         */
        // 二维前缀和
        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m * n];
        int[][] s = new int[m + 1][n + 1];
        int idx = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                s[i + 1][j + 1] = s[i + 1][j] ^ s[i][j + 1] ^ s[i][j] ^ matrix[i][j];
                a[idx++] = s[i + 1][j + 1];
            }
        }
        Arrays.sort(a);
        return a[idx - k];
    }
}
