package com.Lantz2024.January;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2024-01-05 15:19:51
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 *
 */
public class Pra01 {
    public static void main(String[] args) {

    }
}

/**
 * 78. 子集
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
class Solution01 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        // 选nums[i]
        dfs(i+1);
        // 不选nums[i]
        path.add(nums[i]);
        dfs(i+1);
        path.remove(path.size()-1);

    }
}
