package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra19
 * <p>Powered by Lantz On 2024-03-25 15:13:45
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra19
 * @since 1.8
 */
public class Pra19 {

}

/**
 * 518. ��Ǯ�һ� II
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
 *
 * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
 *
 * ����ÿһ������Ӳ�������޸���
 *
 * ��Ŀ���ݱ�֤������� 32 λ������������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺amount = 5, coins = [1, 2, 5]
 * �����4
 * ���ͣ������ַ�ʽ���Դճ��ܽ�
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * ʾ�� 2��
 *
 * ���룺amount = 3, coins = [2]
 * �����0
 * ���ͣ�ֻ����� 2 ��Ӳ�Ҳ��ܴճ��ܽ�� 3 ��
 * ʾ�� 3��
 *
 * ���룺amount = 10, coins = [10]
 * �����1
 */
class Solution19 {
    public int change(int amount, int[] coins) {
        int f[] = new int[amount + 1];
        f[0] = 1;
        for(int x : coins){
            for(int c = x; c <= amount; c++){
                f[c] += f[c - x];
            }
        }
        return f[amount];
    }
}
