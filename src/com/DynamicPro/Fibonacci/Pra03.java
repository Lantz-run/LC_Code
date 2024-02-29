package com.DynamicPro.Fibonacci;

import java.util.Scanner;

/**
 * 2023.10.21
 * 动态规划第三题：第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 *
 *
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1
 */
public class Pra03 {
    public static void main(String[] args) {
        Solution_D03 solution_d03 = new Solution_D03();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = solution_d03.tribonacci(n);
        System.out.println(result);

    }
}

class Solution_D03 {
    public int tribonacci(int n) {
//        int[] arr = new int[40]; // 存储每一次计算的泰波那契数
//        if (n < 0 || n > 37) return -1;
//        if (n == 0) return 0;
//        if (n == 1 || n == 2) return 1;
//
//        if (arr[n] != 0) return arr[n];
//        arr[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
//
//        return arr[n];

        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n ; i++) {
            int tn = t0 + t1 + t2;
            // T_3 = 0 + 1 + 1 = 2
            // T_4 = 1 + 1 + 2 = 4   公式每一次运算完都要迭代一次
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return t2;
    }
}
