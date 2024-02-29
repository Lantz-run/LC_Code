package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Project: Algorithm20230913 - Pra10
 * <p>Powered by Lantz On 2024-02-13 21:04:30
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra10
 * @since 1.8
 */
public class Pra10 {

}

/**
 * 987. �������Ĵ������
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ����������ĸ���� root ����������㷨����������� ������� ���С�
 *
 * ��λ�� (row, col) ��ÿ�������ԣ��������ӽ��ֱ�λ�� (row + 1, col - 1) �� (row + 1, col + 1) �����ĸ����λ�� (0, 0) ��
 *
 * �������� ������� ������ߵ��п�ʼֱ�����ұߵ��н�������������ÿһ���ϵ����н�㣬�γ�һ��������λ�ô��ϵ�������������б�
 * ���ͬ��ͬ�����ж����㣬�򰴽���ֵ��С�����������
 *
 * ���ض������� ������� ���С�
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,9,20,null,null,15,7]
 * �����[[9],[3,15],[20],[7]]
 * ���ͣ�
 * �� -1 ��ֻ�н�� 9 �ڴ����С�
 * ��  0 ��ֻ�н�� 3 �� 15 �ڴ����У������ϵ���˳��
 * ��  1 ��ֻ�н�� 20 �ڴ����С�
 * ��  2 ��ֻ�н�� 7 �ڴ����С�
 * ʾ�� 2��
 *
 *
 * ���룺root = [1,2,3,4,5,6,7]
 * �����[[4],[2],[1,5,6],[3],[7]]
 * ���ͣ�
 * �� -2 ��ֻ�н�� 4 �ڴ����С�
 * �� -1 ��ֻ�н�� 2 �ڴ����С�
 * ��  0 ����� 1 ��5 �� 6 ���ڴ����С�
 *           1 �����棬������������ǰ�档
 *           5 �� 6 λ�ö��� (2, 0) �����԰�ֵ��С��������5 �� 6 ��ǰ�档
 * ��  1 ��ֻ�н�� 3 �ڴ����С�
 * ��  2 ��ֻ�н�� 7 �ڴ����С�
 * ʾ�� 3��
 *
 *
 * ���룺root = [1,2,3,4,6,5,7]
 * �����[[4],[2],[1,5,6],[3],[7]]
 * ���ͣ�
 * ���ʾ��ʵ������ʾ�� 2 ��ȫ��ͬ��ֻ�ǽ�� 5 �� 6 �����е�λ�÷����˽�����
 * ��Ϊ 5 �� 6 ��λ����Ȼ��ͬ�����Դ𰸱��ֲ��䣬��Ȼ��ֵ��С��������
 */
class Solution10 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> groups = new TreeMap<>();
        dfs(root, 0, 0, groups);

        List<List<Integer>> ans = new ArrayList<>(groups.size());
        for(List<int[]> g : groups.values()){
            g.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); // compartor�Ƚ���
            List<Integer> vals = new ArrayList<>(g.size());
            for(int[] p : g){
                vals.add(p[1]);
            }
            ans.add(vals);
        }
        return ans;
    }
    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> groups){
        if(node == null){
            return;
        }
        // col ��ͬ�ֵ�ͬһ��
        groups.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val}); // ����ָ���ļ���ȡ��Ӧ��ֵ
        // ÿ���µݹ�һ�㣬row ��һ
        dfs(node.left, row + 1, col - 1, groups);
        dfs(node.right, row + 1, col + 1, groups);
    }
}
