package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra16
 * <p>Powered by Lantz On 2024-02-19 09:26:06
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra16
 * @since 1.8
 */
public class Pra16 {

}
// �����������-��-��ӡ

/**
 * 590. N �����ĺ������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ�� n �����ĸ��ڵ� root ������ ��ڵ�ֵ�� ������� ��
 *
 * n ���� �������а���������������л���ʾ��ÿ���ӽڵ��ɿ�ֵ null �ָ�����μ�ʾ������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [1,null,3,2,4,null,5,6]
 * �����[5,6,3,2,4,1]
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * �����[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 */
class Solution16 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    private void dfs(Node node, List<Integer> ans){
        if(node == null) return;
        for(Node n : node.children){
            dfs(n, ans);
        }
        ans.add(node.val);
    }
}
