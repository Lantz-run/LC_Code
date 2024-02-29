package com.Lantz2023.OctoberPra;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023.10.04
 * LeetCode��һ�⣺����֮��
 * ��ϰͬʱ���ƼǱʼ�
 *
 */
public class Pra01 {

    public static void main(String[] args) throws IllegalAccessException {
        Solution solution = new Solution();
        int[] nums = new int[]{2,7,11,15};
        int[] arrays;

        arrays = solution.twoSum(nums, 9);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]+" ");
        }
    }

}



/**
 * / ��ϣӳ�䷨ /
 * ���룺nums = [2,7,11,15], target = 9
 * �����[0,1]
 * ���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1]
 */
class Solution{
    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // containsKey():�жϹ�ϣ�����Ƿ��Ѿ���������������Ӧ�ļ�-ֵ��
            if (hashMap.containsKey(target - nums[i])){ // ����Ƿ���������nums[1]һ������
                return new int[] {hashMap.get(target - nums[i]), i}; // ������ڣ��ʹ���һ�����飬���һ�ȡ��һ��ֵ�͵ڶ���ֵ
            }
            hashMap.put(nums[i], i); // �����±�
        }

        return new int[0]; // ����һ�����飬�����ݴ��
    }
}
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.containsKey(target - nums[i])){
//                return new int[] {hashMap.get(target - nums[i]), i};
//            }
//            hashMap.put(nums[i], i);
//        }
//
//        return new int[0];
//    }
//}