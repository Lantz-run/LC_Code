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
 * 2642. ��ƿ��������·����ͼ��
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���� n ���ڵ�� �����Ȩ ͼ���ڵ���Ϊ 0 �� n - 1 ��ͼ�еĳ�ʼ�������� edges ��ʾ��
 * ���� edges[i] = [fromi, toi, edgeCosti] ��ʾ�� fromi �� toi ��һ������Ϊ edgeCosti �ıߡ�
 *
 * ����ʵ��һ�� Graph �ࣺ
 *
 * Graph(int n, int[][] edges) ��ʼ��ͼ�� n ���ڵ㣬�������ʼ�ߡ�
 * addEdge(int[] edge) ��߼������һ���ߣ����� edge = [from, to, edgeCost] �����ݱ�֤���������֮ǰ��Ӧ�������ڵ�֮��û������ߡ�
 * int shortestPath(int node1, int node2) ���شӽڵ� node1 �� node2 ��·�� ��С ���ۡ����·�������ڣ����� -1 ��
 * һ��·���Ĵ�����·�������бߴ���֮�͡�
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺
 * ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
 * [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
 * �����
 * [null, 6, -1, null, 6]
 *
 * ���ͣ�
 * Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
 * g.shortestPath(3, 2); // ���� 6 ���� 3 �� 2 �����·�����һ��ͼ��ʾ��3 -> 0 -> 1 -> 2 ���ܴ���Ϊ 3 + 2 + 1 = 6 ��
 * g.shortestPath(0, 3); // ���� -1 ��û�д� 0 �� 3 ��·����
 * g.addEdge([1, 3, 4]); // ���һ���ڵ� 1 ���ڵ� 3 �ıߣ��õ��ڶ���ͼ��
 * g.shortestPath(0, 3); // ���� 6 ���� 0 �� 3 �����·��Ϊ 0 -> 1 -> 3 ���ܴ���Ϊ 2 + 4 = 6 ��
 */
class Graph {
    private final List<int[]>[] g; // �ڽӱ�

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
        int[] dis = new int[g.length]; // dis[i] ��ʾ����� start ���������ڵ� i ����̳���
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[] { 0, start });
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int d = p[0];
            int x = p[1];
            if (x == end) { // ���������㵽�յ�����·����
                return d;
            }
            if (d > dis[x]) { // x ֮ǰ���ѹ�����������ھӵ����·
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int w = e[1];
                if (d + w < dis[y]) {
                    dis[y] = d + w; // �������·����
                    pq.offer(new int[] { dis[y], y });
                }
            }
        }
        return -1; // �޷������յ�
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
