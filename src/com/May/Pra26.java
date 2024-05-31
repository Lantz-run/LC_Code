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
 * 1738. �ҳ��� K ����������ֵ
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ����ά���� matrix ��һ������ k �������СΪ m x n �ɷǸ�������ɡ�
 *
 * ���������� (a, b) �� ֵ ���ɶ��������� 0 <= i <= a < m �� 0 <= j <= b < n ��Ԫ�� matrix[i][j]���±�� 0 ��ʼ������ִ���������õ���
 *
 * �����ҳ� matrix �����������е� k ���ֵ��k ��ֵ�� 1 ��ʼ��������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺matrix = [[5,2],[1,6]], k = 1
 * �����7
 * ���ͣ����� (0,1) ��ֵ�� 5 XOR 2 = 7 ��Ϊ����ֵ��
 * ʾ�� 2��
 *
 * ���룺matrix = [[5,2],[1,6]], k = 2
 * �����5
 * ���ͣ����� (0,0) ��ֵ�� 5 = 5 ��Ϊ�� 2 ���ֵ��
 * ʾ�� 3��
 *
 * ���룺matrix = [[5,2],[1,6]], k = 3
 * �����4
 * ���ͣ����� (1,0) ��ֵ�� 5 XOR 1 = 4 ��Ϊ�� 3 ���ֵ��
 * ʾ�� 4��
 *
 * ���룺matrix = [[5,2],[1,6]], k = 4
 * �����0
 * ���ͣ����� (1,1) ��ֵ�� 5 XOR 2 XOR 1 XOR 6 = 0 ��Ϊ�� 4 ���ֵ
 */

class Solution26 {
    public int kthLargestValue(int[][] matrix, int k) {
        /**
         * ������ �������λ��ͬ������Ϊ0���������λ��ͬ������Ϊ1
         * 3 ^= 5
         * 3 �Ķ����Ʊ�ʾ�� 011
         * 5 �Ķ����Ʊ�ʾ�� 101
         * �������010
         * ���Ϊ��2
         *
         * 5 ^= 5 101 ^ 101 = 000
         */
        // ��άǰ׺��
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
