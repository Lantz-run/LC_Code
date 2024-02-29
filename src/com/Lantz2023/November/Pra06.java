package com.Lantz2023.November;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode��15�⣺����֮��
 *
 * ����һ���������� nums ���ж��Ƿ������Ԫ�� [nums[i], nums[j], nums[k]]
 * ���� i != j��i != k �� j != k ��ͬʱ������ nums[i] + nums[j] + nums[k] == 0 ��
 * ���㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 *
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 *
 * ʾ�� 1��
 *
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ���ͣ�
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 ��
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 ��
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 ��
 * ��ͬ����Ԫ���� [-1,0,1] �� [-1,-1,2] ��
 * ע�⣬�����˳�����Ԫ���˳�򲢲���Ҫ��
 *
 * ʾ�� 2��
 *
 * ���룺nums = [0,1,1]
 * �����[]
 * ���ͣ�Ψһ���ܵ���Ԫ��Ͳ�Ϊ 0 ��
 *
 * ʾ�� 3��
 *
 * ���룺nums = [0,0,0]
 * �����[[0,0,0]]
 * ���ͣ�Ψһ���ܵ���Ԫ���Ϊ 0 ��
 *
 *
 * ��ʾ��
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Pra06 {
    public static void main(String[] args) {
        Solution06_1 solution06 = new Solution06_1();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution06.threeSum(nums);
        for (List<Integer> r : result
             ) {
            System.out.println(r);
        }
    }
}

class Solution06 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // ѭ������2Ҫ-2��ԭ���ǣ�kָ���jָ���Ѿ��Ƿֱ�ռ��һ��Ԫ�أ����м���iָ�븺�����ö��
        for (int k = 0; k < len-2; k++) {
            if (nums[k] > 0) break;

            // ���û��k>0�������bug��ArrayIndexOutOfBoundsException: Index -1
            if (k > 0 && nums[k] == nums[k-1]) continue;

            // ����˫ָ��i,j
            int i = k+1, j = len-1;
            while (i < j){
                 int s = nums[k] + nums[i] + nums[j];
                 if (s < 0){
                     // ������++i����������i++��ԭ����ö�ٵ���һλ�ж��Ƿ��ظ����ٽ��к���������������һ��ʼ�͸�ֵ
                     while (i<j && nums[i] == nums[++i]); // �����ظ�Ԫ�أ�����ͬ��
                 }else if (s > 0) {
                     while (i<j && nums[j] == nums[--j]);
                 }else {
                     res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                     while (i<j && nums[i] == nums[++i]);
                     while (i<j && nums[j] == nums[--j]);
                 }
            }
        }
        return res;
    }
}

class Solution06_1{
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < len-2; k++) {
            if (nums[k] > 0) break; // nums[k]����0����Ҳ���Ǻ����Ҳ����0���ﲻ����������ӵ���0

            if (k>0 && nums[k] == nums[k-1]) continue;

            int i = k+1, j = len-1;
            while (i<j){
                int sum = nums[i] + nums[k] + nums[j];
                // �������� sum >0 =0 <0
                if (sum<0){
                    while (i<j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i<j && nums[j] == nums[--j]);

                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i<j && nums[i] == nums[++i]);
                    while (i<j && nums[j] == nums[--j]);

                }
            }
        }

        return res;
    }
}
