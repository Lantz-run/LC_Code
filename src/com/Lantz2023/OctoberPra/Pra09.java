package com.Lantz2023.OctoberPra;

import java.util.Scanner;

/**
 * 2023.10.25 LeetCode第九题：回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Pra09 {
    public static void main(String[] args) {

        Solution09 solution09 = new Solution09();
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        boolean result = solution09.isPalindrome(x);
        System.out.println(result);
    }
}

class Solution09 {
    public boolean isPalindrome(int x) {
/*        解法一：用字符串暴力求解
        String reserveStr = (new StringBuilder(x+"")).reverse().toString();

        return (x+"").equals(reserveStr);*/


        if (x < 0 || x % 10 == 0 && x != 0) return false; // 没有以0作为开头的整数
        int reserveNumber = 0;
        while (x > reserveNumber){
            reserveNumber = reserveNumber * 10 + x % 10;
            x  /= 10;
        }

        return x == reserveNumber || x == reserveNumber / 10; // 忘了就用"121"例子调试一下


    }
}

// 2023.10.26 复盘第一次
class Solution09_1{
    public boolean isPalindrome(int x){
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int num = 0;
        while (x > num){
            num = num * 10 + x % 10;
            x /= 10;
        }

        return x == num || x == num / 10;
    }
}
