package com.Lantz2024.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2024-03-02 17:32:02
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 */
public class Pra01 {

}

/**
 * 2368. 受限条件下可到达节点的数目
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 *
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
 * 另给你一个整数数组 restricted 表示 受限 节点。
 *
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 *
 * 注意，节点 0 不 会标记为受限节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 *
 *
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达
 */
class Solution01 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isR = new boolean[n];
        for(int x : restricted){
            isR[x] = true;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>()); // 把受限的节点放进 set 集合中
        for(int[] e : edges){
            int x = e[0], y = e[1];
            if (!isR[x] && !isR[y]){ // 不受限才连边
                g[x].add(y);
                g[y].add(x);
            }
        }
        return dfs(0, -1, g);
    }

    // 由下往上递归
    private int dfs(int x, int fa, List<Integer>[] g){
        int cnt = 1;
        for(int y : g[x]){
            if(y != fa){
                cnt += dfs(y, x, g);
            }
        }
        return cnt;
    }
}
