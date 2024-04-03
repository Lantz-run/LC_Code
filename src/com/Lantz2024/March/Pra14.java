package com.Lantz2024.March;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <p>Project: Algorithm20230913 - Pra14
 * <p>Powered by Lantz On 2024-03-18 10:09:31
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra14
 * @since 1.8
 */
public class Pra14 {

}

/**
 * 303. ����ͼ��� - ���鲻�ɱ�
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ����������  nums�������������͵Ķ����ѯ:
 *
 * �������� left �� right ������ left �� right��֮��� nums Ԫ�ص� �� ������ left <= right
 * ʵ�� NumArray �ࣺ
 *
 * NumArray(int[] nums) ʹ������ nums ��ʼ������
 * int sumRange(int i, int j) �������� nums ������ left �� right ֮���Ԫ�ص� �ܺ� ������ left �� right ���㣨Ҳ���� nums[left] + nums[left + 1] + ... + nums[right] )
 *
 *
 * ʾ�� 1��
 *
 * ���룺
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * �����
 * [null, 1, -1, -3]
 *
 * ���ͣ�
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * ������ 104 �� sumRange ����
 */
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i - 1];  // ǰ׺��
        }
    }

    public int sumRange(int left, int right) {
        left++;
        right++;
        return sum[right] - sum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */