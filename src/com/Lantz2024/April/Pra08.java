package com.Lantz2024.April;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra08
 * <p>Powered by Lantz On 2024-04-08 15:17:44
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra08
 * @since 1.8
 */
public class Pra08 {
    public static void main(String[] args) {
        Solution08_1 solution08_1 = new Solution08_1();
        int[] nums = {1,1,2};
        int re = solution08_1.removeDuplicates(nums);
        System.out.println(re);
    }

}

/**
 * 2009. 使数组连续的最少操作数
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
 *
 * 如果 nums 满足以下条件，那么它是 连续的 ：
 *
 * nums 中所有元素都是 互不相同 的。
 * nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
 * 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
 *
 * 请你返回使 nums 连续 的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,5,3]
 * 输出：0
 * 解释：nums 已经是连续的了。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5,6]
 * 输出：1
 * 解释：一个可能的解是将最后一个元素变为 4 。
 * 结果数组为 [1,2,3,5,4] ，是连续数组。
 * 示例 3：
 *
 * 输入：nums = [1,10,100,1000]
 * 输出：3
 * 解释：一个可能的解是：
 * - 将第二个元素变为 2 。
 * - 将第三个元素变为 3 。
 * - 将第四个元素变为 4 。
 * 结果数组为 [1,2,3,4] ，是连续数组。
 */

class Solution08 {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1; // 记录新的无重复元素的数组
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                nums[m++] = nums[i]; // 原地去重
            }
        }

        int ans = 0;
        int left = 0; // 最左边界
        for(int i = 0; i < m; i++){
            while (nums[left] < nums[i] - n + 1){ // nums[left] 不在窗口内
                left++;
            }
            ans = Math.max(ans, i - left + 1); // 最多保留不变的元素个数
        }
        return n - ans;
    }
}

class Solution08_1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int m = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                nums[m++] = nums[i];
            }
        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println(nums[i] );
//        }
        return m;
    }
}