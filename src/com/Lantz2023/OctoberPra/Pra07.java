package com.Lantz2023.OctoberPra;

import java.util.Scanner;

/**
 * 2023.10.20
 *
 * LeetCode第 7题：整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [?2^31,  2^31 ? 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。(关键的要求)
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class Pra07 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int result = solution7.reverse(x);
        System.out.println(result);


    }
}

class Solution7 {
    public int reverse(int x) {
        /**
         * 算法思想：假设有 1147483649这个数字，现在它是小于最大数字 2147483647，但在反转后就大于 2147483647
         *         要想判断 1147483649是否在反转后大于 2147483647，可以使用最后的一个数字进行比较，如果是大于的话，
         *         那数字反转后就会大于规定的数字范围，反之则小于
         */
        if (x == 0) return 0;
        int res = 0;
        while (x != 0){
            int temp = x % 10;
            if (res > 214748364 || (res == 214748364 && temp > 7) ) return 0;
            if (res < -214748364 || (res == -214748364 && temp < -8)) return 0;
            res = res*10 + temp;
            x = x / 10;

        }

        return res;
//        if (x == 0) return 0;
//
//        int res = 0;
//        while (x != 0){
//            int temp = x % 10;
//            if (res > 214748364 || (res == 214748364 && temp > 7)){
//                return 0;
//            }
//            if (res < -214748364 || (res == -214748364 && temp < -8)){
//                return 0;
//            }
//            res = res * 10 + temp;
//            x = x / 10;
//
//        }
//
//        return res;

    }
}
