package com.Lantz2024.March;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-03-05 15:39:53
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {

}

/**
 * 1976. ����Ŀ�ĵصķ�����
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ������������� n ��·����ɣ�·�ڱ��Ϊ 0 �� n - 1 ��ĳЩ·��֮���� ˫�� ��·�����뱣֤����Դ�����·�ڳ���������������·�ڣ�
 * ����������·��֮�������һ��·��
 *
 * ����һ������ n �Ͷ�ά�������� roads ������ roads[i] = [ui, vi, timei] ��ʾ��·�� ui �� vi ֮����һ����Ҫ���� timei ʱ�����ͨ���ĵ�·��
 * ����֪������ ����ʱ�� ��·�� 0 ��������·�� n - 1 �ķ�������
 *
 * �뷵�ػ��� ����ʱ�� ����Ŀ�ĵص� ·����Ŀ �����ڴ𰸿��ܴܺ󣬽������ 109 + 7 ȡ�� �󷵻ء�
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * �����4
 * ���ͣ���·�� 0 ������·�� 6 ���ѵ�����ʱ���� 7 ���ӡ�
 * �������� 7 ���ӵ�·���ֱ�Ϊ��
 * - 0 ? 6
 * - 0 ? 4 ? 6
 * - 0 ? 1 ? 2 ? 5 ? 6
 * - 0 ? 1 ? 3 ? 5 ? 6
 * ʾ�� 2��
 *
 * ���룺n = 2, roads = [[1,0,10]]
 * �����1
 * ���ͣ�ֻ��һ����·�� 0 ��·�� 1 ��·������ 10 ���ӡ�
 */
class Solution04 {
    public int countPaths(int n, int[][] roads) {
        long[][] g = new long[n][n]; // �ڽӾ���
        for(long[] row : g){
            Arrays.fill(row, Long.MAX_VALUE / 2); // ��ֹ���
        }
        for (int[] r : roads){
            int x = r[0];
            int y = r[1];
            int d = r[2];
            g[x][y] = d;
            g[y][x] = d;
        }

        long[] dis = new long[n];
        Arrays.fill(dis, 1, n, Long.MAX_VALUE / 2);
        int[] f = new int[n];
        f[0] = 1;
        boolean[] done = new boolean[n];
        while(true){
            int x = -1;
            for(int i = 0; i < n; i++){
                if(!done[i] && (x < 0 || dis[i] < dis[x])){
                    x = i;
                }
            }
            if(x == n - 1){
                // �����б� dis[n-1] ���̻���һ���̵����·�ˣ������Ŀ�ı�Ȩ��������
                return f[n-1];
            }
            done[x] = true; // ���·������ȷ��
            for(int y = 0; y < n; y++){ // ���Ը��� x ���ھ����·
                long newDis = dis[x] + g[x][y];
                if(newDis < dis[y]){
                    // ���·���뾭��x
                    dis[y] = newDis;
                    f[y] = f[x];
                } else if(newDis == dis[y]){
                    // ��֮ǰ������·һ����
                    f[y] = (f[y] + f[x]) % 1_000_000_007;
                }
            }
        }
    }
}
