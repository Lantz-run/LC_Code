package com.DynamicPro.Fibonacci;

/**
 * 2023.10.16
 *
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 *
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 *
 * ʾ�� 1��
 *
 * ���룺n = 2
 * �����2
 * ���ͣ������ַ�����������¥����
 * 1. 1 �� + 1 ��
 * 2. 2 ��
 * ʾ�� 2��
 *
 * ���룺n = 3
 * �����3
 * ���ͣ������ַ�����������¥����
 * 1. 1 �� + 1 �� + 1 ��
 * 2. 1 �� + 2 ��
 * 3. 2 �� + 1 ��
 */
public class Pra01 {
    public static void main(String[] args) {
        Solution_D01 solution_d01 = new Solution_D01();
        int n = 3;
        int result = solution_d01.climbStairs(n);
        System.out.println(result);

    }
}

/**
 * 쳲��������еĻ������ʣ�ÿ��������ǰ������֮��
 */
class Solution_D01 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1]; // 쳲�������Ҳ��0λ��������
        // dp[0] �洢���ǵ�0��쳲���������ͨ��Ϊ1����dp[1] �洢���ǵ�1��쳲���������Ҳͨ��Ϊ1��
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
