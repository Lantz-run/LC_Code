package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra21
 * <p>Powered by Lantz On 2024-02-24 16:26:48
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra21
 * @since 1.8
 */
public class Pra21 {

}

/**
 * 2476. ��������������ڵ��ѯ
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�� ���������� �ĸ��ڵ� root ����һ������������ɡ�����Ϊ n ������ queries ��
 *
 * �����ҳ�һ������Ϊ n �� ��ά ������ answer ������ answer[i] = [mini, maxi] ��
 *
 * mini ������С�ڵ��� queries[i] �� ���ֵ �����������������ֵ����ʹ�� -1 ���档
 * maxi �����д��ڵ��� queries[i] �� ��Сֵ �����������������ֵ����ʹ�� -1 ���档
 * �������� answer ��
 *
 *
 *
 * ʾ�� 1 ��
 *
 *
 *
 * ���룺root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * �����[[2,2],[4,6],[15,-1]]
 * ���ͣ�������������ҳ������ز�ѯ�Ĵ𰸣�
 * - ����С�ڵ��� 2 �����ֵ�� 2 ���Ҵ��ڵ��� 2 ����СֵҲ�� 2 �����Ե�һ����ѯ�Ĵ��� [2,2] ��
 * - ����С�ڵ��� 5 �����ֵ�� 4 ���Ҵ��ڵ��� 5 ����Сֵ�� 6 �����Եڶ�����ѯ�Ĵ��� [4,6] ��
 * - ����С�ڵ��� 16 �����ֵ�� 15 ���Ҵ��ڵ��� 16 ����Сֵ�����ڡ����Ե�������ѯ�Ĵ��� [15,-1] ��
 * ʾ�� 2 ��
 *
 *
 *
 * ���룺root = [4,null,9], queries = [3]
 * �����[[-1,4]]
 * ���ͣ����в�����С�ڵ��� 3 �����ֵ���Ҵ��ڵ��� 3 ����Сֵ�� 4 �����Բ�ѯ�Ĵ��� [-1,4] ��
 */
class Solution21 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);

        int n = res.size();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = res.get(i); // ת�����飬Ч�ʸ���
        }

        List<List<Integer>> ans = new ArrayList<>(queries.size()); // Ԥ����ռ�
        for(int q : queries){
            int j = lowerBound(a, q); // ���� j �Ǵ��ڵ��� q = queries[i] �ĵ�һ�������±�, ����������� j = n
            int mx = j == n ? -1 : a[j];
            if(j == n || a[j] != q){
                j--;
            }
            int mn = j < 0 ? -1 : a[j];
            ans.add(List.of(mn, mx));
        }
        return ans;
    }
    private void dfs(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
    // ���ֲ���
    private int lowerBound(int[] a, int target){
        int left = -1, right = a.length; // ������ (left, right)
        while(left + 1 < right){ // ���䲻Ϊ��
            int mid = (left + right) >>> 1; // λ���㣬����������һλ
            if(a[mid] >= target){
                right = mid; // ��Χ��С�� (left, mid)
            } else {
                left = mid; // ��Χ��С�� (mid, right)
            }
        }
        return right;
    }
}
