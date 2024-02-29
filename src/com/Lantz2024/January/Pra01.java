package com.Lantz2024.January;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2024-01-05 15:19:51
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 *
 */
public class Pra01 {
    public static void main(String[] args) {

    }
}

/**
 * 78. �Ӽ�
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3]
 * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * ʾ�� 2��
 *
 * ���룺nums = [0]
 * �����[[],[0]]
 */
class Solution01 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        // ѡnums[i]
        dfs(i+1);
        // ��ѡnums[i]
        path.add(nums[i]);
        dfs(i+1);
        path.remove(path.size()-1);

    }
}
