package com.DynamicPro.Fibonacci;

import java.util.Scanner;

/**
 * 2023.10.21
 * ��̬�滮�����⣺�� N ��̩��������
 *
 * ̩���������� Tn �������£�
 *
 * T0 = 0, T1 = 1, T2 = 1, ���� n >= 0 �������� Tn+3 = Tn + Tn+1 + Tn+2
 *
 * �������� n���뷵�ص� n ��̩�������� Tn ��ֵ��
 *
 * ʾ�� 1��
 * ���룺n = 4
 * �����4
 * ���ͣ�
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * ʾ�� 2��
 * ���룺n = 25
 * �����1389537
 *
 *
 * ��ʾ��
 * 0 <= n <= 37
 * �𰸱�֤��һ�� 32 λ�������� answer <= 2^31 - 1
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
//        int[] arr = new int[40]; // �洢ÿһ�μ����̩��������
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
            // T_4 = 1 + 1 + 2 = 4   ��ʽÿһ�������궼Ҫ����һ��
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return t2;
    }
}
