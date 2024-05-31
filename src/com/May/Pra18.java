package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-05-18 14:54:26
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {
    public static void main(String[] args) {
        System.out.println(9 % 3);
    }
}

/**
 * 2644. �ҳ��������Ե÷���������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ���������±�� 0 ��ʼ���������� nums �� divisors ��
 *
 * divisors[i] �� �������Ե÷� �������� nums[j] �ܱ� divisors[i] �������±� j ��������
 *
 * ���� �������Ե÷� �������� divisors[i] ������ж�������������÷֣��򷵻���ֵ��С��һ����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,7,9,3,9], divisors = [5,2,3]
 * �����3
 * ���ͣ�divisors ��ÿ��Ԫ�صĿ������Ե÷�Ϊ��
 * divisors[0] �Ŀ������Ե÷�Ϊ 0 ����Ϊ nums ��û���κ������ܱ� 5 ������
 * divisors[1] �Ŀ������Ե÷�Ϊ 1 ����Ϊ nums[0] �ܱ� 2 ������
 * divisors[2] �Ŀ������Ե÷�Ϊ 3 ����Ϊ nums[2]��nums[3] �� nums[4] ���ܱ� 3 ������
 * ��ˣ����� divisors[2] �����Ŀ������Ե÷����
 * ʾ�� 2��
 *
 * ���룺nums = [20,14,21,10], divisors = [5,7,5]
 * �����5
 * ���ͣ�divisors ��ÿ��Ԫ�صĿ������Ե÷�Ϊ��
 * divisors[0] �Ŀ������Ե÷�Ϊ 2 ����Ϊ nums[0] �� nums[3] ���ܱ� 5 ������
 * divisors[1] �Ŀ������Ե÷�Ϊ 2 ����Ϊ nums[1] �� nums[2] ���ܱ� 7 ������
 * divisors[2] �Ŀ������Ե÷�Ϊ 2 ����Ϊ nums[0] �� nums[3] ���ܱ�5������
 * ���� divisors[0]��divisors[1] �� divisors[2] �Ŀ������Ե÷ֶ������ģ���ˣ����Ƿ�����ֵ��С��һ������ divisors[2] ��
 * ʾ�� 3��
 *
 * ���룺nums = [12], divisors = [10,16]
 * �����10
 * ���ͣ�divisors ��ÿ��Ԫ�صĿ������Ե÷�Ϊ��
 * divisors[0] �Ŀ������Ե÷�Ϊ 0 ����Ϊ nums ��û���κ������ܱ� 10 ������
 * divisors[1] �Ŀ������Ե÷�Ϊ 0 ����Ϊ nums ��û���κ������ܱ� 16 ������
 * ���� divisors[0] �� divisors[1] �Ŀ������Ե÷ֶ������ģ���ˣ����Ƿ�����ֵ��С��һ������ divisors[0] ��
 *
 */

class Solution18 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int n = divisors.length;
        int ans = -1, maxCnt = -1;
        for(int d : divisors){
            int cnt = 0;
            for(int x : nums){
                if(x % d == 0) cnt++;
            }
            if(cnt > maxCnt || cnt == maxCnt && d < ans){
                maxCnt = cnt;
                ans = d;
            }
        }
        return ans;
    }
}