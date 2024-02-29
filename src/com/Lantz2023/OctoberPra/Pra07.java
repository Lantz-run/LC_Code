package com.Lantz2023.OctoberPra;

import java.util.Scanner;

/**
 * 2023.10.20
 *
 * LeetCode�� 7�⣺������ת
 *
 * ����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
 * �����ת���������� 32 λ���з��������ķ�Χ [?2^31,  2^31 ? 1] ���ͷ��� 0��
 *
 * ���軷��������洢 64 λ�������з��Ż��޷��ţ���(�ؼ���Ҫ��)
 *
 * ʾ�� 1��
 * ���룺x = 123
 * �����321
 *
 * ʾ�� 2��
 * ���룺x = -123
 * �����-321
 *
 * ʾ�� 3��
 * ���룺x = 120
 * �����21
 *
 * ʾ�� 4��
 * ���룺x = 0
 * �����0
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
         * �㷨˼�룺������ 1147483649������֣���������С��������� 2147483647�����ڷ�ת��ʹ��� 2147483647
         *         Ҫ���ж� 1147483649�Ƿ��ڷ�ת����� 2147483647������ʹ������һ�����ֽ��бȽϣ�����Ǵ��ڵĻ���
         *         �����ַ�ת��ͻ���ڹ涨�����ַ�Χ����֮��С��
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
