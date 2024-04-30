package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra09
 * <p>Powered by Lantz On 2024-04-09 14:55:33
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra09
 * @since 1.8
 */
public class Pra09 {

}

/**
 * 2529. �������͸�������������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���� �ǵݼ�˳�� ���е����� nums ��������������Ŀ�͸�������Ŀ�е����ֵ��
 *
 * ���仰������� nums ������������Ŀ�� pos ��������������Ŀ�� neg ������ pos �� neg�����е����ֵ��
 * ע�⣺0 �Ȳ���������Ҳ���Ǹ�������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [-2,-1,-1,1,2,3]
 * �����3
 * ���ͣ����� 3 ���������� 3 ���������������õ������ֵ�� 3 ��
 * ʾ�� 2��
 *
 * ���룺nums = [-3,-2,-1,0,0,1,2]
 * �����3
 * ���ͣ����� 2 ���������� 3 ���������������õ������ֵ�� 3 ��
 * ʾ�� 3��
 *
 * ���룺nums = [5,20,66,1314]
 * �����4
 * ���ͣ����� 4 ���������� 0 ���������������õ������ֵ�� 4 ��
 */

class Solution09 {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        int n = nums.length;
        // int max = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) neg++;
            if(nums[i] > 0) pos++;
        }
        return Math.max(pos, neg);
    }
}
