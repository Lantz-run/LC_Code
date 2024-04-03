package com.Lantz2024.March;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-03-24 15:27:52
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {
}

/**
 * 322. ��Ǯ�һ�
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
 *
 * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ����� -1 ��
 *
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺coins = [1, 2, 5], amount = 11
 * �����3
 * ���ͣ�11 = 5 + 5 + 1
 * ʾ�� 2��
 *
 * ���룺coins = [2], amount = 3
 * �����-1
 * ʾ�� 3��
 *
 * ���룺coins = [1], amount = 0
 * �����0
 */
class Solution18 {
    public int coinChange(int[] coins, int amount) {
        int f[] = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for(int x : coins){
            for(int c = x; c <= amount; c++){
                f[c] = Math.min(f[c], f[c - x] + 1);
            }
        }
        int ans = f[amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
}
