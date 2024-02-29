package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra09
 * <p>Powered by Lantz On 2024-02-12 09:03:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra09
 * @since 1.8
 */
public class Pra09 {

}

/**
 * 145. �������ĺ������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ�ö������ĸ��ڵ� root ��������ڵ�ֵ�� ������� ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,null,2,3]
 * �����[3,2,1]
 * ʾ�� 2��
 *
 * ���룺root = []
 * �����[]
 * ʾ�� 3��
 *
 * ���룺root = [1]
 * �����[1]
 */
class Solution09 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }
    private void dfs(List<Integer> res, TreeNode root){
        if(root == null) return;
        dfs(res, root.left);
        dfs(res, root.right);
        res.add(root.val);
    }
}
