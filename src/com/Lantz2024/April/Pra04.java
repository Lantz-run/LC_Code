package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-04-04 11:52:04
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {

}

/**
 * 2192. �����޻�ͼ��һ���ڵ����������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�������� n ������ʾһ�� �����޻�ͼ �нڵ����Ŀ���ڵ���Ϊ 0 �� n - 1 ���������ߣ���
 *
 * ����һ����ά�������� edges ������ edges[i] = [fromi, toi] ��ʾͼ��һ���� fromi �� toi �ĵ���ߡ�
 *
 * ���㷵��һ������ answer������ answer[i]�ǵ� i ���ڵ������ ���� ����Щ���Ƚڵ� ���� ����
 *
 * ��� u ͨ��һϵ�бߣ��ܹ����� v ����ô���ǳƽڵ� u �ǽڵ� v �� ���� �ڵ㡣
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
 * �����[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
 * ���ͣ�
 * ��ͼΪ��������Ӧ��ͼ��
 * - �ڵ� 0 ��1 �� 2 û���κ����ȡ�
 * - �ڵ� 3 �� 2 ������ 0 �� 1 ��
 * - �ڵ� 4 �� 2 ������ 0 �� 2 ��
 * - �ڵ� 5 �� 3 ������ 0 ��1 �� 3 ��
 * - �ڵ� 6 �� 5 ������ 0 ��1 ��2 ��3 �� 4 ��
 * - �ڵ� 7 �� 4 ������ 0 ��1 ��2 �� 3 ��
 * ʾ�� 2��
 *
 *
 *
 * ���룺n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * �����[[],[0],[0,1],[0,1,2],[0,1,2,3]]
 * ���ͣ�
 * ��ͼΪ��������Ӧ��ͼ��
 * - �ڵ� 0 û���κ����ȡ�
 * - �ڵ� 1 �� 1 ������ 0 ��
 * - �ڵ� 2 �� 2 ������ 0 �� 1 ��
 * - �ڵ� 3 �� 3 ������ 0 ��1 �� 2 ��
 * - �ڵ� 4 �� 4 ������ 0 ��1 ��2 �� 3 ��
 *
 *
 * ��ʾ��
 *
 * 1 <= n <= 1000
 * 0 <= edges.length <= min(2000, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= fromi, toi <= n - 1
 * fromi != toi
 * ͼ�в������رߡ�
 * ͼ�� ���� �� �޻� ��
 */

class Solution04 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] e : edges){
            g[e[1]].add(e[0]); // ����ͼ
        }

        List<Integer>[] ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            Arrays.fill(vis, false);
            dfs(i, g, vis); // �� i ��ʼ dfs
            vis[i] = false; // ans[i] ���� i
            for(int j = 0; j < n; j++){
                if(vis[j]){
                    ans[i].add(j);
                }
            }
        }
        return Arrays.asList(ans);

    }

    private void dfs(int x, List<Integer>[] g, boolean[] vis){
        vis[x] = true; // �����ظ�����
        for(int y : g[x]){
            if(!vis[y]){
                dfs(y, g, vis); // ֻ�ݹ�û�з��ʹ��Ľ��
            }
        }
    }
}


