package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra31
 * <p>Powered by Lantz On 2024-05-31 17:54:51
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra31
 * @since 1.8
 */
public class Pra31 {
}

/**
 * 2965. �ҳ�ȱʧ���ظ�������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ���±�� 0 ��ʼ�Ķ�ά�������� grid����СΪ n * n �����е�ֵ�� [1, n2] ��Χ�ڡ����� a ���� ���Σ�b ȱʧ ֮�⣬ÿ�������� ǡ�ó���һ�� ��
 *
 * �������ҳ��ظ�������a ��ȱʧ������ b ��
 *
 * ����һ���±�� 0 ��ʼ������Ϊ 2 ���������� ans ������ ans[0] ���� a ��ans[1] ���� b ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺grid = [[1,3],[2,2]]
 * �����[2,4]
 * ���ͣ����� 2 �ظ������� 4 ȱʧ�����Դ��� [2,4] ��
 * ʾ�� 2��
 *
 * ���룺grid = [[9,1,7],[8,9,2],[3,4,6]]
 * �����[9,5]
 * ���ͣ����� 9 �ظ������� 5 ȱʧ�����Դ��� [9,5] ��
 */

class Solution31 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        for(int[] row : grid){
            for(int x : row){
                cnt[x]++;
            }
        }
        int[] ans = new int[2];
        for(int i = 0; i <= n * n ; i++){
            if(cnt[i] == 2){
                ans[0] = i; // �������ε���
            }
            if(cnt[i] == 0){
                ans[1] = i; // ������ε���
            }
        }
        return ans;
    }
}