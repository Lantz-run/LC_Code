package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra27
 * <p>Powered by Lantz On 2024-02-27 16:02:36
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra27
 * @since 1.8
 */
public class Pra27 {

}

/**
 * 2867. ͳ�����еĺϷ�·����Ŀ
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�� n ���ڵ�����������ڵ���Ϊ 1 �� n ������һ������ n ��һ������Ϊ n - 1 �Ķ�ά�������� edges ������ edges[i] = [ui, vi] ��ʾ�ڵ� ui �� vi ��������һ���ߡ�
 *
 * ���㷵�����е� �Ϸ�·����Ŀ ��
 *
 * ����ڽڵ� a ���ڵ� b ֮�� ǡ����һ�� �ڵ�ı������������ô���ǳ�·�� (a, b) �� �Ϸ��� ��
 *
 * ע�⣺
 *
 * ·�� (a, b) ָ����һ���ӽڵ� a ��ʼ���ڵ� b ������һ���ڵ����У������еĽڵ� ������ͬ �������ڽڵ�֮����������һ���ߡ�
 * ·�� (a, b) ��·�� (b, a) ��Ϊ ͬһ�� ·������ֻ����� һ�� ��
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
 * �����4
 * ���ͣ�ǡ����һ��������ŵĽڵ�·���У�
 * - (1, 2) ��Ϊ·�� 1 �� 2 ֻ����һ������ 2 ��
 * - (1, 3) ��Ϊ·�� 1 �� 3 ֻ����һ������ 3 ��
 * - (1, 4) ��Ϊ·�� 1 �� 4 ֻ����һ������ 2 ��
 * - (2, 4) ��Ϊ·�� 2 �� 4 ֻ����һ������ 2 ��
 * ֻ�� 4 ���Ϸ�·����
 * ʾ�� 2��
 *
 *
 *
 * ���룺n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
 * �����6
 * ���ͣ�ǡ����һ��������ŵĽڵ�·���У�
 * - (1, 2) ��Ϊ·�� 1 �� 2 ֻ����һ������ 2 ��
 * - (1, 3) ��Ϊ·�� 1 �� 3 ֻ����һ������ 3 ��
 * - (1, 4) ��Ϊ·�� 1 �� 4 ֻ����һ������ 2 ��
 * - (1, 6) ��Ϊ·�� 1 �� 6 ֻ����һ������ 3 ��
 * - (2, 4) ��Ϊ·�� 2 �� 4 ֻ����һ������ 2 ��
 * - (3, 6) ��Ϊ·�� 3 �� 6 ֻ����һ������ 3 ��
 * ֻ�� 6 ���Ϸ�·����
 */
class Solution27 {
    private final static int MX = (int) 1e5;
    private final static boolean[] np = new boolean[MX + 1]; // ���� = false, ������ = true

    static {
        np[1] = true;
        for(int i = 2; i * i <= MX; i++){
            if(!np[i]){
                for(int j = i * i; j <= MX; j += i){
                    np[j] = true;
                }
            }
        }
    }
    public long countPaths(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for(var e : edges){
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        long ans = 0;
        int[] size = new int[n + 1];
        var nodes = new ArrayList<Integer>();
        for(int x = 1; x <= n; x++){
            if(np[x]) { // ����������
                continue;
            }
            int sum = 0;
            for(int y : g[x]){ // ���� x ��������ֳ������ɸ���ͨ��
                if(!np[y]){
                    continue;
                }
                if(size[y] == 0){ // δ�������
                    nodes.clear();
                    dfs(y, -1, g, nodes); // ���� y ���ڵ���ͨ�飬�ڲ�����������ǰ���£�ͳ���ж��ٸ�������
                    for(int z : nodes){
                        size[z] = nodes.size();
                    }
                }
                // �� size[y] ����������֮ǰ�������� sum ��������������֮���·��ֻ�������� x
                ans += (long) size[y] * sum;
                sum += size[y];
            }
            ans += sum; // �� x ������·��

        }
        return ans;
    }

    private void dfs(int x, int fa, List<Integer>[] g, List<Integer> nodes){
        nodes.add(x);
        for(int y : g[x]){
            if(y != fa && np[y]){
                dfs(y, x, g, nodes);
            }
        }
    }
}
