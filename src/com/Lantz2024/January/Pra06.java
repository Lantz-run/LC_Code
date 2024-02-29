package com.Lantz2024.January;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra06
 * <p>Powered by Lantz On 2024-01-25 13:49:25
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra06
 * @since 1.8
 */
public class Pra06 {
    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        List<Integer> nums = Arrays.asList(5,10,1,5,2);
        int k = 1;
        int result = solution06.sumIndicesWithKSetBits(nums, k);
        System.out.println(result);
    }
}

/**
 * ����һ���±�� 0 ��ʼ���������� nums ��һ������ k ��
 *
 * ������������ʽ���� nums �е��ض�Ԫ��֮ �� ����Щ�ض�Ԫ�����㣺���Ӧ�±�Ķ����Ʊ�ʾ��ǡ���� k ����λ��
 *
 * �����Ķ����Ʊ�ʾ�е� 1 ������������� ��λ ��
 *
 * ���磬21 �Ķ����Ʊ�ʾΪ 10101 �������� 3 ����λ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [5,10,1,5,2], k = 1
 * �����13
 * ���ͣ��±�Ķ����Ʊ�ʾ�ǣ�
 * 0 = 0002
 * 1 = 0012
 * 2 = 0102
 * 3 = 0112
 * 4 = 1002
 * �±� 1��2 �� 4 ��������Ʊ�ʾ�ж����� k = 1 ����λ��
 * ��ˣ���Ϊ nums[1] + nums[2] + nums[4] = 13 ��
 * ʾ�� 2��
 *
 * ���룺nums = [4,3,2,1], k = 2
 * �����1
 * ���ͣ��±�Ķ����Ʊ�ʾ�ǣ�
 * 0 = 002
 * 1 = 012
 * 2 = 102
 * 3 = 112
 * ֻ���±� 3 �Ķ����Ʊ�ʾ�д��� k = 2 ����λ��
 * ��ˣ���Ϊ nums[3] = 1 ��
 */
class Solution06 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;
        for(int i = 0; i < n; i++){
            if(Integer.bitCount(i) == k){
                ans += nums.get(i);
            }
        }
        return ans;
    }
}