package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra05
 * <p>Powered by Lantz On 2024-03-06 11:37:01
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra05
 * @since 1.8
 */
public class Pra05 {

}

/**
 * 2917. �ҳ������е� K-or ֵ
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ���������� nums ��һ������ k ��
 *
 * nums �е� K-or ��һ���������������ķǸ�������
 *
 * ֻ���� nums �У����ٴ��� k ��Ԫ�صĵ� i λֵΪ 1 ����ô K-or �еĵ� i λ��ֵ���� 1 ��
 * ���� nums �� K-or ֵ��
 *
 * ע�� ���������� x ����� (2i AND x) == 2i ���� x �еĵ� i λֵΪ 1 ������ AND Ϊ��λ���������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [7,12,9,8,9,15], k = 4
 * �����9
 * ���ͣ�nums[0]��nums[2]��nums[4] �� nums[5] �ĵ� 0 λ��ֵΪ 1 ��
 * nums[0] �� nums[5] �ĵ� 1 λ��ֵΪ 1 ��
 * nums[0]��nums[1] �� nums[5] �ĵ� 2 λ��ֵΪ 1 ��
 * nums[1]��nums[2]��nums[3]��nums[4] �� nums[5] �ĵ� 3 λ��ֵΪ 1 ��
 * ֻ�е� 0 λ�͵� 3 λ�������������ٴ��� k ��Ԫ���ڶ�Ӧλ�ϵ�ֵΪ 1 ����ˣ���Ϊ 2^0 + 2^3 = 9 ��
 * ʾ�� 2��
 *
 * ���룺nums = [2,12,1,11,4,5], k = 6
 * �����0
 * ���ͣ���Ϊ k == 6 == nums.length ����������� 6-or ������������Ԫ�ذ�λ������Ľ������ˣ���Ϊ 2 AND 12 AND 1 AND 11 AND 4 AND 5 = 0 ��
 * ʾ�� 3��
 *
 * ���룺nums = [10,8,5,9,11,6,8], k = 1
 * �����15
 * ���ͣ���Ϊ k == 1 ������� 1-or ������������Ԫ�ذ�λ������Ľ������ˣ���Ϊ 10 OR 8 OR 5 OR 9 OR 11 OR 6 OR 8 = 15 ��
 */
class Solution05 {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < 31; i++){
            int cnt1 = 0;
            for(int x : nums){
                cnt1 += x >> i & 1; // ���� (s >> i) & 1=1
            }
            if(cnt1 >= k){
                ans |= 1 << i; // ���Ƶ��� 2^i
            }
        }
        return ans;
    }
}