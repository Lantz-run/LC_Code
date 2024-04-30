package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra21
 * <p>Powered by Lantz On 2024-04-21 14:57:16
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra21
 * @since 1.8
 */
public class Pra21 {
}

/**
 * 216. ����ܺ� III
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * �ҳ��������֮��Ϊ n �� k ��������ϣ�����������������
 *
 * ֻʹ������1��9
 * ÿ������ ���ʹ��һ��
 * ���� ���п��ܵ���Ч��ϵ��б� �����б��ܰ�����ͬ��������Σ���Ͽ������κ�˳�򷵻ء�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: k = 3, n = 7
 * ���: [[1,2,4]]
 * ����:
 * 1 + 2 + 4 = 7
 * û���������ϵ�����ˡ�
 * ʾ�� 2:
 *
 * ����: k = 3, n = 9
 * ���: [[1,2,6], [1,3,5], [2,3,4]]
 * ����:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * û���������ϵ�����ˡ�
 * ʾ�� 3:
 *
 * ����: k = 4, n = 1
 * ���: []
 * ����: ��������Ч����ϡ�
 * ��[1,9]��Χ��ʹ��4����ͬ�����֣����ǿ��Եõ�����С����1+2+3+4 = 10����Ϊ10 > 1��û����Ч�����
 */
class Solution21 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(9, n);
        return ans;
    }

    private void dfs(int i, int t){
        int d = k - path.size();
        // ��֦
        if(t < 0 || t > (i * 2 - d + 1) * d / 2)
            return;
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j >= d; j--){
            path.add(j);
            dfs(j - 1, t - j);
            path.remove(path.size() - 1);
        }
    }
}
