package com.DynamicPro.matrix;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2023-12-23 10:21:01
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 *
 * ��̬�滮����ͬ·��
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 *
 * ���ܹ��ж�������ͬ��·����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺m = 3, n = 7
 * �����28
 *
 * ʾ�� 2��
 *
 * ���룺m = 3, n = 2
 * �����3
 * ���ͣ�
 * �����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
 * 1. ���� -> ���� -> ����
 * 2. ���� -> ���� -> ����
 * 3. ���� -> ���� -> ����
 *
 * ʾ�� 3��
 *
 * ���룺m = 7, n = 3
 * �����28
 *
 * ʾ�� 4��
 *
 * ���룺m = 3, n = 3
 * �����6
 */
public class Pra07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int m = 3, n = 2;
        int result = solution07.uniquePaths(m, n);
        System.out.println(result);
    }
}

class Solution07 {
    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//         }
//        for (int j = 0; j < n; j++) {
//            dp[0][j] = 1;
//        }
//        // ���������ʼ����1������Ҫ���1��ʼ
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
        int[] dp = new int[n];
        Arrays.fill(dp,1); // ��һ���г�ʼ��Ϊ1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }
}