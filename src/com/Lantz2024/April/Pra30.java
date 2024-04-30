package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra30
 * <p>Powered by Lantz On 2024-04-30 22:24:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra30
 * @since 1.8
 */
public class Pra30 {
}

/**
 * 2798. ����Ŀ�깤��ʱ����Ա����Ŀ
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ��˾�ﹲ�� n ��Ա�������� 0 �� n - 1 ��š�ÿ��Ա�� i �Ѿ��ڹ�˾������ hours[i] Сʱ��
 *
 * ��˾Ҫ��ÿλԱ������ ���� target Сʱ��
 *
 * ����һ���±�� 0 ��ʼ������Ϊ n �ķǸ��������� hours ��һ���Ǹ����� target ��
 *
 * ������������ʾ�����ع������� target Сʱ��Ա������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺hours = [0,1,2,3,4], target = 2
 * �����3
 * ���ͣ���˾Ҫ��ÿλԱ���������� 2 Сʱ��
 * - Ա�� 0 ���� 0 Сʱ��������Ҫ��
 * - Ա�� 1 ���� 1 Сʱ��������Ҫ��
 * - Ա�� 2 ���� 2 Сʱ������Ҫ��
 * - Ա�� 3 ���� 3 Сʱ������Ҫ��
 * - Ա�� 4 ���� 4 Сʱ������Ҫ��
 * ���� 3 λ����Ҫ���Ա����
 * ʾ�� 2��
 *
 * ���룺hours = [5,1,4,2,2], target = 6
 * �����0
 * ���ͣ���˾Ҫ��ÿλԱ���������� 6 Сʱ��
 * ���� 0 λ����Ҫ���Ա����
 */

class Solution30 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int n = hours.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(hours[i] >= target){
                ans++;
            }
        }
        return ans;
    }
}
