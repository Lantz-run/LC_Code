package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra17
 * <p>Powered by Lantz On 2024-04-17 11:44:17
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra17
 * @since 1.8
 */
public class Pra17 {

}

/**
 * 928. �������ٶ�������Ĵ��� II
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ����һ���� n ���ڵ���ɵ����磬�� n x n ���ڽӾ��� graph ��ʾ���ڽڵ������У�ֻ�е� graph[i][j] = 1 ʱ���ڵ� i �ܹ�ֱ�����ӵ���һ���ڵ� j��
 *
 * һЩ�ڵ� initial ��������������Ⱦ��ֻҪ�����ڵ�ֱ�����ӣ�����������һ���ڵ��ܵ���������ĸ�Ⱦ����ô�����ڵ㶼�������������Ⱦ��
 * ���ֶ�������Ĵ�����������ֱ��û�и���Ľڵ���Ա����ַ�ʽ��Ⱦ��
 *
 * ���� M(initial) ���ڶ������ֹͣ����֮�����������и�Ⱦ������������սڵ�����
 *
 * ���ǿ��Դ� initial ��ɾ��һ���ڵ㣬����ȫ�Ƴ��ýڵ��Լ��Ӹýڵ㵽�κ������ڵ���κ����ӡ�
 *
 * �뷵���Ƴ����ܹ�ʹ M(initial) ��С���Ľڵ㡣����ж���ڵ������������������� ��С�Ľڵ� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * �����0
 * ʾ�� 2��
 *
 * ���룺graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
 * �����1
 * ʾ�� 3��
 *
 * ���룺graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
 * �����1
 *
 *
 * ��ʾ��
 *
 * n == graph.length
 * n == graph[i].length
 * 2 <= n <= 300
 * graph[i][j] �� 0 �� 1.
 * graph[i][j] == graph[j][i]
 * graph[i][i] == 1
 * 1 <= initial.length < n
 * 0 <= initial[i] <= n - 1
 *  initial ��ÿ����������ͬ
 */

class Solution17 {
    private int nodeId, size;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int mn = Integer.MAX_VALUE;
        for (int x : initial) {
            isInitial[x] = true;
            mn = Math.min(mn, x);
        }

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || isInitial[i]) {
                continue;
            }
            nodeId = -1;
            size = 0;
            dfs(i, graph, vis, isInitial);
            if (nodeId >= 0) { // ֻ�ҵ�һ���� initial �еĽڵ�
                // ɾ���ڵ� nodeId ������ size ���㲻����Ⱦ
                cnt[nodeId] += size;
            }
        }

        int maxCnt = 0;
        int minNodeId = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] >= 0 && (cnt[i] > maxCnt || cnt[i] == maxCnt && i < minNodeId)) {
                maxCnt = cnt[i];
                minNodeId = i;
            }
        }
        return minNodeId < 0 ? mn : minNodeId;
    }

    private void dfs(int x, int[][] graph, boolean[] vis, boolean[] isInitial) {
        vis[x] = true;
        size++;
        for (int y = 0; y < graph.length; y++) {
            if (graph[x][y] == 0) {
                continue;
            }
            if (isInitial[y]) {
                // ����״̬������ nodeId
                if (nodeId != -2 && nodeId != y) {
                    nodeId = nodeId == -1 ? y : -2;
                }
            } else if (!vis[y]) {
                dfs(y, graph, vis, isInitial);
            }
        }
    }
}