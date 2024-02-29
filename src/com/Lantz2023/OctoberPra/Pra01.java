package com.Lantz2023.OctoberPra;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023.10.04
 * LeetCode第一题：两数之和
 * 复习同时看云记笔记
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
 * / 哈希映射法 /
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 */
class Solution{
    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // containsKey():判断哈希表中是否已经存在与给定键相对应的键-值对
            if (hashMap.containsKey(target - nums[i])){ // 检查是否存在意义和nums[1]一样的数
                return new int[] {hashMap.get(target - nums[i]), i}; // 如果存在，就创建一个数组，并且获取第一个值和第二个值
            }
            hashMap.put(nums[i], i); // 返回下标
        }

        return new int[0]; // 创建一个数组，将数据存进
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