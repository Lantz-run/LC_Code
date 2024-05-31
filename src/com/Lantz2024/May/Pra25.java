package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra25
 * <p>Powered by Lantz On 2024-05-25 11:20:18
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra25
 * @since 1.8
 */
public class Pra25 {
}

/**
 * 2903. �ҳ������ֵ�������±� I
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ������Ϊ n ���������� nums ���Լ����� indexDifference ������ valueDifference ��
 *
 * ��������Ǵӷ�Χ [0, n - 1] ���ҳ�  2 ���������������������±� i �� j ��
 *
 * abs(i - j) >= indexDifference ��
 * abs(nums[i] - nums[j]) >= valueDifference
 * ������������ answer���������������ĿҪ��������±꣬�� answer = [i, j] ������answer = [-1, -1] ��
 * ������ڶ���ɹ�ѡ����±�ԣ�ֻ��Ҫ������������һ�鼴�ɡ�
 *
 * ע�⣺i �� j ���� ��� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
 * �����[0,3]
 * ���ͣ���ʾ���У�����ѡ�� i = 0 �� j = 3 ��
 * abs(0 - 3) >= 2 �� abs(nums[0] - nums[3]) >= 4 ��
 * ��ˣ�[0,3] ��һ��������ĿҪ��Ĵ𰸡�
 * [3,0] Ҳ�Ƿ�����ĿҪ��Ĵ𰸡�
 * ʾ�� 2��
 *
 * ���룺nums = [2,1], indexDifference = 0, valueDifference = 0
 * �����[0,0]
 * ���ͣ�
 * ��ʾ���У�����ѡ�� i = 0 �� j = 0 ��
 * abs(0 - 0) >= 0 �� abs(nums[0] - nums[0]) >= 0 ��
 * ��ˣ�[0,0] ��һ��������ĿҪ��Ĵ𰸡�
 * [0,1]��[1,0] �� [1,1] Ҳ�Ƿ�����ĿҪ��Ĵ𰸡�
 * ʾ�� 3��
 *
 * ���룺nums = [1,2,3], indexDifference = 2, valueDifference = 4
 * �����[-1,-1]
 * ���ͣ���ʾ���У�����֤���޷��ҳ� 2 �����������������±ꡣ
 * ��ˣ����� [-1,-1] ��
 */

class Solution25 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int a = Math.abs(i - j);
                int b = Math.abs(nums[i] - nums[j]);
                if(a >= indexDifference && b >= valueDifference){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
