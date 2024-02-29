package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra08
 * <p>Powered by Lantz On 2024-02-11 23:15:54
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra08
 * @since 1.8
 */
public class Pra08 {

}

/**
 * 144. ��������ǰ�����
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����������ĸ��ڵ� root ���������ڵ�ֵ�� ǰ�� ������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,null,2,3]
 * �����[1,2,3]
 * ʾ�� 2��
 *
 * ���룺root = []
 * �����[]
 * ʾ�� 3��
 *
 * ���룺root = [1]
 * �����[1]
 * ʾ�� 4��
 *
 *
 * ���룺root = [1,2]
 * �����[1,2]
 * ʾ�� 5��
 *
 *
 * ���룺root = [1,null,2]
 * �����[1,2]
 */
class Solution08 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }
    private void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        dfs(res, root.left);
        dfs(res, root.right);

    }
}
