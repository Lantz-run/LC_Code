package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra27
 * <p>Powered by Lantz On 2024-04-27 16:02:32
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra27
 * @since 1.8
 */
public class Pra27 {
}

/**
 * 2639. ��ѯ����ͼ��ÿһ�еĿ��
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ�� m x n �������� grid ��������ĳһ�еĿ������һ�����ֵ���� �ַ������� ��
 *
 * �ȷ�˵����� grid = [[-10], [3], [12]] ����ôΨһһ�еĿ���� 3 ����Ϊ -10 ���ַ�������Ϊ 3 ��
 * ���㷵��һ����СΪ n ���������� ans ������ ans[i] �ǵ� i �еĿ�ȡ�
 *
 * һ���� len ����λ������ x ������ǷǸ�������ô �ַ������� Ϊ len ������Ϊ len + 1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺grid = [[1],[22],[333]]
 * �����[3]
 * ���ͣ��� 0 ���У�333 �ַ�������Ϊ 3 ��
 * ʾ�� 2��
 *
 * ���룺grid = [[-15,1,3],[15,7,12],[5,6,-2]]
 * �����[3,1,2]
 * ���ͣ�
 * �� 0 ���У�ֻ�� -15 �ַ�������Ϊ 3 ��
 * �� 1 ���У������������ַ������ȶ��� 1 ��
 * �� 2 ���У�12 �� -2 ���ַ������ȶ�Ϊ 2 ��
 */

class Solution27 {
    public int[] findColumnWidth(int[][] grid) {
        /**
         -15 1  3
         15  7  12
         5   6  -2
         */
        int n = grid[0].length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            for(int[] row : grid){
                ans[i] = Math.max(ans[i], Integer.toString(row[i]).length());
            }
        }
        return ans;
    }
}
