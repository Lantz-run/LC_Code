package com.DynamicPro.matrix;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra11
 * <p>Powered by Lantz On 2024-02-23 22:59:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra11
 * @since 1.8
 */
public class Pra11 {

}

/**
 * 931. �½�·����С��
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ�� n x n �� ���� �������� matrix �������ҳ�������ͨ�� matrix ���½�·�� �� ��С�� ��
 *
 * �½�·�� ���Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�У���λ�����·������ضԽ�������������ҵĵ�һ��Ԫ�أ���
 * ������˵��λ�� (row, col) ����һ��Ԫ��Ӧ���� (row + 1, col - 1)��(row + 1, col) ���� (row + 1, col + 1) ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * �����13
 * ���ͣ���ͼ��ʾ��Ϊ����С�������½�·��
 * ʾ�� 2��
 *
 *
 *
 * ���룺matrix = [[-19,57],[-40,-5]]
 * �����-59
 * ���ͣ���ͼ��ʾ��Ϊ����С���½�·��
 */
class Solution11 {
    // ���仯����
    private int[][] matrix, memo;
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        memo = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int c = 0; c < n; c++){
            ans = Math.min(ans, dfs(n-1, c));
        }
        return ans;
    }
    // ����������
    private int dfs(int r, int c){
        // �߽�����
        if(c < 0 || c >= matrix.length) return Integer.MAX_VALUE;
        if(r == 0) return matrix[0][c]; // �����һ��
        if(memo[r][c] != Integer.MIN_VALUE) return memo[r][c];
        return memo[r][c] = Math.min(Math.min(
                dfs(r-1, c-1), dfs(r-1, c)), dfs(r-1, c+1)) + matrix[r][c];
    }
}
