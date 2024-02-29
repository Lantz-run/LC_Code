package com.Lantz2023.November;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode第15题：三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 *
 * 提示：
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

        // 循环条件2要-2的原因是：k指针和j指针已经是分别占了一个元素，而中间由i指针负责遍历枚举
        for (int k = 0; k < len-2; k++) {
            if (nums[k] > 0) break;

            // 如何没有k>0，会出现bug：ArrayIndexOutOfBoundsException: Index -1
            if (k > 0 && nums[k] == nums[k-1]) continue;

            // 定义双指针i,j
            int i = k+1, j = len-1;
            while (i < j){
                 int s = nums[k] + nums[i] + nums[j];
                 if (s < 0){
                     // 这里是++i而不可以是i++的原因：先枚举到下一位判断是否重复，再进行后续操作，而不是一开始就赋值
                     while (i<j && nums[i] == nums[++i]); // 跳过重复元素，以下同理
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
            if (nums[k] > 0) break; // nums[k]大于0，那也就是后面的也大于0，达不到三个数相加等于0

            if (k>0 && nums[k] == nums[k-1]) continue;

            int i = k+1, j = len-1;
            while (i<j){
                int sum = nums[i] + nums[k] + nums[j];
                // 三个条件 sum >0 =0 <0
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
