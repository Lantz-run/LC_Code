package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra16
 * <p>Powered by Lantz On 2024-04-16 15:23:11
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra16
 * @since 1.8
 */
public class Pra16 {

}

/**
 * 924. 尽量减少恶意软件的传播
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 给出了一个由 n 个节点组成的网络，用 n × n 个邻接矩阵图 graph 表示。在节点网络中，当 graph[i][j] = 1 时，表示节点 i 能够直接连接到另一个节点 j。
 *
 * 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。
 * 这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
 *
 * 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
 *
 * 如果从 initial 中移除某一节点能够最小化 M(initial)， 返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
 *
 * 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后仍有可能因恶意软件传播而受到感染。
 *
 *
 *
 * 示例 1：
 *
 * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * 输出：0
 * 示例 2：
 *
 * 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
 * 输出：1
 */

class Solution16 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int mn = Integer.MAX_VALUE;
        for(int x : initial){
            isInitial[x] = true;
            mn = Math.min(mn, x);
        }

        int ans = -1;
        int max_size = 0;
        for(int x : initial){
            if(vis[x]){
                continue;
            }
            node_id = -1;
            size = 0;
            dfs(x, graph, vis, isInitial);
            if(node_id >= 0 && (size > max_size || size == max_size && node_id < ans)){
                ans = node_id;
                max_size = size;
            }
        }
        return ans < 0 ? mn : ans;
    }

    private int node_id, size;

    private void dfs(int x, int[][] graph, boolean[] vis, boolean[] isInitial){
        vis[x] = true;
        size++;
        // 按照状态机更新 node_id
        if(node_id != -2 && isInitial[x]){
            node_id = node_id == -1 ? x : -2;
        }
        for(int y = 0; y < graph[x].length; y++){
            if(graph[x][y] == 1 && !vis[y]){
                dfs(y, graph, vis, isInitial);
            }
        }
    }
}
