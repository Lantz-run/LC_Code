package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra20
 * <p>Powered by Lantz On 2024-04-20 19:49:15
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra20
 * @since 1.8
 */
public class Pra20 {

}

/**
 * 39. ����ܺ�
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target ���ҳ� candidates �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ��� ��
 * �����б���ʽ���ء�����԰� ����˳�� ������Щ��ϡ�
 *
 * candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 *
 * ���ڸ��������룬��֤��Ϊ target �Ĳ�ͬ��������� 150 ����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺candidates = [2,3,6,7], target = 7
 * �����[[2,2,3],[7]]
 * ���ͣ�
 * 2 �� 3 �����γ�һ���ѡ��2 + 2 + 3 = 7 ��ע�� 2 ����ʹ�ö�Ρ�
 * 7 Ҳ��һ����ѡ�� 7 = 7 ��
 * ������������ϡ�
 * ʾ�� 2��
 *
 * ����: candidates = [2,3,5], target = 8
 * ���: [[2,2,2,2],[2,3,3],[3,5]]
 * ʾ�� 3��
 *
 * ����: candidates = [2], target = 1
 * ���: []
 */
class Solution20 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // ���ڹ���������������ڼ�֦
        dfs(0, 0, target, candidates);
        return ans;
    }

    private void dfs(int i, int s, int target, int[] candidates){
        int n = candidates.length;
        if(s == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(i == n || s > target){
            return;
        }
        path.add(candidates[i]);
        dfs(i, s + candidates[i], target, candidates);
        path.remove(path.size() - 1);
        dfs(i + 1, s, target, candidates);

    }
}
