package com.Lantz2024.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-03-17 15:40:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {

}

/**
 * 310. ��С�߶���
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ������ͼ�������κ���������ֻͨ��һ��·�����ӡ� ���仰˵��һ���κ�û�м򵥻�·����ͨͼ����һ������
 *
 * ����һ�ð��� n ���ڵ���������Ϊ 0 �� n - 1 ���������� n ��һ���� n - 1 ������ߵ� edges �б�ÿһ���߶���һ�Ա�ǩ����
 * ���� edges[i] = [ai, bi] ��ʾ���нڵ� ai �� bi ֮�����һ������ߡ�
 *
 * ��ѡ�������κ�һ���ڵ���Ϊ������ѡ��ڵ� x ��Ϊ���ڵ�ʱ���������ĸ߶�Ϊ h �������п��ܵ����У�������С�߶ȵ���������min(h)������Ϊ ��С�߶��� ��
 *
 * �����ҵ����е� ��С�߶��� ���� ����˳�� �������ǵĸ��ڵ��ǩ�б�
 *
 * ���� �߶� ��ָ���ڵ��Ҷ�ӽڵ�֮�������·���ϱߵ�������
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺n = 4, edges = [[1,0],[1,2],[1,3]]
 * �����[1]
 * ���ͣ���ͼ��ʾ�������Ǳ�ǩΪ 1 �Ľڵ�ʱ�����ĸ߶��� 1 ������Ψһ����С�߶�����
 * ʾ�� 2��
 *
 *
 * ���룺n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * �����[3,4]
 *
 *
 * ��ʾ��
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * ���� (ai, bi) ������ͬ
 * ���������� ��֤ ��һ���������� �������ظ��ı�
 */
class Solution13 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // �������
        if(n == 1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n]; // ���ȱ�
        // ����ͼ��ϵ��ÿ���ڵ��list�д洢�����ڵ�
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++; // ����++
            map.get(edge[0]).add(edge[1]); // ������ڽڵ�
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) queue.offer(i);
        }

        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neis = map.get(cur);
                for(int nei : neis){
                    degree[nei]--;
                    if(degree[nei] == 1){
                        queue.offer(nei);
                    }
                }
            }
        }
        return res;
    }
}
