package com.DynamicPro.matrix;

import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra10
 * <p>Powered by Lantz On 2024-01-06 14:56:45
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra10
 * @since 1.8
 */
public class Pra10 {
    public static void main(String[] args) {

    }
}

/**
 * 120. ��������С·����
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ�������� triangle ���ҳ��Զ����µ���С·���͡�
 *
 * ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ����ڵĽ�� ������ָ���� �±� �� ��һ�����±�
 * ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣Ҳ����˵�������λ�ڵ�ǰ�е��±� i ����ô��һ�������ƶ�����һ�е��±� i �� i + 1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * �����11
 * ���ͣ��������ͼ��ʾ��
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * �Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����
 * ʾ�� 2��
 *
 * ���룺triangle = [[-10]]
 * �����-10
 */
class Solution10 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        // �Ӻ��濪ʼö��
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}