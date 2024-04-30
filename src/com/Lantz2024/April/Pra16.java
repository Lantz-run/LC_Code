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
 * 924. �������ٶ�������Ĵ���
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ������һ���� n ���ڵ���ɵ����磬�� n �� n ���ڽӾ���ͼ graph ��ʾ���ڽڵ������У��� graph[i][j] = 1 ʱ����ʾ�ڵ� i �ܹ�ֱ�����ӵ���һ���ڵ� j��
 *
 * һЩ�ڵ� initial ��������������Ⱦ��ֻҪ�����ڵ�ֱ�����ӣ�����������һ���ڵ��ܵ���������ĸ�Ⱦ����ô�����ڵ㶼�������������Ⱦ��
 * ���ֶ�������Ĵ�����������ֱ��û�и���Ľڵ���Ա����ַ�ʽ��Ⱦ��
 *
 * ���� M(initial) ���ڶ������ֹͣ����֮�����������и�Ⱦ������������սڵ�����
 *
 * ����� initial ���Ƴ�ĳһ�ڵ��ܹ���С�� M(initial)�� ���ظýڵ㡣����ж���ڵ������������ͷ���������С�Ľڵ㡣
 *
 * ��ע�⣬���ĳ���ڵ��Ѵ��ܸ�Ⱦ�ڵ���б� initial ��ɾ�������Ժ����п������������������ܵ���Ⱦ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * �����0
 * ʾ�� 2��
 *
 * ���룺graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
 * �����0
 * ʾ�� 3��
 *
 * ���룺graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
 * �����1
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
        // ����״̬������ node_id
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
