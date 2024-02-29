package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra21
 * <p>Powered by Lantz On 2024-02-24 16:26:48
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra21
 * @since 1.8
 */
public class Pra21 {

}

/**
 * 2476. 二叉搜索树最近节点查询
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 *
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 *
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 *
 *
 *
 * 示例 1 ：
 *
 *
 *
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * 示例 2 ：
 *
 *
 *
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 */
class Solution21 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);

        int n = res.size();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = res.get(i); // 转成数组，效率更高
        }

        List<List<Integer>> ans = new ArrayList<>(queries.size()); // 预分配空间
        for(int q : queries){
            int j = lowerBound(a, q); // 假设 j 是大于等于 q = queries[i] 的第一个数的下标, 如果不存在则 j = n
            int mx = j == n ? -1 : a[j];
            if(j == n || a[j] != q){
                j--;
            }
            int mn = j < 0 ? -1 : a[j];
            ans.add(List.of(mn, mx));
        }
        return ans;
    }
    private void dfs(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
    // 二分查找
    private int lowerBound(int[] a, int target){
        int left = -1, right = a.length; // 开区间 (left, right)
        while(left + 1 < right){ // 区间不为空
            int mid = (left + right) >>> 1; // 位运算，二进制右移一位
            if(a[mid] >= target){
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}
