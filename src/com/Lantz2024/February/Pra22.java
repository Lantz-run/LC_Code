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
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
class Solution22 {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        int end = lowerBound(nums, target + 1) - 1; // end 是小于等于, 转换成大于 end 左边的那个数再 - 1
        return new int[]{start, end};
    }
    // 闭区间
    private int lowerBound(int[] a, int target){
        int left = 0, right = a.length-1;
        while(left <= right){ // 区间不为空
            int mid = (left + right) >>> 1; // 等价于 int mid = left + (right - left) /2;
            if(a[mid] < target){
                left = mid + 1; // 范围缩小到 (mid, right)
            } else {
                right = mid - 1; // 范围缩小到 (left, mid)
            }
        }
        return left;
    }
}
