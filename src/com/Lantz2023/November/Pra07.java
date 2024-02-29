package com.Lantz2023.November;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2023-11-29 08:20:08
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 *
 * LeetCode第十六题：最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
 *
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class Pra07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int[] nums = {-1,3,2,-4};
        int target = 1;
        int result = solution07.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
class Solution07 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        // i在此处是固定的，只有在s和e指针重合的时候才往后移动，所以s才是从i+1开始
        for (int i = 0; i < len; i++) {
            int start = i+1, end = len-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end]; // 要放在while里面，否则会因为每次执行for循环都计算一次导致数组溢出
                // 判断sum-target的值大小决定最接近target的数
                if (Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }
                // sum大于target说明排序之后end指针所指的数比较大了，要右移，
                // 从而等指向下一个数是的三数之和可以更接近target; sum小于target的情况也是一样的道理
                if (sum > target){
                    end--;
                } else if (sum < target) {
                    start++;
                }else{
                    return ans;
                }
//                if (start == end) continue;
            }
        }

        return ans;
    }
}
