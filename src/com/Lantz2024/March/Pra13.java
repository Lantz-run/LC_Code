package com.Lantz2024.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-03-17 15:40:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {

}

/**
 * 310. 最小高度树
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 示例 2：
 *
 *
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 *
 *
 * 提示：
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入 保证 是一棵树，并且 不会有重复的边
 */
class Solution13 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // 特殊情况
        if(n == 1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n]; // 出度表
        // 建立图关系，每个节点的list中存储相连节点
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++; // 出度++
            map.get(edge[0]).add(edge[1]); // 添加相邻节点
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) queue.offer(i);
        }

        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neis = map.get(cur);
                for(int nei : neis){
                    degree[nei]--;
                    if(degree[nei] == 1){
                        queue.offer(nei);
                    }
                }
            }
        }
        return res;
    }
}
