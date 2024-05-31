package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-05-04 09:26:52
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {
}

/**
 * 1235. �滮��ְ����
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ��������ÿ���ʱ��������ְ����׬Щ�㻨Ǯ��
 *
 * ������ n �ݼ�ְ������ÿ�ݹ���Ԥ�ƴ� startTime[i] ��ʼ�� endTime[i] ����������Ϊ profit[i]��
 *
 * ����һ�ݼ�ְ������������ʼʱ�� startTime������ʱ�� endTime ��Ԥ�Ʊ��� profit �������飬������㲢���ؿ��Ի�õ���󱨳ꡣ
 *
 * ע�⣬ʱ���ϳ����ص��� 2 �ݹ�������ͬʱ���С�
 *
 * �����ѡ��Ĺ�����ʱ�� X ��������ô��������̽�����ʱ�� X ��ʼ����һ�ݹ�����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * �����120
 * ���ͣ�
 * ����ѡ���� 1 �ݺ͵� 4 �ݹ�����
 * ʱ�䷶Χ�� [1-3]+[3-6]������ñ��� 120 = 50 + 70��
 * ʾ�� 2��
 *
 *
 *
 * ���룺startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * �����150
 * ���ͣ�
 * ����ѡ��� 1��4��5 �ݹ�����
 * ����ñ��� 150 = 20 + 70 + 60��
 * ʾ�� 3��
 *
 *
 *
 * ���룺startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * �����6
 *
 */

class Solution04 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // ������ʱ������

        int[] f = new int[n + 1];
        for(int i = 0; i < n; i++){
            int j = search(jobs, i, jobs[i][0]);
            f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
        }
        return f[n];
    }

    // ���� endTime <= upper ������±�
    private int search(int[][] jobs, int right, int upper){
        int left = -1;
        while(left + 1 < right){
            int mid = (left + right) >>> 1;
            if(jobs[mid][1] <= upper){
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}