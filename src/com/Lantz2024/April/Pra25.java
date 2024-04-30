package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra25
 * <p>Powered by Lantz On 2024-04-25 08:21:34
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra25
 * @since 1.8
 */
public class Pra25 {
}

/**
 * 2739. ����ʻ����
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * �������������䡣��������������mainTank ��ʾ�������е�ȼ�ϣ�����Ϊ��λ����additionalTank ��ʾ�������е�ȼ�ϣ�����Ϊ��λ����
 *
 * �ÿ���ÿ�ķ� 1 ��ȼ�϶�������ʻ 10 km��ÿ��������ʹ���� 5 ��ȼ��ʱ����������������� 1 ��ȼ�ϣ���Ὣ 1 ��ȼ�ϴӸ�����ת�Ƶ������䡣
 *
 * ���ؿ���������ʻ�������롣
 *
 * ע�⣺�Ӹ�������������ע��ȼ�ϲ���������Ϊ����һ�¼�����ÿ���� 5 ��ȼ��ʱͻȻ������������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺mainTank = 5, additionalTank = 10
 * �����60
 * ���ͣ�
 * ���õ� 5 ��ȼ�Ϻ���������ȼ�ϻ�ʣ�� (5 - 5 + 1) = 1 ������ʻ����Ϊ 50km ��
 * ���õ�ʣ�µ� 1 ��ȼ�Ϻ�û���µ�ȼ��ע�뵽�������У��������Ϊ�ա�
 * ����ʻ����Ϊ 60km ��
 * ʾ�� 2��
 *
 * ���룺mainTank = 1, additionalTank = 2
 * �����10
 * ���ͣ�
 * ���õ� 1 ��ȼ�Ϻ��������Ϊ�ա�
 * ����ʻ����Ϊ 10km ��
 */

class Solution25 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while(mainTank >= 5){
            mainTank -= 5;
            res += 50;
            if(additionalTank != 0){
                additionalTank--;
                mainTank++;
            }
        }
        return res + mainTank * 10;
    }
}
