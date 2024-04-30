package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra11
 * <p>Powered by Lantz On 2024-04-11 08:47:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra11
 * @since 1.8
 */
public class Pra11 {

}

/**
 * 1766. ������
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�� n ���ڵ������Ҳ����һ���޻���ͨ����ͼ�����ڵ��Ŵ� 0 �� n - 1 ����ǡ���� n - 1 ���ߣ�ÿ���ڵ���һ��ֵ������ ���ڵ� Ϊ 0 �ŵ㡣
 *
 * ����һ���������� nums ��һ����ά���� edges ����ʾ�������nums[i] ��ʾ�� i �����ֵ��edges[j] = [uj, vj] ��ʾ�ڵ� uj �ͽڵ� vj ��������һ���ߡ�
 *
 * �� gcd(x, y) == 1 �����ǳ������� x �� y �� ���ʵ� ������ gcd(x, y) �� x �� y �� ���Լ�� ��
 *
 * �ӽڵ� i �� �� ���·���ϵĵ㶼�ǽڵ� i �����Ƚڵ㡣һ���ڵ� ���� ���Լ������Ƚڵ㡣
 *
 * ���㷵��һ����СΪ n ������ ans ������ ans[i]����ڵ� i ��������Ƚڵ������� nums[i] �� nums[ans[i]] �� ���ʵ� ��
 * ������������������Ƚڵ㣬ans[i] Ϊ -1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
 * �����[-1,0,0,1]
 * ���ͣ���ͼ�У�ÿ���ڵ��ֵ�������б�ʾ��
 * - �ڵ� 0 û�л������ȡ�
 * - �ڵ� 1 ֻ��һ�����Ƚڵ� 0 �����ǵ�ֵ�ǻ��ʵģ�gcd(2,3) == 1����
 * - �ڵ� 2 ���������Ƚڵ㣬�ֱ��ǽڵ� 1 �ͽڵ� 0 ���ڵ� 1 ��ֵ������ֵ���ǻ��ʵģ�gcd(3,3) == 3�����ڵ� 0 ��ֵ�ǻ��ʵ�(gcd(2,3) == 1)��
 *   ���Խڵ� 0 ������ķ���Ҫ������Ƚڵ㡣
 * - �ڵ� 3 ���������Ƚڵ㣬�ֱ��ǽڵ� 1 �ͽڵ� 0 ������ڵ� 1 ���ʣ�gcd(3,2) == 1�������Խڵ� 1 ����������ķ���Ҫ������Ƚڵ㡣
 * ʾ�� 2��
 *
 *
 *
 * ���룺nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * �����[-1,0,-1,0,0,0,-1]
 *
 *
 * ��ʾ��
 *
 * nums.length == n
 * 1 <= nums[i] <= 50
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[j].length == 2
 * 0 <= uj, vj < n
 * uj != vj
 */

class Solution11 {
    private static final int MX = 51;
    private static final int[][] coprime = new int[MX][MX];

    // Ԥ��������
    static {
        // coprime[i] ���� [1, MX] ���� i ���ʵ�����Ԫ��
        // ��Լ��ֻ��1������������������
        for(int i = 1; i < MX; i++){
            int k = 0;
            for(int j = 1; j < MX; j++){
                if(gcd(i, j) == 1)
                    coprime[i][k++] = j;
            }
        }
    }
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] e : edges){
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] valDepth = new int[MX];
        int[] valNodeId = new int[MX];
        dfs(0, -1, 1, g, nums, ans, valDepth, valNodeId);
        return ans;
    }

    private void dfs(int x, int fa, int depth, List<Integer>[] g, int[] nums, int[] ans, int[] valDepth, int[] valNodeId){
        // x �Ľڵ�ֵ
        int val = nums[x];

        // ������ val ���ʵ����Ƚڵ�ֵ�У��ڵ�������Ľڵ���
        int maxDepth = 0;
        for(int j : coprime[val]){
            if(j == 0)
                break;
            if(valDepth[j] > maxDepth){
                maxDepth = valDepth[j];
                ans[x] = valNodeId[j];
            }
        }
        // tmpDepth �� tmpNodeIs ���ڻָ��ֳ�
        int tmpDepth = valDepth[val];
        int tmpNodeIs = valNodeId[val];

        // ���� val ��Ӧ�Ľڵ���Ⱥͽڵ���
        valDepth[val] = depth;
        valNodeId[val] = x;

        // ���µݹ�
        for(int y : g[x]){
            if(y != fa){
                dfs(y, x, depth + 1, g, nums, ans, valDepth, valNodeId);
            }
        }

        // �ָ��ֳ�
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeIs;
    }

    // շת����������Լ��
    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}