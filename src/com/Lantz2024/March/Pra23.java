package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra23
 * <p>Powered by Lantz On 2024-03-29 19:05:22
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra23
 * @since 1.8
 */
public class Pra23 {

}

/**
 * 2908. Ԫ�غ���С��ɽ����Ԫ�� I
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ���������� nums ��
 *
 * ����±���Ԫ�� (i, j, k) ��������ȫ������������Ϊ����һ�� ɽ����Ԫ�� ��
 *
 * i < j < k
 * nums[i] < nums[j] �� nums[k] < nums[j]
 * �����ҳ� nums �� Ԫ�غ���С ��ɽ����Ԫ�飬�������� Ԫ�غ� �����������������������Ԫ�飬���� -1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [8,6,1,5,3]
 * �����9
 * ���ͣ���Ԫ�� (2, 3, 4) ��һ��Ԫ�غ͵��� 9 ��ɽ����Ԫ�飬��Ϊ��
 * - 2 < 3 < 4
 * - nums[2] < nums[3] �� nums[4] < nums[3]
 * �����Ԫ���Ԫ�غ͵��� nums[2] + nums[3] + nums[4] = 9 ������֤��������Ԫ�غ�С�� 9 ��ɽ����Ԫ�顣
 * ʾ�� 2��
 *
 * ���룺nums = [5,4,8,7,10,2]
 * �����13
 * ���ͣ���Ԫ�� (1, 3, 5) ��һ��Ԫ�غ͵��� 13 ��ɽ����Ԫ�飬��Ϊ��
 * - 1 < 3 < 5
 * - nums[1] < nums[3] �� nums[5] < nums[3]
 * �����Ԫ���Ԫ�غ͵��� nums[1] + nums[3] + nums[5] = 13 ������֤��������Ԫ�غ�С�� 13 ��ɽ����Ԫ�顣
 * ʾ�� 3��
 *
 * ���룺nums = [6,5,4,3,4,5]
 * �����-1
 * ���ͣ�����֤�� nums �в�����ɽ����Ԫ�顣
 */

class Solution23 {
    public int minimumSum(int[] nums) {
        // ǰ��׺�ֽ�
        // ö�� nums[j]��������Ҫ��� j �������Ԫ�ص���Сֵ���ұ�����Ԫ�ص���Сֵ��
        int n = nums.length;
        int[] suf = new int[n];
        suf[n-1] = nums[n-1]; // ��׺��Сֵ
        for(int i = n - 2; i > 1; i--){
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }
        int ans = Integer.MAX_VALUE;
        int pre = nums[0]; // ǰ׺��Сֵ
        for(int j = 1; j < n-1; j++){
            if(pre < nums[j] && suf[j+1] < nums[j]){
                ans = Math.min(ans, pre + suf[j+1] + nums[j]); // ���´�
            }
            pre = Math.min(pre, nums[j]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
