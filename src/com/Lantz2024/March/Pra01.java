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
 * 2368. ���������¿ɵ���ڵ����Ŀ
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���� n ���ڵ���ɵ����������ڵ��Ŵ� 0 �� n - 1 ������ n - 1 ���ߡ�
 *
 * ����һ����ά�������� edges ������Ϊ n - 1 ������ edges[i] = [ai, bi] ��ʾ���нڵ� ai �� bi ֮�����һ���ߡ�
 * �����һ���������� restricted ��ʾ ���� �ڵ㡣
 *
 * �ڲ��������޽ڵ��ǰ���£���������Դӽڵ� 0 ����� ��� �ڵ���Ŀ��
 *
 * ע�⣬�ڵ� 0 �� ����Ϊ���޽ڵ㡣
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * �����4
 * ���ͣ���ͼ��ʾ�����������
 * �ڲ��������޽ڵ��ǰ���£�ֻ�нڵ� [0,1,2,3] ���Դӽڵ� 0 ���
 * ʾ�� 2��
 *
 *
 * ���룺n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * �����3
 * ���ͣ���ͼ��ʾ�����������
 * �ڲ��������޽ڵ��ǰ���£�ֻ�нڵ� [0,5,6] ���Դӽڵ� 0 ����
 */
class Solution01 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isR = new boolean[n];
        for(int x : restricted){
            isR[x] = true;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>()); // �����޵Ľڵ�Ž� set ������
        for(int[] e : edges){
            int x = e[0], y = e[1];
            if (!isR[x] && !isR[y]){ // �����޲�����
                g[x].add(y);
                g[y].add(x);
            }
        }
        return dfs(0, -1, g);
    }

    // �������ϵݹ�
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
