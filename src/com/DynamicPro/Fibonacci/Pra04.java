package com.DynamicPro.Fibonacci;

/**
 * 2023.10.26
 * ��̬�滮�����⣺ʹ����С������¥��
 *
 * ����һ���������� cost ������ cost[i] �Ǵ�¥�ݵ� i ��̨����������Ҫ֧���ķ��á�һ����֧���˷��ã�����ѡ��������һ����������̨�ס�
 * �����ѡ����±�Ϊ 0 ���±�Ϊ 1 ��̨�׿�ʼ��¥�ݡ�
 * ������㲢���شﵽ¥�ݶ�������ͻ��ѡ�
 *
 * ʾ�� 1��
 * ���룺cost = [10,15,20]
 * �����15
 * ���ͣ��㽫���±�Ϊ 1 ��̨�׿�ʼ��
 * - ֧�� 15 ������������̨�ף�����¥�ݶ�����
 * �ܻ���Ϊ 15
 *
 * ʾ�� 2��
 * ���룺cost = [1,100,1,1,1,100,1,1,100,1]
 * �����6
 * ���ͣ��㽫���±�Ϊ 0 ��̨�׿�ʼ��
 * - ֧�� 1 ������������̨�ף������±�Ϊ 2 ��̨�ס�
 * - ֧�� 1 ������������̨�ף������±�Ϊ 4 ��̨�ס�
 * - ֧�� 1 ������������̨�ף������±�Ϊ 6 ��̨�ס�
 * - ֧�� 1 ��������һ��̨�ף������±�Ϊ 7 ��̨�ס�
 * - ֧�� 1 ������������̨�ף������±�Ϊ 9 ��̨�ס�
 * - ֧�� 1 ��������һ��̨�ף�����¥�ݶ�����
 * �ܻ���Ϊ 6 ��
 *
 *
 * ��ʾ��
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 */
public class Pra04 {
    public static void main(String[] args) {
        Solution_D04 solution_d04 = new Solution_D04();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int result = solution_d04.minCostClimbingStairs(cost);
        System.out.println(result);

    }
}

/**
 * @Lantz
 * tips: ��֧������¥��
 * 1�������i��¥�ݾ�Ҫ����cost[i], ��ô�� i-1 �׾�Ҫ���� cost[i-1]
 * 2��cost[i]�����0��ʼ���� i+1�ף����� i+1����¥�ݶ�������1��ʼ��i����¥�ݶ���
 */
class Solution_D04 {
    public int minCostClimbingStairs(int[] cost) {
//        int size = cost.length;
//        int[] mincost = new int[size];
//        mincost[0] = 0;
//        mincost[1] = Math.min(cost[0], cost[1]);
//        // �Ѿ���ʼ����0��1��¥�ݣ����Դ�2��ʼ
//        for (int i = 2; i < size; i++) {
//            mincost[i] = Math.min(mincost[i-1]+cost[i], mincost[i-2]+cost[i-1]);
//
//        }
//
//        return mincost[size-1];

        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);

        }

        return dp[len];
    }
}