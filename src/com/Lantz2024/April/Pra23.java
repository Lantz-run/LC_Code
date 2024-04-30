package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra23
 * <p>Powered by Lantz On 2024-04-23 15:27:57
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra23
 * @since 1.8
 */
public class Pra23 {

}

/**
 * 1052. ������������ϰ�
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ��һ������ϰ壬������꿪�� n ���ӡ�ÿ���Ӷ���һЩ�˿ͽ�������̵ꡣ����һ������Ϊ n ���������� customers ��
 * ���� customers[i] ���ڵ� i ���ӿ�ʼʱ�����̵�Ĺ˿�������������Щ�˿��ڵ� i ���ӽ������뿪��
 *
 * ��ĳЩʱ������ϰ�������� �������ϰ��ڵ� i ������������ô grumpy[i] = 1������ grumpy[i] = 0��
 *
 * ������ϰ�����ʱ����һ���ӵĹ˿;ͻ᲻���⣬���ϰ岻������˿�������ġ�
 *
 * ����ϰ�֪��һ�����ܼ��ɣ��������Լ����������������Լ����� minutes ���Ӳ���������ȴֻ��ʹ��һ�Ρ�
 *
 * ���㷵�� ��һ��Ӫҵ����������ж��ٿͻ��ܹ��е����� ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * �����16
 * ���ͣ�����ϰ������ 3 ���ӱ����侲��
 * �е���������ͻ����� = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * ʾ�� 2��
 *
 * ���룺customers = [1], grumpy = [0], minutes = 1
 * �����1
 *
 *
 * ��ʾ��
 *
 * n == customers.length == grumpy.length
 * 1 <= minutes <= n <= 2 * 104
 * 0 <= customers[i] <= 1000
 * grumpy[i] == 0 or 1
 */

class Solution23 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] s = new int[2];
        int maxS1 = 0;
        for(int i = 0; i < customers.length; i++){
            s[grumpy[i]] += customers[i];
            // ������ݷ�Χ
            if(i < minutes - 1){ // ���ڳ��Ȳ��� minutes
                continue;
            }
            maxS1 = Math.max(maxS1, s[1]);
            s[1] -= grumpy[i - minutes + 1] > 0 ? customers[i - minutes + 1] : 0; // ���������Ԫ�����뿪����
        }
        return s[0] + maxS1;
    }
}
