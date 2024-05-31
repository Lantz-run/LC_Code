package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra10
 * <p>Powered by Lantz On 2024-05-11 12:32:06
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra10
 * @since 1.8
 */
public class Pra10 {
}

/**
 * 2960. ͳ���Ѳ����豸
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ������Ϊ n ���±�� 0 ��ʼ���������� batteryPercentages ����ʾ n ���豸�ĵ�ذٷֱȡ�
 *
 * ��������ǰ���˳�����ÿ���豸 i��ִ�����²��Բ�����
 *
 * ��� batteryPercentages[i] ���� 0��
 * ���� �Ѳ����豸�ļ�����
 * ���±��� [i + 1, n - 1] �������豸�ĵ�ذٷֱȼ��� 1��ȷ�����ǵĵ�ذٷֱ� ������� 0 ��
 * �� batteryPercentages[j] = max(0, batteryPercentages[j] - 1)��
 * �ƶ�����һ���豸��
 * �����ƶ�����һ���豸����ִ���κβ��ԡ�
 * ����һ����������ʾ��˳��ִ�в��Բ����� �Ѳ����豸 ��������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺batteryPercentages = [1,1,2,1,3]
 * �����3
 * ���ͣ���˳����豸 0 ��ʼִ�в��Բ�����
 * ���豸 0 �ϣ�batteryPercentages[0] > 0 �������� 1 ���Ѳ����豸��batteryPercentages ��Ϊ [1,0,1,0,2] ��
 * ���豸 1 �ϣ�batteryPercentages[1] == 0 ���ƶ�����һ���豸�������в��ԡ�
 * ���豸 2 �ϣ�batteryPercentages[2] > 0 �������� 2 ���Ѳ����豸��batteryPercentages ��Ϊ [1,0,1,0,1] ��
 * ���豸 3 �ϣ�batteryPercentages[3] == 0 ���ƶ�����һ���豸�������в��ԡ�
 * ���豸 4 �ϣ�batteryPercentages[4] > 0 �������� 3 ���Ѳ����豸��batteryPercentages ���ֲ��䡣
 * ��ˣ����� 3 ��
 * ʾ�� 2��
 *
 * ���룺batteryPercentages = [0,1,2]
 * �����2
 * ���ͣ���˳����豸 0 ��ʼִ�в��Բ�����
 * ���豸 0 �ϣ�batteryPercentages[0] == 0 ���ƶ�����һ���豸�������в��ԡ�
 * ���豸 1 �ϣ�batteryPercentages[1] > 0 �������� 1 ���Ѳ����豸��batteryPercentages ��Ϊ [0,1,1] ��
 * ���豸 2 �ϣ�batteryPercentages[2] > 0 �������� 2 ���Ѳ����豸��batteryPercentages ���ֲ��䡣
 * ��ˣ����� 2 ��
 *
 */

class Solution10 {
    public int countTestedDevices(int[] batteryPercentages) {
        /**
         �������
         x > 0 �ͰѺ������������һ����ans����Ǽ�һ�Ĵ���

         */
        int n = batteryPercentages.length;
        int ans = 0; // ��һ�Ĵ���
        for(int x : batteryPercentages){
            if(x > ans){
                ans++;
            }
        }
        return ans;
    }
}
