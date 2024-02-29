package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra22
 * <p>Powered by Lantz On 2024-02-24 17:02:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra22
 * @since 1.8
 */
public class Pra22 {

}

/**
 * 34. �����������в���Ԫ�صĵ�һ�������һ��λ��
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ�����շǵݼ�˳�����е��������� nums����һ��Ŀ��ֵ target�������ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 *
 * ��������в�����Ŀ��ֵ target������ [-1, -1]��
 *
 * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [5,7,7,8,8,10], target = 8
 * �����[3,4]
 * ʾ�� 2��
 *
 * ���룺nums = [5,7,7,8,8,10], target = 6
 * �����[-1,-1]
 * ʾ�� 3��
 *
 * ���룺nums = [], target = 0
 * �����[-1,-1]
 */
class Solution22 {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        int end = lowerBound(nums, target + 1) - 1; // end ��С�ڵ���, ת���ɴ��� end ��ߵ��Ǹ����� - 1
        return new int[]{start, end};
    }
    // ������
    private int lowerBound(int[] a, int target){
        int left = 0, right = a.length-1;
        while(left <= right){ // ���䲻Ϊ��
            int mid = (left + right) >>> 1; // �ȼ��� int mid = left + (right - left) /2;
            if(a[mid] < target){
                left = mid + 1; // ��Χ��С�� (mid, right)
            } else {
                right = mid - 1; // ��Χ��С�� (left, mid)
            }
        }
        return left;
    }
}
