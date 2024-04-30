package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra21
 * <p>Powered by Lantz On 2024-04-21 14:57:16
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra21
 * @since 1.8
 */
public class Pra21 {
}

/**
 * 216. 组合总和 III
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 *
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 *
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合
 */
class Solution21 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(9, n);
        return ans;
    }

    private void dfs(int i, int t){
        int d = k - path.size();
        // 剪枝
        if(t < 0 || t > (i * 2 - d + 1) * d / 2)
            return;
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j >= d; j--){
            path.add(j);
            dfs(j - 1, t - j);
            path.remove(path.size() - 1);
        }
    }
}
