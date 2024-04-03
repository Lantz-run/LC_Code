package com.Lantz2024.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>Project: Algorithm20230913 - Pra20
 * <p>Powered by Lantz On 2024-03-26 14:55:33
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra20
 * @since 1.8
 */
public class Pra20 {

}

/**
 * 2642. 设计可以求最短路径的图类
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，
 * 其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。
 *
 * 请你实现一个 Graph 类：
 *
 * Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
 * addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
 * int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。
 * 一条路径的代价是路径中所有边代价之和。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：
 * ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
 * [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
 * 输出：
 * [null, 6, -1, null, 6]
 *
 * 解释：
 * Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
 * g.shortestPath(3, 2); // 返回 6 。从 3 到 2 的最短路径如第一幅图所示：3 -> 0 -> 1 -> 2 ，总代价为 3 + 2 + 1 = 6 。
 * g.shortestPath(0, 3); // 返回 -1 。没有从 0 到 3 的路径。
 * g.addEdge([1, 3, 4]); // 添加一条节点 1 到节点 3 的边，得到第二幅图。
 * g.shortestPath(0, 3); // 返回 6 。从 0 到 3 的最短路径为 0 -> 1 -> 3 ，总代价为 2 + 4 = 6 。
 */
class Graph {
    private final List<int[]>[] g; // 邻接表

    public Graph(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            addEdge(e);
        }
    }

    public void addEdge(int[] e) {
        g[e[0]].add(new int[] { e[1], e[2] });
    }

    public int shortestPath(int start, int end) {
        int[] dis = new int[g.length]; // dis[i] 表示从起点 start 出发，到节点 i 的最短长度
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[] { 0, start });
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int d = p[0];
            int x = p[1];
            if (x == end) { // 计算出从起点到终点的最短路长度
                return d;
            }
            if (d > dis[x]) { // x 之前出堆过，无需更新邻居的最短路
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int w = e[1];
                if (d + w < dis[y]) {
                    dis[y] = d + w; // 更新最短路长度
                    pq.offer(new int[] { dis[y], y });
                }
            }
        }
        return -1; // 无法到达终点
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
