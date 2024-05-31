package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-05-15 15:26:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {
}

/**
 * 2589. ����������������ʱ��
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ̨���ԣ������� ͬʱ �������������񡣸���һ����ά�������� tasks ��
 * ���� tasks[i] = [starti, endi, durationi] ��ʾ�� i ��������Ҫ�� ������ ʱ��� [starti, endi] ������ durationi ������ʱ��㣨������Ҫ��������
 *
 * ��������Ҫ��������ʱ������Դ򿪵��ԣ��������ʱ������Խ����Թرա�
 *
 * ���㷵������������������£�����������Ҫ���ж����롣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺tasks = [[2,3,1],[4,5,1],[1,5,2]]
 * �����2
 * ���ͣ�
 * - ��һ�������ڱ����� [2, 2] ���С�
 * - �ڶ��������ڱ����� [5, 5] ���С�
 * - �����������ڱ����� [2, 2] �� [5, 5] ���С�
 * �����ܹ����� 2 ������ʱ��㡣
 * ʾ�� 2��
 *
 * ���룺tasks = [[1,3,2],[2,5,3],[5,6,2]]
 * �����4
 * ���ͣ�
 * - ��һ�������ڱ����� [2, 3] ����
 * - �ڶ��������ڱ����� [2, 3] �� [5, 5] ���С�
 * - �����������ڱ����� [5, 6] ���С�
 * �����ܹ����� 4 ������ʱ��㡣
 */

class Solution15 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int mx = tasks[tasks.length - 1][1];
        int ans = 0;
        boolean[] run = new boolean[mx + 1];
        for(int[] t : tasks){
            int start = t[0];
            int end = t[1];
            int d = t[2];
            for(int i = start; i <= end; i++){
                if(run[i]){
                    d--; // ȥ�������е�ʱ���
                }
            }
            for(int i = end; d > 0; i--){ // ʣ�µ� d �������ĺ�׺
                if(!run[i]){
                    run[i] = true; // ����
                    d--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
