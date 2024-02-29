package com.DynamicPro.Fibonacci;

/**
 * 2023.10.16
 * 쳲���������
 *
 * 쳲������� ��ͨ���� F(n) ��ʾ���γɵ����г�Ϊ 쳲��������� ���������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
 * F(0) = 0��F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)������ n > 1
 * ���� n ������� F(n) ��
 *
 * ʾ�� 1��
 *
 * ���룺n = 2
 * �����1
 * ���ͣ�F(2) = F(1) + F(0) = 1 + 0 = 1
 * ʾ�� 2��
 *
 * ���룺n = 3
 * �����2
 * ���ͣ�F(3) = F(2) + F(1) = 1 + 1 = 2
 * ʾ�� 3��
 *
 * ���룺n = 4
 * �����3
 * ���ͣ�F(4) = F(3) + F(2) = 2 + 1 = 3
 */
public class Pra02 {
    public static void main(String[] args) {
        Solution_D02 solution_d02 = new Solution_D02();
        int n = 0;
        int result = solution_d02.fib(n);
        System.out.println(result);

    }
}

class Solution_D02 {
    public int fib(int n) {
        int[] F = new int[n+1];
        if (n <= 1){
            return n;
        }
        F[0] = 0;
        F[1] = 1;

        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        return F[n];
    }
}
