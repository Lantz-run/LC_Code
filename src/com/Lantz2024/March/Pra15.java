package com.Lantz2024.March;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-03-19 15:48:59
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {

}

/**
 * 1793. 好子数组的最大分数
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 *
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。
 * 一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 *
 * 请你返回 好 子数组的最大可能 分数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,4,3,7,4,5], k = 3
 * 输出：15
 * 解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
 * 示例 2：
 *
 * 输入：nums = [5,5,4,5,4,1,1,1], k = 0
 * 输出：20
 * 解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
 */
class Solution15 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int x = nums[i];
            while(!st.isEmpty() && x <= nums[st.peek()]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int[] right = new int[n];
        st.clear();
        for(int i = n-1; i >= 0; i--){
            int x = nums[i];
            while(!st.isEmpty() && x <= nums[st.peek()]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int h = nums[i];
            int l = left[i];
            int r = right[i];
            if(l < k && k < r){
                ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }
}
