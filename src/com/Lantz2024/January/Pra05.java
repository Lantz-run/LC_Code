package com.Lantz2024.January;

/**
 * <p>Project: Algorithm20230913 - Pra05
 * <p>Powered by Lantz On 2024-01-23 20:06:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra05
 * @since 1.8
 */
public class Pra05 {
    public static void main(String[] args) {

    }
}

/**
 * ����һ���±�� 0 ��ʼ���������� nums ����� nums �г���Ϊ m �������� s �����������������ǳ�����һ�� ���������� ��
 *
 * m ���� 1 ��
 * s1 = s0 + 1 ��
 * �±�� 0 ��ʼ�������� s ������ [s0, s1, s0, s1,...,s(m-1) % 2] һ����
 * Ҳ����˵��s1 - s0 = 1 ��s2 - s1 = -1 ��s3 - s2 = 1 ��s4 - s3 = -1 ���Դ����ƣ�ֱ�� s[m - 1] - s[m - 2] = (-1)m ��
 * ���㷵�� nums ������ ���� �������У���ĳ��ȣ���������ڽ��������飬���㷵�� -1 ��
 *
 * ��������һ��������һ������ �ǿ� ��Ԫ�����С�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [2,3,4,3,4]
 * �����4
 * ���ͣ������������� [3,4] ��[3,4,3] �� [3,4,3,4] �����������Ϊ [3,4,3,4] ������Ϊ4 ��
 * ʾ�� 2��
 *
 * ���룺nums = [4,5,6]
 * �����2
 * ���ͣ�[4,5] �� [5,6] �ǽ��е��������������顣���ǳ��ȶ�Ϊ 2 ��
 */
class Solution05 {
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        int i = 0;
        int n = nums.length;
        while(i < n-1){
            if(nums[i+1] - nums[i] != 1){
                i++;
                continue;
            }
            int i0 = i; // ��¼������Ŀ�ʼλ��
            i += 2; // i��i+1�Ѿ�����Ҫ�󣬴�i+2��ʼ
            while(i < n && nums[i] == nums[i0] + (i-i0) % 2){
                i++;
            }
            // ��i0��i-1��������ĿҪ��ģ����޷��ӳ���
            ans = Math.max(ans, i-i0);
            i--;

        }
        return ans;
    }
}
