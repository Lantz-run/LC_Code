package com.Lantz2024.February;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra29
 * <p>Powered by Lantz On 2024-02-29 09:23:56
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra29
 * @since 1.8
 */
public class Pra29 {

}

/**
 * 2581. ͳ�ƿ��ܵ�������Ŀ
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * Alice ��һ�� n ���ڵ�������ڵ���Ϊ 0 �� n - 1 ������һ������Ϊ n - 1 �Ķ�ά�������� edges ��ʾ������ edges[i] = [ai, bi] ����ʾ���нڵ� ai �� bi ֮����һ���ߡ�
 *
 * Alice ��Ҫ Bob �ҵ�������ĸ��������� Bob ��������������ɴ� �²� ��ÿһ�β²⣬Bob ���������飺
 *
 * ѡ������ ����� ������ u �� v �������б�����ڱ� [u, v] ��
 * Bob �²����� u �� v �� ���ڵ� ��
 * Bob �Ĳ²��ö�ά�������� guesses ��ʾ������ guesses[j] = [uj, vj] ��ʾ Bob �� uj �� vj �ĸ��ڵ㡣
 *
 * Alice �ǳ���������������ش� Bob �Ĳ²⣬ֻ���� Bob ��Щ�²����� ���� �� k ���²�Ľ��Ϊ true ��
 *
 * �����ά�������� edges ��Bob �����в²������ k �����㷵�ؿ��ܳ�Ϊ������ �ڵ���Ŀ �����û�������������򷵻� 0��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
 * �����3
 * ���ͣ�
 * ��Ϊ�ڵ� 0 ����ȷ�Ĳ²�Ϊ [1,3], [0,1], [2,4]
 * ��Ϊ�ڵ� 1 ����ȷ�Ĳ²�Ϊ [1,3], [1,0], [2,4]
 * ��Ϊ�ڵ� 2 ����ȷ�Ĳ²�Ϊ [1,3], [1,0], [2,4]
 * ��Ϊ�ڵ� 3 ����ȷ�Ĳ²�Ϊ [1,0], [2,4]
 * ��Ϊ�ڵ� 4 ����ȷ�Ĳ²�Ϊ [1,3], [1,0]
 * �ڵ� 0 ��1 �� 2 Ϊ��ʱ�����Եõ� 3 ����ȷ�Ĳ²⡣
 * ʾ�� 2��
 *
 *
 *
 * ���룺edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
 * �����5
 * ���ͣ�
 * ��Ϊ�ڵ� 0 ����ȷ�Ĳ²�Ϊ [3,4]
 * ��Ϊ�ڵ� 1 ����ȷ�Ĳ²�Ϊ [1,0], [3,4]
 * ��Ϊ�ڵ� 2 ����ȷ�Ĳ²�Ϊ [1,0], [2,1], [3,4]
 * ��Ϊ�ڵ� 3 ����ȷ�Ĳ²�Ϊ [1,0], [2,1], [3,2], [3,4]
 * ��Ϊ�ڵ� 4 ����ȷ�Ĳ²�Ϊ [1,0], [2,1], [3,2]
 * �κνڵ�Ϊ������������ 1 ����ȷ�Ĳ²⡣
 *
 *
 * ��ʾ��
 *
 * edges.length == n - 1
 * 2 <= n <= 105
 * 1 <= guesses.length <= 105
 * 0 <= ai, bi, uj, vj <= n - 1
 * ai != bi
 * uj != vj
 * edges ��ʾһ����Ч������
 * guesses[j] �����е�һ���ߡ�
 * guesses ��Ψһ�ġ�
 * 0 <= k <= guesses.length
 */
class Solution29 {
    private List<Integer>[] g;
    private Set<Long> s = new HashSet<>();
    private int k, ans, cnt0;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] e : edges){
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x); // ��ͼ
        }
        // guesses ת��Ϊ��ϣ��
        for(int[] e : guesses){
            s.add((long) e[0] << 32 | e[1]); // ���� 4 �ֽ� int ѹ����һ�� 8 �ֽڵ�
        }

        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }
    // �ݹ�
    private void dfs(int x, int fa){
        for(int y : g[x]){
            if(y != fa){
                if(s.contains((long) x << 32 | y)){ // ��0��λ��Ϊ�������¶���
                    cnt0++;
                }
                dfs(y, x);
            }
        }
    }

    private void reroot(int x, int fa, int cnt){
        if(cnt >= k){ // ��ʱ cnt ���� x Ϊ��ʱ�¶ԵĴ���
            ans++;
        }
        for(int y : g[x]){
            if(y != fa){
                int c = cnt;
                if(s.contains((long) x << 32 | y)) c--; // ԭ���Եģ����ڴ���
                if(s.contains((long) y << 32 | x)) c++; // ԭ����ģ����ڶ���
                reroot(y, x, c);
            }
        }
    }
}