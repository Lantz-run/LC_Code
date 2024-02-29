package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2024-02-10 22:29:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 */
public class Pra07 {

}

/**
 * 94. ���������������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ���������ĸ��ڵ� root ������ ���� ���� ���� ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,null,2,3]
 * �����[1,3,2]
 * ʾ�� 2��
 *
 * ���룺root = []
 * �����[]
 * ʾ�� 3��
 *
 * ���룺root = [1]
 * �����[1]
 */
class Solution07 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }
    // �����������-��ӡ-��
    private void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}