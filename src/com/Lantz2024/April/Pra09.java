package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra09
 * <p>Powered by Lantz On 2024-04-09 14:55:33
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra09
 * @since 1.8
 */
public class Pra09 {

}

/**
 * 2529. 正整数和负整数的最大计数
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 *
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 *
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 *
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 */

class Solution09 {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        int n = nums.length;
        // int max = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) neg++;
            if(nums[i] > 0) pos++;
        }
        return Math.max(pos, neg);
    }
}
